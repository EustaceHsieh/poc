package tw.com.iisi.fgs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.com.iisi.fgs.demo.fgsdonation.entity.FgsUnitMapping;
import tw.com.iisi.fgs.demo.service.FgsUnitMappingService;
import tw.com.iisi.fgs.demo.service.FgsUnitService;

/*@CrossOrigin(value="http://localhost:8080", maxAge=180)*/
@RestController
@RequestMapping("/api")
public class FgsUnitController {
    @Autowired
    private FgsUnitService fgsUnitService;
    @Autowired
    private FgsUnitMappingService fgsUnitMappingService;

    @GetMapping("/getFgsUnitNameById/")
    public ResponseEntity<String> getFgsUnitNameByID(
    		@RequestParam(value = "fgsUnitID", defaultValue = "") String fgsUnitID)
        throws ResourceNotFoundException {
    	return ResponseEntity.ok().body(fgsUnitService.getFgsUnitNameByID(fgsUnitID));
    }

    @PostMapping("/saveFgsUnitMappings/")
    public void saveFgsUnits(
    		@RequestBody List<FgsUnitMapping> fgsUnitMappings)
        throws ResourceNotFoundException {
    	fgsUnitMappingService.saveFgsUnitMappings(fgsUnitMappings);
    }
}
