package sample02;

public class MemberService {
	private Member member;
	private MemberDAO memberDao;
	public MemberService() {
		System.out.println("MemberService() calls....");
	}
	public MemberService(Member member, MemberDAO memberDao) {
		System.out.println("MemberService(Member member, MemberDAO memberDao) call...");
		System.out.println("mdmberDao = "+memberDao);
		System.out.println("mdmber = "+member);
		this.member = member;
		this.memberDao = memberDao;
	}
	public void serviceInsert() {
		System.out.println("serviceInsert() call...");
		memberDao.insert(member);
	}
	
	
}
