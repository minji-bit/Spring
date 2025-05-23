package sample06;

import org.springframework.beans.factory.annotation.Value;

public class EmpDTO {
	@Value("100")
	private int empno;
	@Value("민지")
	private String name;
	@Value("학생")
	private String job;

	public EmpDTO() {
		System.out.println("EmpDTO 생성자 입니다.");
		System.out.println("empNo=" + empno); // 생성자 호출 뒤에 주입이 일어난다.
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	/*
	 * @Override public String toString() { return "EmpDTO [empno=" + empno +
	 * ", name=" + name + ", job=" + job + "]"; }
	 */

}
