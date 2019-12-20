package tw.com.iisi.fgs.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.iisi.fgs.demo.fgsdonation.repository.FgsUnitRepository;
import tw.com.iisi.fgs.util.StringUtils;


@Service
public class FgsUnitService {
    @Autowired
    private FgsUnitRepository fgsUnitRepository;
	 
    public String getFgsUnitNameByID(String fgsUnitID) {
        return StringUtils.isNotBlank(fgsUnitID)? fgsUnitRepository.findByDonorName(fgsUnitID) : "";
    }
}