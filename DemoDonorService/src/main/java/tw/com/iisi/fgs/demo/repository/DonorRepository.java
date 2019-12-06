package tw.com.iisi.fgs.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import tw.com.iisi.fgs.demo.bo.Donor;

@Repository
public interface DonorRepository extends PagingAndSortingRepository<Donor, Integer> {

	Page<Donor> findAll(Pageable pageable);
	Page<Donor> findByDonorSN(String donorSN, Pageable pageable);
}
