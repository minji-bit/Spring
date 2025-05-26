package kosta.aop;

import org.aspectj.lang.JoinPoint;

public class SampleAdvice {
	/**
	 * 사전처리
	 */
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println(methodName+" 호출 전 사전 처리 입니다...");
	}
	
	/**
	 * 사후처리 (예외발생 여부 상관없이 무조건)
	 */
	public void afterFinally() {
		System.out.println("예외발생 여부 상관없이 무조건 사후 처리 입니다...");
	}
	
	/**
	 * 사후처리 (예외 발생 없이 정상적으로 동작했을 때)
	 */
	public void afterReturning(JoinPoint joinPoint,Object obj) {
		System.out.println("예외 발생 없이 정상적으로 동작했을 때 사후 처리입니다...");
		System.out.println(joinPoint.getSignature().getName()+"의 결과값은 "+obj+"\n");
	}

	
	/**
	 * 사후처리 (예외 발생 했을 때)
	 */
	public void afterThrowing(Throwable e) {
		System.out.println("예외 발생 했을 때 사후처리입니다...");
		System.out.println("예외정보 : "+e+"\n");
		
	}
}
