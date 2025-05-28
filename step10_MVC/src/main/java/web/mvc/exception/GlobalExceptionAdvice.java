package web.mvc.exception;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * 프로젝트 전체에서 발생하는 예외를 모아서 처리하는 클래스
 */
@ControllerAdvice
@Slf4j 
public class GlobalExceptionAdvice {
	public GlobalExceptionAdvice() {
		System.out.println("dddddddddd");
		log.info("GlobalExceptionAdvice 생성되었어요~~");
	}
	@PostConstruct
	public void bb() {
		log.info("GlobalExceptionAdvice 생성되었어요~~");
		
	}
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView error(NumberFormatException e) {
		log.error("e={}",e);
		return new ModelAndView("error/number","errMsg",e.getMessage());
	}
	/**
	 * BasicException에 대한 처리
	 */
	@ExceptionHandler(BasicException.class)
	public ModelAndView error3(BasicException e) {
		log.error("error3={}",e.getErrorInfo().getMsg());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/basic-error");
		mv.addObject("status",e.getErrorInfo().getStatus());
		mv.addObject("msg",e.getErrorInfo().getMsg());
		mv.addObject("errorInfo",e.getErrorInfo());
		
		return mv;
		
	}
	
}
