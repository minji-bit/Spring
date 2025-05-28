package web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.mvc.service.UserService;

@Controller
@Slf4j  //lombok 이 log 를 만들어준다.
@RequiredArgsConstructor
public class ExceptionController {
	private final UserService userService;
	/**
	 * Spring Web MVC 에서 예외처리
	 * 1) 각 Controller 에서 발생하는 예외 처리
	 *   @ExceptionHandler
	 *   
	 * 2) global 하게 전체 영역에서 발생하는 예외처리
	 *   @ControllerAdvice -> http통신 -> @Controller
	 *   
	 *   @RestControllerAdvice -> 비동기통신 = ajax 처리(XMLHttpRequest통신) -> @RestController
	 * @param no
	 * @return
	 */
	
	@RequestMapping("/exception.do")
	public String aa(String no) {
		log.info("no={}",no);
		
		int convertNo = Integer.parseInt(no);
		log.info("convertNo={}",convertNo);
		
		int result = 100/convertNo;
		log.info("나눈결과 : {}",result);
		
		return "result";
	}
	
	@RequestMapping("/ageCheck.do")
	public String ageError(Integer age) {
		log.info("age={}",age);
		//서비스호출
		userService.ageCheck(age);
		
		return "result";
	}
	
	@RequestMapping("/idCheck.do")
	public String idError(String id) {
		log.info("id={}",id);
		//서비스호출
		userService.idCheck(id);
		
		return "result";
	}
	
	/**
	 * 현재 컨트롤러에서 발생하는 예외처리
	 */
	@ExceptionHandler ({NumberFormatException.class,ArithmeticException.class})
//	@ExceptionHandler (Exception.class)
	public ModelAndView error(Exception e) {
		
		log.error("메시지 :{}",e.getMessage());
		ModelAndView mv = new ModelAndView("error/error-view"); //WEB-INF/views/error/error-view.jsp
		mv.addObject("errMsg",e.getMessage()); 
		mv.addObject("statusCode",HttpStatus.BAD_REQUEST); // 400 bad request
		
		mv.addObject("errClass",e.getClass().getName());
		
		return mv;
	}
	
	
}
