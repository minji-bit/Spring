package web.mvc.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.BasicException;
import web.mvc.exception.ErrorInfo;
@Service
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	private List<ProductDTO> list;
	
	@PostConstruct
	public void aa() {
		System.out.println(111);
		log.info("list={}",list);
	}
	@Override
	public void ageCheck(int age) throws BasicException {
		log.info("age={}",age);
		//기능 작성
		if(age<18) throw new BasicException(ErrorInfo.INVALID_AGE);

	}

	@Override
	public void idCheck(String id) throws BasicException {
		log.info("id={}",id);
		if("jang".equals(id)) throw new BasicException(ErrorInfo.DUPLICATE_ID);
	}

}
