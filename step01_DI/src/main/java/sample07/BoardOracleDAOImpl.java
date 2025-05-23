package sample07;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //생성 <bean class="" id="" >동일
public class BoardOracleDAOImpl implements BoardDAO {
	@Autowired
	private List<ProductDTO> list;
	
	public BoardOracleDAOImpl() {
		System.out.println("BoardOracleDAOImpl 생성자...");
	}
	@PostConstruct
	public void init() {
		System.out.println(list);
	}
	@Override
	public void select() {
		System.out.println("BoardOracleDAOImpl select() 호출됨...");

	}

}
