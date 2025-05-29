package web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import web.mvc.service.UserService;

@Controller
@RequiredArgsConstructor
public class AdminController {
	
	private final UserService userService;
	
	@GetMapping("/test.admin")
	public String test() {
		System.out.println("userService ="+userService);
		System.out.println("test.admin call.....");
		
		return "result"; //WEB-INF/admin/result.jsp
	}
}
