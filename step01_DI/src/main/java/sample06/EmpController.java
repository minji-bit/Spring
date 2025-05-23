package sample06;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmpController {
	@Autowired //객체주입 기본값 : byType으로 주입 -->여러개면 byid주입
	private EmpDTO empDTO;
	@Autowired
	@Qualifier("empDTO2") //동일한 타입의 bean 객체들 중에서 특정 bean 을 사용하도록 설정
	private EmpDTO emp;
	@Autowired
	private EmpService empService;
	
	public EmpController() {
		System.out.println("EmpController 생성자...");
	}
	
	/**
	 * 객체가 생성된 후 주입이 완료된 후에 해야할 일이 있을 때 사용한다.
	 * 아래 lib 추가
	 * <!-- https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api -->
		<dependency>
			<groupId>javax.annotation</groupId>
			<artifactId>javax.annotation-api</artifactId>
			<version>1.3.2</version>
		</dependency>
	 */
	@PostConstruct
	public void init() {
		System.out.println("****생성과 주입이 완료된 후에 해야 할 일***");
		System.out.println("empDTO="+empDTO);
		System.out.println("emp="+emp);
		System.out.println("EmpService="+empService);
	}
	public void empTest() {
		System.out.println("EmpController의 empTest() call...");
		
		System.out.println("empDTO="+empDTO);
		System.out.println("emp="+emp);
		
		System.out.println("empService="+empService);
		
		empService.test(empDTO);
	}
}
