package tw.com.iisi.fgs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.iisi.fgs.commons.util.IHeader;
import tw.com.iisi.fgs.commons.util.MessageResult;

@RestController
public class NoHandlerFoundController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoHandlerFoundController.class);

	@RequestMapping(value= {"/*", "/**/*"})
	public ResponseEntity<IHeader> handleNotFound() {
		
		logger.error("查無相關資源");

		IHeader header = new MessageResult<>();
		header.setStatus("Fail");
		header.setErrorCode("HTTP 404");
		header.setErrorMessage("查無相關資源");

		return new ResponseEntity<IHeader>(header, HttpStatus.BAD_REQUEST);

	}

}
