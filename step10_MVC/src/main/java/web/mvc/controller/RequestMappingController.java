package web.mvc.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rem")
public class RequestMappingController {
	@RequestMapping("/a.do")
	public ModelAndView aa() {
		System.out.println("a.do가 요청되었습니다.");
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "spring좋다."); // 뷰에서 ${requestScope.message}
		mv.addObject("hobbies", Arrays.asList("등산", "수영", "낚시")); // ${hobbies}

		mv.setViewName("result"); // WEB-INF/view/result.jsp 이동
		return mv;
	}

	/**
	 * @return : String인 경우 리턴하는 문자열이 뷰의 이름이 된다.!!!
	 */
	@RequestMapping("/rem/a.do")
	public String bb() {
		System.out.println("rem/a.do 요청됨...");

		return "result";
	}

	/**
	 * 여러개의 요청주소가 하나의 메소드를 호출
	 * 
	 * @return : void 는 요청주소가 view 의 이름이 된다. ex) rem/b.do 요청되면 뷰이름은 rem/b 가 된다.
	 *         결론적으로 /WEB-INF/views/rem/b.jsp 이동
	 * @param : Model을 선언하면 Model 객체를 전달받고 Model 에 정보를 저장하면 뷰쪽으로 Model이 전달되어 뷰에서 정보를
	 *          사용할 수 있다.
	 */
	@RequestMapping(value = { "/b.do", "/c.do" })
	public void test(Model model) {
		System.out.println("b.do, c.do 요청되었습니다.");

		model.addAttribute("message", "Model에 저장된 정보입니다.");// ${message}
	}

	/**
	 * 요청방식(method) 분리하기
	 *  method : post, get, put, patch, delete
	 *  @GetMapping  
	 *  @PutMapping
	 *  @PatchMapping
	 *  @DeleteMapping
	 *  @PostMapping
	 *  
	 */
	//@RequestMapping("/test.do")
	@PostMapping("/test.do")
	public ModelAndView test2(HttpServletRequest request) throws Exception{
		
//		request.setCharacterEncoding("UTF-8"); //post 방식 한글인코딩!! -> filter로 대체!!
		String name = request.getParameter("name");
		System.out.println("name="+name);
		return new ModelAndView("result", "message", "요청방식 구분 성공!");
	}
	
	@GetMapping("test.do")
	public String aaa() {
		System.out.println("get 요청됨...");
		return "result";
	}
	
	@RequestMapping(value="/a.do", params="id")
	public String test3(String id) {
		System.out.println("rem/a.do?id= 요청입니다.id="+id);
		
		return "result";
	}
	
}
