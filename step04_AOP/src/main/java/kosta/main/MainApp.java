package kosta.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.service.CustomerService;


public class MainApp {

	public static void main(String[] args) {
		System.out.println("******AOP***********");
		ApplicationContext context= new ClassPathXmlApplicationContext("spring-AOP.xml"); // target/classes 밑에 바로 있다.
		
		CustomerService service=context.getBean("customer",CustomerService.class);
		
		int result = service.select();
		System.out.println("result="+result);
		
		System.out.println("===================================");
		
//		String res = service.selectById("jeon");
		String res = service.selectById(null);
		System.out.println("res="+res);
		
		System.out.println("===================================");
		
		service.update("ming", "민지");
		
	}
}
