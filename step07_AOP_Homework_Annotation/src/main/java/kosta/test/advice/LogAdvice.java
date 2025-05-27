package kosta.test.advice;

import java.io.File;
import java.io.FileWriter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
@Component("advice")
@Aspect
public class LogAdvice {
	public FileWriter fw;
	@Around("execution(* kosta.test..*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start();
		System.out.println("사전처리");
		Object obj = joinPoint.proceed();
		sw.stop();
		String method = joinPoint.getSignature().getName();
		int para = joinPoint.getArgs().length;
		long total=sw.getTotalTimeMillis();
		System.out.println("사후처리");
		String logMessage = method+"호출 / 인수 개수 : "+para+"개 / 리턴값: "+obj+"/ 총 실행시간 : "+total+"ms\n\n";
		fw= new FileWriter(new File("C:\\Edu\\Spring\\springFramework\\workSpace\\step08_AOP_Homework\\src\\main/log.txt"),true);
		fw.write(logMessage);
		fw.flush();
		return obj;
	}
}
