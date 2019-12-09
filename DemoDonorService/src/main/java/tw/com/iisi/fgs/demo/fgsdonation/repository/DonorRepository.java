package tw.com.iisi.fgs.demo.fgsdonation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tw.com.iisi.fgs.demo.fgsdonation.entity.Donor;
import tw.com.iisi.fgs.demo.fgsdonation.projection.DonorInfo;

@Repository
public interface DonorRepository extends PagingAndSortingRepository<Donor, Integer> {

	Page<Donor> findAll(Pageable pageable);
	Page<Donor> findByDonorSN(String donorSN, Pageable pageable);
	
    @Query(value = "SELECT * FROM Donor WHERE DonorName = :name", nativeQuery = true)
    List<Donor> findByDonorName(@Param("name") String name, Pageable pageable);
	
    @Query(value = "SELECT DonorName, Birthday, Address FROM Donor WHERE DonorName = :name", nativeQuery = true)
    List<DonorInfo> findByDonorName(@Param("name") String name);
	
    @Query(value = "SELECT d.DonorName, d.Birthday, d.Address FROM Donor as d inner join Donation as don on d.DonorKey = don.DonorKey  WHERE don.DonationSN = :donationSN", 
    		nativeQuery = true)
    List<DonorInfo> findByDonationSN(@Param("donationSN") String donationSN);
}
