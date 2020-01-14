package tw.com.iisi.fgs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import tw.com.iisi.fgs.bo.fgsdonation.FgsUnitMapping;
import tw.com.iisi.fgs.service.FgsUnitMappingService;
import tw.com.iisi.fgs.service.FgsUnitService;

@RestController
@RequestMapping("/api/FgsUnit")
public class FgsUnitController {
	
	private static final Logger log = LoggerFactory.getLogger(FgsUnitController.class);
	
    @Autowired
    private FgsUnitService fgsUnitService;
    @Autowired
    private FgsUnitMappingService fgsUnitMappingService;
    
    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @GetMapping("/getFgsUnitNameById/")
    public ResponseEntity<String> getFgsUnitNameByID(
    		@RequestParam(value = "fgsUnitID", defaultValue = "") String fgsUnitID)
        throws ResourceNotFoundException {
    	
    	log.debug("======Running service instance id: "+instanceId);
    	
    	return ResponseEntity.ok().body(fgsUnitService.getFgsUnitNameByID(fgsUnitID));
    }

    @PostMapping("/saveFgsUnitMappings/")
    public void saveFgsUnits(
    		@RequestBody List<FgsUnitMapping> fgsUnitMappings)
        throws ResourceNotFoundException {
    	fgsUnitMappingService.saveFgsUnitMappings(fgsUnitMappings);
    }
}
