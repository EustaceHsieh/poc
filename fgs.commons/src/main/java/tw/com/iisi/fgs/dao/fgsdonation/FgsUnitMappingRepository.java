package tw.com.iisi.fgs.dao.fgsdonation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tw.com.iisi.fgs.bo.fgsdonation.FgsUnitMapping;

@Repository
public interface FgsUnitMappingRepository extends CrudRepository<FgsUnitMapping, Integer> {
}
