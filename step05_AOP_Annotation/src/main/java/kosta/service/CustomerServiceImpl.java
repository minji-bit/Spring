package kosta.service;

import org.springframework.stereotype.Service;

@Service("customer")
public class CustomerServiceImpl implements CustomerService {

	@Override
	public int select() {
		System.out.println(getClass().getSimpleName()+" 의  select() 핵심기능입니다.");
		return 10;
	}

	@Override
	public String selectById(String id) {
		System.out.println(getClass().getSimpleName()+" 의  selectById(String id) 핵심기능입니다.");
		if(id==null) {
			throw new RuntimeException("id는 null이면 안되요~~");
		}
		
		return "안녕안녕";
	}

	@Override
	public void update(String Id, String name) {
		System.out.println(getClass().getSimpleName()+" 의  update(String Id, String name) 핵심기능입니다.");

	}

}
