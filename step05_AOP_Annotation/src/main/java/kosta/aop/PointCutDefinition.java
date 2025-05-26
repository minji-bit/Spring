package kosta.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * pointcut 정의를 담당하는 클래스
 *
 */
public class PointCutDefinition {
	/**
	 * 공통 point-cut
	 */
	@Pointcut("execution(public * kosta.service.*Impl.*(..))")
	public void aa() {}
	
	/**
	 * 로그기록 point-cut
	 */
	@Pointcut("execution(public * kosta.service.*Impl.select())")
	public void bb() {}
	/**
	 * timer 체크하는 point-cut
	 */
	@Pointcut("execution(public * kosta.service.*Impl.select*(..))")
	public void cc() {}
}
