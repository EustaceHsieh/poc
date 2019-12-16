package tw.com.iisi.fgs.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import tw.com.iisi.fgs.demo.fgsdonation.entity.FgsUnitMapping;
import tw.com.iisi.fgs.demo.fgsdonation.repository.FgsUnitMappingRepository;

@Service
public class FgsUnitMappingService {
    @Autowired
    private FgsUnitMappingRepository fgsUnitMappingRepository;
	 
    @Transactional
    public void saveFgsUnitMappings(List<FgsUnitMapping> fgsUnitMappings) {
        if(!CollectionUtils.isEmpty(fgsUnitMappings)) {
        	fgsUnitMappingRepository.deleteAll();
        	fgsUnitMappingRepository.saveAll(fgsUnitMappings);
        }
    }
}
