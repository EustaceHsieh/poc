package tw.com.iisi.fgs.controller;

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
@RequestMapping("/api/HelloWorld")
@Tag(name="HelloWorldController", description = "Hello-World-Controller API")
public class HelloWorldController {

	@Autowired
	private FgsUnitService fgsUnitService;

	@GetMapping("/sayHello")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "取得Hello文字") })
	@Operation(summary ="取得Hello文字", description = "描述：取得Hello文字")
	public ResponseEntity<String> getHello() {
		return new ResponseEntity<String>("Hello", HttpStatus.OK);
	}

	@GetMapping("/getFgsUnit")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "取得單位資料") })
	@Operation(summary ="取得單位資料", description = "描述：取得單位資料")
	public ResponseEntity<FgsUnit> getFgsUnit(
			@RequestParam(value = "fgsUnitID", defaultValue = "")String fgsUnitID) {

		return new ResponseEntity<FgsUnit>(fgsUnitService.getFgsUnitByFgsUnitID(fgsUnitID), HttpStatus.OK);

	}
	
	@GetMapping("/getFgsUnit2")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "取得單位資料") })
	@Operation(summary ="取得單位資料", description = "描述：取得單位資料")
	public ResponseEntity<IResult<FgsUnit>> getTest(
			@RequestParam(value = "fgsUnitID", defaultValue = "")String fgsUnitID) {
		
		IResult<FgsUnit> result = new MessageResult<FgsUnit>();
		result.setResult(fgsUnitService.getFgsUnitByFgsUnitID(fgsUnitID));
		
		return new ResponseEntity<IResult<FgsUnit>>(result, HttpStatus.OK);

	}
	
	@GetMapping("/ThrowingError")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "取得單位資料") })
	@Operation(summary ="取得單位資料", description = "描述：取得單位資料")
	public ResponseEntity<IResult<FgsUnit>> getTestThrowingError(
			@RequestParam(value = "fgsUnitID", defaultValue = "")String fgsUnitID) {
		
		fgsUnitID = null;
		if(true) {
			fgsUnitID.trim();
		}
		
		IResult<FgsUnit> result = new MessageResult<FgsUnit>();
		result.setResult(fgsUnitService.getFgsUnitByFgsUnitID(fgsUnitID));
		
		return new ResponseEntity<IResult<FgsUnit>>(result, HttpStatus.OK);

	}

}
