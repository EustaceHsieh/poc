package tw.com.iisi.fgs.controller.inq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import tw.com.iisi.fgs.bo.fgsdonation.FgsUnit;
import tw.com.iisi.fgs.commons.util.IResult;
import tw.com.iisi.fgs.commons.util.MessageResult;
import tw.com.iisi.fgs.service.FgsUnitService;

@RestController
@RequestMapping("/api/inq")
@Tag(name="InqDonationController", description = "InqDonationController API")
public class InqDonationController {
	
	@Autowired
	private FgsUnitService fgsUnitService;
	
	@GetMapping("/inqDonationThrowingError")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "取得捐款資料") })
	@Operation(summary ="測試ThrowingError", description = "描述：測試ThrowingError")
	public ResponseEntity<IResult<FgsUnit>> getTestThrowingError(
			@RequestParam(value = "fgsUnitID", defaultValue = "")String fgsUnitID) {
		
		fgsUnitID = null;
		if(true) {
			fgsUnitID.trim();
		}
		
		return new ResponseEntity<IResult<FgsUnit>>(new MessageResult<FgsUnit>(), HttpStatus.OK);

	}
	
	@GetMapping("/inqDonation")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "取得捐款資料") })
	@Operation(summary ="測試ThrowingError", description = "描述：測試ThrowingError")
	public ResponseEntity<IResult<FgsUnit>> getData(
			@RequestParam(value = "fgsUnitID", defaultValue = "")String fgsUnitID) {
		
		IResult<FgsUnit> result = new MessageResult<FgsUnit>();
		result.setResult(fgsUnitService.getFgsUnitByFgsUnitID(fgsUnitID));
		
		return new ResponseEntity<IResult<FgsUnit>>(result, HttpStatus.OK);

	}

}
