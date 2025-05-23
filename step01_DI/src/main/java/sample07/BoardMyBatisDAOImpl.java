package sample07;

import org.springframework.stereotype.Repository;
//@Repository("dao")
@Repository //xml 에서 <bean class="" id="boardMyBatisDAOImpl" 동일
public class BoardMyBatisDAOImpl implements BoardDAO {
	public BoardMyBatisDAOImpl() {
		System.out.println("BoardMyBatisDAOImpl 생성자...");
	}
	@Override
	public void select() {
		System.out.println("BoardMyBatisDAOImpl select() 호출됨...");
	}

}
