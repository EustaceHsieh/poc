package tw.com.iisi.fgs.demo.fgsdonation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tw.com.iisi.fgs.demo.fgsdonation.entity.FgsUnitMapping;

@Repository
public interface FgsUnitMappingRepository extends CrudRepository<FgsUnitMapping, Integer> {
}
