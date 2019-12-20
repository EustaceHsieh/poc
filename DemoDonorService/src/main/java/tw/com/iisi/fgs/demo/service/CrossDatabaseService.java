package tw.com.iisi.fgs.demo.service;


import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.iisi.fgs.demo.fgsdonation.entity.FgsUnitMapping;
import tw.com.iisi.fgs.demo.fgsdonation.repository.FgsUnitMappingRepository;
import tw.com.iisi.fgs.demo.personlib.entity.ImportDonation;
import tw.com.iisi.fgs.demo.personlib.repository.ImportDonationRepository;

@Service
public class CrossDatabaseService {
	
	private static Logger log = Logger.getLogger(CrossDatabaseService.class);
	
    @Autowired
    private FgsUnitMappingRepository fgsUnitMappingRepository;
    @Autowired
    private ImportDonationRepository impoerDonaationRepository;

	@Transactional (value = "chainedTransactionManager", rollbackFor = Exception.class)
	public void insertIntoMultipleDBs(){
		FgsUnitMapping donor = fgsUnitMappingRepository.findAll().iterator().next();
		FgsUnitMapping newDonor = new FgsUnitMapping();
		BeanUtils.copyProperties(donor, newDonor);
		
		newDonor.setFgsUnitMappingKey(null);
		newDonor.setTwFgsUnitID("AAA000");

		log.info("new FgsUnitMapping tw id: "+newDonor.getTwFgsUnitID());
		
		ImportDonation idon = impoerDonaationRepository.findAll().iterator().next();
		ImportDonation ndon = new ImportDonation();
		
		BeanUtils.copyProperties(idon, ndon);
		ndon.setImportDonationKey(null);
		ndon.setDonationSN(idon.getDonationSN().trim().substring(0, 8).concat("_TEST"));
		log.info("new ImportDonation sn: "+ndon.getDonationSN());
		
		fgsUnitMappingRepository.save(newDonor);
		impoerDonaationRepository.save(ndon);
	}

	@Transactional (value = "chainedTransactionManager", rollbackFor = Exception.class)
	public void insertIntoMultipleDBsFailed(){
		FgsUnitMapping donor = fgsUnitMappingRepository.findAll().iterator().next();
		FgsUnitMapping newDonor = new FgsUnitMapping();
		BeanUtils.copyProperties(donor, newDonor);
		
		newDonor.setFgsUnitMappingKey(null);
		newDonor.setTwFgsUnitID("AAA000");

		log.info("new FgsUnitMapping tw id: "+newDonor.getTwFgsUnitID());
		
		ImportDonation idon = impoerDonaationRepository.findAll().iterator().next();
		ImportDonation ndon = new ImportDonation();
		
		BeanUtils.copyProperties(idon, ndon);
		ndon.setImportDonationKey(null);
		ndon.setDonationSN(idon.getDonationSN().trim().substring(0, 8).concat("_TEST"));
		log.info("new ImportDonation sn: "+ndon.getDonationSN());
		
		fgsUnitMappingRepository.save(newDonor);
		impoerDonaationRepository.save(ndon);
		
		throw new RuntimeException("test exception");
	}
}
