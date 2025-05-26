package kosta.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 사전 , 사후 처리 기능
 *
 */
public class AroundAdvice {
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("AroundAdvice 의 around 사전 처리입니다.\n");
		
		Object obj =joinPoint.proceed(); // 다음 advice 또는 joinPoint 호출
		
		System.out.println("AroundAdvice 의 around 사후 처리입니다.\n");
		
		
		
		return obj;
	}

}
