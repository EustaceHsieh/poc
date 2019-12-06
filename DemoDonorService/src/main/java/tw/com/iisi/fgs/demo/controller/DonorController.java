package tw.com.iisi.fgs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.com.iisi.fgs.demo.bo.Donor;
import tw.com.iisi.fgs.demo.service.DonorService;

@RestController
@RequestMapping("/api")
public class DonorController {
    @Autowired
    private DonorService donorService;

/*
    @GetMapping("/donors/")
    public ResponseEntity<Iterable<Donor>> getDonors()
        throws ResourceNotFoundException {
    	Iterable<Donor> employee = donorService.list();
        return ResponseEntity.ok().body(employee);
    }
*/
/*    @GetMapping("/donors/{donorSN}")*/
    @GetMapping("/donors/")
    public ResponseEntity<Iterable<Donor>> getDonorBySN(
/*    		@PathVariable(value = "donorSN") String donorSN,*/
    		@RequestParam(value = "donorSN", defaultValue = "") String donorSN,
    		@RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "20") Integer size)
        throws ResourceNotFoundException {
    	Iterable<Donor> employee = donorService.findBySN(donorSN, page, size);
        return ResponseEntity.ok().body(employee);
    }

}
