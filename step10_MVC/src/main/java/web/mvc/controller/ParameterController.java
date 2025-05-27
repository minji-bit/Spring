package web.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.UserDto;

@Controller
@RequestMapping("/param")
@Slf4j
public class ParameterController {
	@RequestMapping("/a.do")
//	public String aa(String name, int age) {
	public String aa(String name, Integer age) {

		log.info("name={}, age={}", name, age);
		System.out.println("name=" + name);
		System.out.println("age=" + age);

		return "result";
	}
	
	@RequestMapping("/b.do")
	public String bb(@RequestParam(defaultValue = "Guest", value = "userId") String id, @RequestParam(defaultValue ="0") int age) {
//		public String bb(@RequestParam(defaultValue = "Guest") String id, @RequestParam(defaultValue ="0") int age) {
		log.info("id={}, age={}",id,age);
		return "result";
	}
	/**
	 * parameter로 전달된 정보를 객체로 바인딩했을 때는
	 * 전달된 객체를 view에 가서 사용 할 수 있다.
	 * 방법 : ${객체이름.속성} - 객체이름은 클래스의 첫글자를 소문자
	 * 
	 * 만약, @ModelAttribute("dto")를 인수에 선언하면 ${dto.속성} 사용
	 * @param userDto
	 * @return
	 */
	@PostMapping("/user.do")
	public String user(@ModelAttribute("dto") UserDto userDto) { //setter 로 주입된다. //view에서 ${userDto.속성}으로 사용가능
		log.info("dto={}",userDto);
		return "user-result";
	}
	@ModelAttribute("msg") //뷰에서 ${msg}
	public String test() {
		return "잘 되니??";
	}
	@ModelAttribute("menu") //뷰에서 ${menu}
	public List<String> test2(){
		return Arrays.asList("짜장","짬뽕","탕수육");
	}
	
}
