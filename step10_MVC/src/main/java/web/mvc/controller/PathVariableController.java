package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PathVariableController {
	
	@RequestMapping("/{type}/{id}.do")
	public void aa(@PathVariable String type,@PathVariable String id) {
		log.info("aa 호출되었어요~~ {},{}",type,id);
		
	}
	@RequestMapping("/{id}")
	public void bb(@PathVariable String id) {
		log.info("/blog/* 요청입니다...{}",id);
		
	}
	@RequestMapping("/{borad}/{type}/{id}")
	public String cc(@PathVariable String borad,@PathVariable String type, @PathVariable int id) {
		log.info("/blog/* 요청2입니다...borad :{},type :{}",borad,type);
		log.info("/blog/* 요청2입니다...id : {}",id);
		
		//controller-> controller요청하고 싶다!
		return "redirect:/param/a.do"; //http://localhost:9000/controller/param/a.do
//		return "forward:/param/a.do"; //http://localhost:9000/controller/blog/borad/faq/2
	}
	
	@RequestMapping("{url}.do")
	public void url() {}
}
