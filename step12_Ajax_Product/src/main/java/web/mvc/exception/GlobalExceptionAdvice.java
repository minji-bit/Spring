package web.mvc.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import web.mvc.response.ResponseError;

@RestControllerAdvice
public class GlobalExceptionAdvice {
	@ExceptionHandler(MyErrorException.class)
	public ResponseEntity<?> error(MyErrorException e) {
		ResponseError re = new ResponseError(e.getError().getCode(),e.getError().getMsg());  
		
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(re.getMsg(), resHeaders, re.getStatus());
		//return ResponseEntity.status(re.getStatus()).body(re.getMsg());
	}
}
