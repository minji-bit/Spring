package sample06;

public class EmpService {
	public EmpService() {
		System.out.println("EmpService 생성자...");
	}
	public void test(EmpDTO empDTO) {
		System.out.println("EmpService test() 입니다.");
		System.out.println("empDTO="+empDTO);
	}
}
