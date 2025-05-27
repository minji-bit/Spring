package kosta.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.test.service.Player;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("homework.xml");
		Player player = app.getBean("tv",Player.class);
		
		player.start(0);
		player.pause();
		player.stop();
		System.out.println("-------------------------------");
		player=app.getBean("audio",Player.class);
		player.start(0);
		player.pause();
		player.stop();
		System.out.println("-------------------------------");
		player=app.getBean("vedio",Player.class);
		player.start(0);
		player.pause();
		player.stop();
		
		
	}

}
