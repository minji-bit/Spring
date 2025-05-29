package web.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;
@RestController //A convenience annotation that is itself annotated with @Controller and @ResponseBody. 
//@Controller
@Slf4j
public class ResponseBodyController {
	@GetMapping("/responseBody.do")
	//@ResponseBody
	public String aa() {
		log.info("responseBody.do 요청됨...");
		return "Have a nice day!";
	}
	
	@GetMapping(value="/responseBody2.do", produces = {"text/html;charset=UTF-8"})
	//@ResponseBody
	public String bb() {
		log.info("responseBody2.do 요청됨...");
		return "안녕안녕 hihi";
	}
	/**
	 * 자바의 객체를 ResponseBody으로 응답하기 위해서는
	 * json 변환이 필요하다. spring에서는 jackson-databind 라이브러리
	 * 이용해서 json으로 자동 변환한다.
	 */
	@GetMapping("/responseBody3.do")
	public ProductDTO cc() {
		log.info("responseBody3.do 요청됨...");
		return ProductDTO.builder().code("A01").detail("맛있다").name("썬칩").price(2000).build();
	}
}
