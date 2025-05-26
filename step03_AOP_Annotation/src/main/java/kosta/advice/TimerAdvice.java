package kosta.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 공통관심사항(사전, 사후 : around)
 *
 */
@Component("advice")
@Aspect
public class TimerAdvice {
	/**
	 * 
	 * @param ProceedingJoinPoint : proceed()메소드를 호출하기 위해서 
	 * @return Object : 실제 타겟대상이 호출된 후 리턴한 값을 받아서 다음 타겟대상에 전달
	 * @throws Throwable
	 */
	@Around("execution(* kosta.service.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName= joinPoint.getSignature().getName();
		
		System.out.println("[LOG] "+methodName+"가 호출되기 전입니다...");
		
		//joinPoint의 parameter 정보 가져오기
		Object[] params=joinPoint.getArgs();
		System.out.println(Arrays.toString(params));
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object obj = joinPoint.proceed(); //다음 Advice 를 호출하거나, 실제 tager대상의 method(joinPoint) 를 호출
		
		sw.stop();
		System.out.println("[LOG] "+methodName+" 호출 후 입니다...");
		System.out.println("[LOG] "+methodName+" 총 실행시간 "+sw.getTotalTimeMillis());
		System.out.println("사후처리 완료입니다..\n");
		return obj;
	}
}
