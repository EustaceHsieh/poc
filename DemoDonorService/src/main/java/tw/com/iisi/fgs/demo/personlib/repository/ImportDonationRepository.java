package tw.com.iisi.fgs.demo.personlib.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import tw.com.iisi.fgs.demo.personlib.entity.ImportDonation;

@Repository
public interface ImportDonationRepository extends PagingAndSortingRepository<ImportDonation, Integer> {

	Page<ImportDonation> findAll(Pageable pageable);
}
