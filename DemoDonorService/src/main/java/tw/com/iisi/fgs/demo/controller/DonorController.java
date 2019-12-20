package tw.com.iisi.fgs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.com.iisi.fgs.demo.fgsdonation.entity.Donor;
import tw.com.iisi.fgs.demo.fgsdonation.projection.DonorInfo;
import tw.com.iisi.fgs.demo.personlib.entity.ImportDonation;
import tw.com.iisi.fgs.demo.service.CrossDatabaseService;
import tw.com.iisi.fgs.demo.service.DonorService;

@RestController
@RequestMapping("/api")
public class DonorController {
    @Autowired
    private DonorService donorService;
    @Autowired
    private CrossDatabaseService crossDatabaseService;


    @GetMapping("/multidbtest/")
    public void testMultiDBs()
        throws ResourceNotFoundException {
    	crossDatabaseService.insertIntoMultipleDBs();
    }

    @GetMapping("/multidbtestfailed/")
    public void testMultiDBsFailed()
        throws ResourceNotFoundException {
    	crossDatabaseService.insertIntoMultipleDBsFailed();
    }

    @GetMapping("/donornames/")
    public ResponseEntity<List<String>> getDonorNames()
        throws ResourceNotFoundException {
        return ResponseEntity.ok().body(donorService.listDonorNameByConditions());
    }

/*    @GetMapping("/donors/{donorSN}")*/
    @GetMapping("/donors/")
    public ResponseEntity<Iterable<Donor>> getDonorBySN(
/*    		@PathVariable(value = "donorSN") String donorSN,*/
    		@RequestParam(value = "type", defaultValue = "0") Integer type,
    		@RequestParam(value = "key", defaultValue = "") String key,
    		@RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "20") Integer size)
        throws ResourceNotFoundException {
    	
    	Iterable<Donor> donors = null;
    	switch(type) {
    	case 1:
        	donors = donorService.findDonorByName(key, page, size);
    		break;
    	default:
        	donors = donorService.findDonorBySN(key, page, size);
    		break;
    	}
        return ResponseEntity.ok().body(donors);
    }
    
    @GetMapping("/donorinfos/")
    public ResponseEntity<List<DonorInfo>> getDonorInfoByCondition(
    		@RequestParam(value = "type", defaultValue = "0") Integer type,
    		@RequestParam(value = "name", defaultValue = "") String key)
        throws ResourceNotFoundException {
    	
    	switch(type) {
    	case 1:
            return ResponseEntity.ok().body(donorService.findDonorInfoByDonationSN(key));
    	default:
            return ResponseEntity.ok().body(donorService.findDonorInfoByName(key));
    	}
    }

    @GetMapping("/importDonations/")
    public ResponseEntity<Iterable<ImportDonation>> getImportDonationBySN(
/*    		@PathVariable(value = "donorSN") String donorSN,*/
    		@RequestParam(value = "importDonationSN", defaultValue = "") String importDonationSN,
    		@RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "20") Integer size)
        throws ResourceNotFoundException {
    	Iterable<ImportDonation> employee = donorService.listImportDonation(importDonationSN, page, size);
        return ResponseEntity.ok().body(employee);
    }
}
