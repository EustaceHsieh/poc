package tw.com.iisi.fgs.commons.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<IHeader> handlerException(Exception exception) {

		logger.error("未知的錯誤", exception);

		IHeader header = new MessageResult<>();
		header.setStatus("Faill");
		header.setErrorCode("ErrorCode:XXX");
		header.setErrorMessage("系統發生錯誤");

		return new ResponseEntity<IHeader>(header, HttpStatus.OK);

	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<IHeader> handlerNullPointerException(NullPointerException exception) {
		
		logger.error("未知的錯誤：NullPointerException", exception);

		IHeader header = new MessageResult<>();
		header.setStatus("Faill");
		header.setErrorCode("NullPointerException");
		header.setErrorMessage("NullPointerException");

		return new ResponseEntity<IHeader>(header, HttpStatus.BAD_REQUEST);
	}

}
