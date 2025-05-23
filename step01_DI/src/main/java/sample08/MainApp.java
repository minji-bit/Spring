package sample08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("sample08/test.xml");
		app.getBean("con",BookController.class).invoker();

	}

}
