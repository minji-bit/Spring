package sample07;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service //생성 <bean class="" id="boardServiceImpl"동일>
public class BoardServiceImpl implements BoardService {
	@Autowired //자동주입 byType -> byId 기준 (id 와 property 동일)
	private BoardDAO boardMyBatisDAOImpl;
	@Autowired 
	@Qualifier("boardOracleDAOImpl")
	private BoardDAO boardOracleDao;
	
	public BoardServiceImpl() {
		System.out.println("BoardServiceImpl 생성자...");
	}
	@PostConstruct
	public void init() {
		System.out.println(boardMyBatisDAOImpl);
		System.out.println(boardOracleDao);
	}
	@Override
	public void select() {
		System.out.println("BoardServiceImpl select() 호출됨..");
		System.out.println(boardMyBatisDAOImpl);
		System.out.println(boardOracleDao);
		boardMyBatisDAOImpl.select();
		boardOracleDao.select();
	}

}
