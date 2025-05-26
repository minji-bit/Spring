package kosta.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SampleAdvice {
	/**
	 * 사전처리
	 */
	@Before("PointCutDefinition.bb()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println(methodName+" 호출 전 사전 처리 입니다...");
	}
	
	/**
	 * 사후처리 (예외발생 여부 상관없이 무조건)
	 */
	@After("PointCutDefinition.aa()")
	public void afterFinally() {
		System.out.println("예외발생 여부 상관없이 무조건 사후 처리 입니다...");
	}
	
	/**
	 * 사후처리 (예외 발생 없이 정상적으로 동작했을 때)
	 */
	@AfterReturning(pointcut = "PointCutDefinition.bb()",returning = "obj")
	public void afterReturning(JoinPoint joinPoint,Object obj) {
		System.out.println("예외 발생 없이 정상적으로 동작했을 때 사후 처리입니다...");
		System.out.println(joinPoint.getSignature().getName()+"의 결과값은 "+obj+"\n");
	}

	
	/**
	 * 사후처리 (예외 발생 했을 때)
	 */
	@AfterThrowing(pointcut = "PointCutDefinition.cc()",throwing = "e")
	public void afterThrowing(Throwable e) {
		System.out.println("예외 발생 했을 때 사후처리입니다...");
		System.out.println("예외정보 : "+e+"\n");
		
	}
}
