package web.mvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionAdvice {
	@ExceptionHandler(MyErrorException.class)
	public ModelAndView error(MyErrorException e) {
		ModelAndView mv =new ModelAndView("error");
		mv.addObject("errStatus", e.getError().getCode());
		mv.addObject("errMessage", e.getError().getMsg());
		return mv;
	}
}
