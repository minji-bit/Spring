package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//기존방식 
/*		MessageBean bean = new MessageBeanKoImpl();
		bean.sayHello("민지");
		
		bean = new MessageBeanEnImpl();
		bean.sayHello("minji");*/
		
		/////////////////////////////////////////////
		
		/**
		 * Spring IoC Container의 ApplicationContext를 이용해서 객체 관리
		 *  :bean 등록, 생성, 의존관계 주입, 생명주기 관리
		 *  :객체를 singleton의 형태로 관리한다.
		 *   singleton일 때 객체를 미리 메모리에 로딩하고 같은 id를 여러번
		 *   getBean으로 호출하면 항상 동일한 객체가 나온다. - 즉시로딩
		 *   
		 *   만약,bean 설정에 scope = "prototype" 설정하면 객체를 미리
		 *   만들지 않고 필요할 때(getBean할때)마다 새로운 객체를 생성해준다.
		 */
		System.out.println("******시작하기**********");
		ApplicationContext context = new ClassPathXmlApplicationContext("sample01/applicationContext.xml");
		
		System.out.println("----------------------------------------");
		MessageBean bean = context.getBean("en",MessageBean.class);
		System.out.println(bean);
		bean.sayHello("minji");
		System.out.println("-----------------------------------");
		bean = context.getBean("ko",MessageBean.class);
		System.out.println(bean);
		bean.sayHello("민지");
		System.out.println("-----------------------------------");
		MessageBean bean2 = context.getBean("ko",MessageBean.class);
		System.out.println("bean2="+bean2);
		
		
		
	}

}
