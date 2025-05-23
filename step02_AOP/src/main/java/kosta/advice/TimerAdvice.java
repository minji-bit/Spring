package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * 공통관심사항(사전, 사후 : around)
 *
 */
public class TimerAdvice {
	/**
	 * 
	 * @param ProceedingJoinPoint : proceed()메소드를 호출하기 위해서 
	 * @return Object : 실제 타겟대상이 호출된 후 리턴한 값을 받아서 다음 타겟대상에 전달
	 * @throws Throwable
	 */
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("사전처리입니다..");
		String methodName= joinPoint.getSignature().getName();
		System.out.println("[LOG] "+methodName+"가 호출되기 전입니다...");
		StopWatch sw = new StopWatch();
		sw.start();
		Object obj = joinPoint.proceed(); //다음 Advice 를 호출하거나, 실제 tager대상의 method(joinPoint) 를 호출
		
		sw.stop();
		System.out.println("[LOG] "+methodName+" 호출 후 입니다...");
		System.out.println("[LOG] "+methodName+" 총 실행시간 "+sw.getTotalTimeMillis());
		System.out.println("사후처리입니다..");
		return obj;
	}
}
