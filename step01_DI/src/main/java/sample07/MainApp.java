package sample07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("sample07/springDI.xml",
				"sample07/Product-Init-context.xml");
		System.out.println("**********************************");
		app.getBean("controller", BoardController.class).test();
	}

}
