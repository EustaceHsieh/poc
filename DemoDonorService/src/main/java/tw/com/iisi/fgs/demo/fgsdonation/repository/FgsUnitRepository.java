package tw.com.iisi.fgs.demo.fgsdonation.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tw.com.iisi.fgs.demo.fgsdonation.entity.FgsUnit;

@Repository
public interface FgsUnitRepository extends PagingAndSortingRepository<FgsUnit, Integer> {

    @Query(value = "SELECT FgsUnitName FROM FgsUnit WHERE FgsUnitID = :fgsUnitID", nativeQuery = true)
    String findByDonorName(@Param("fgsUnitID") String fgsUnitID);
}
