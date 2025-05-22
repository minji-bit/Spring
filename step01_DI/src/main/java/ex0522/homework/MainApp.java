package ex0522.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public MainApp() {
	}
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("ex0522/homework/applicationContext.xml");
		app.getBean("order",OrderMessage.class).getOrderMessage();
		

	}

}
