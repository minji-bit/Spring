package sample06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext application = new ClassPathXmlApplicationContext("sample06/springDI-autowired.xml");
		System.out.println("**********************************");
		application.getBean("empController",EmpController.class).empTest();

	}

}
