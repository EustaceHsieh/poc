package tw.com.iisi.fgs.dao.fgsdonation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tw.com.iisi.fgs.bo.fgsdonation.FgsUnit;

@Repository
public interface FgsUnitRepository extends PagingAndSortingRepository<FgsUnit, Integer> {

    @Query(value = "SELECT FgsUnitName FROM FgsUnit WHERE FgsUnitID = :fgsUnitID", nativeQuery = true)
    String findByDonorName(@Param("fgsUnitID") String fgsUnitID);
    
    FgsUnit getByFgsUnitID(String fgsUnitID);
}
