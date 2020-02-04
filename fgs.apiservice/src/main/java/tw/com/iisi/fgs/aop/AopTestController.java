package tw.com.iisi.fgs.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import tw.com.iisi.fgs.commons.util.IHeader;
import tw.com.iisi.fgs.commons.util.IMessage;
import tw.com.iisi.fgs.commons.util.IRequest;
import tw.com.iisi.fgs.commons.util.ITraceLog;

@Aspect
@Component
public class AopTestController {
	
	private static final Logger logger = LoggerFactory.getLogger(AopTestController.class);
	
	@Pointcut("execution(* tw.com.iisi.fgs.controller..*(..))")
    private void controllerMethodAspect() {
    }
	
	@Around(value = "controllerMethodAspect()")
	public Object cutOffPoint(ProceedingJoinPoint pjp) throws Throwable{
		
		// 進入交易時間
		Date sysDate = new Date();

		// 執行交易
		Object result = pjp.proceed();
		
		if (result instanceof ResponseEntity<?>) {
			
			ResponseEntity<?> entity = (ResponseEntity<?>)result;
			
			if (entity.getBody() instanceof IMessage) {
				IMessage message = (IMessage) entity.getBody();
				
				// 交易花費時間
				ITraceLog log = (ITraceLog)message;
				log.setEndTime(new Date());
				log.setStartTime(sysDate);
				
				// WEB傳進來的請求資料
				IRequest request = (IRequest) message;
				request.setRequest(pjp.getArgs());
				
				// 狀態與結果
				IHeader header = (IHeader)message;
				header.setStatus("OK");
				
			}
		}
		
		return result;
    }

}
