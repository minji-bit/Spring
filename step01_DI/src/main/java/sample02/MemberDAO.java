package sample02;

public class MemberDAO {
	public MemberDAO() {
		System.out.println("MemberDAO() 생성자 호출");
	}
	public void insert(Member member) {
		System.out.println("MemberDAO insert calls...");
		System.out.println(member);
	}
}
