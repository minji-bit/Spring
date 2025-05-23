package kosta.service;

public class MemberServiceImpl implements MemberService {

	public void memberInsert(String name) {
		System.out.println("MemberServiceImpl memberInsert(String name) 핵심기능~");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void memberUpdate() {
		System.out.println("MemberServiceImpl memberUpdate() 핵심기능~");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int memberDelete(int no) {
		System.out.println("MemberServiceImpl memberDelete(int no) 핵심기능~");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 100;
	}

	public String select(String keyField, String keyWord) {
		System.out.println("MemberServiceImpl select(String keyField, String keyWord) 핵심기능~");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "안녕";
	}

}
