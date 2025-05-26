package kosta.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.service.GoodsService;
import kosta.service.MemberService;
import kosta.service.MemberServiceImpl;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("******AOP***********");
		ApplicationContext context= new ClassPathXmlApplicationContext("spring-AOP.xml"); // target/classes 밑에 바로 있다.
		MemberService service =context.getBean("target",MemberService.class); // interface 로!!
		service.memberInsert("민지");
		
		System.out.println("=========================");
		int res = service.memberDelete(5);
		System.out.println("res="+res);
		System.out.println("=========================");
		
		service.memberUpdate();
		System.out.println("=========================");
		String result=service.select("안녕", "하세요");
		System.out.println("result="+result);
		System.out.println("===========GOODSSERVICE==============");
		GoodsService service2 =context.getBean("target2",GoodsService.class); //interface 가 없어도 aop 적용된다!
		service2.insert();
		System.out.println("===========GOODSSERVICE==============");
		int res2 = service2.goodsSelect("새우깡");
		System.out.println("res2="+res2);
		
	}
}
