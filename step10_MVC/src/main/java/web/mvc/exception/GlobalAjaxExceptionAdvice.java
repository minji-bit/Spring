package web.mvc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import web.mvc.response.ResponseError;
@Slf4j
@RestControllerAdvice//A convenience annotation that is itself annotated with @ControllerAdviceand @ResponseBody. 
public class GlobalAjaxExceptionAdvice {
	@ExceptionHandler(AjaxException.class)
	public ResponseEntity<?> error(AjaxException e){
		log.error("AjaxException error...");
		ErrorInfo errorInfo = e.getErrorInfo();
		ResponseError re = new ResponseError(errorInfo.getStatus(), errorInfo.getMsg());
		
		return ResponseEntity.status(errorInfo.getStatus()).body(re);
	}
}
