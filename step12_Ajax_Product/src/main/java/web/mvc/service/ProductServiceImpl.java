package web.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import web.mvc.dao.ProductDAO;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.ErrorCode;
import web.mvc.exception.MyErrorException;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductDAO dao;
	
	private final static int MIN_PRICE=1000;
	private final static int MAX_PRICE=10000;
	
	
	@Override
	public List<ProductDTO> select() {
		
		return dao.select();
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		int price =productDTO.getPrice();
		if(price<MIN_PRICE || price>MAX_PRICE) throw new MyErrorException(ErrorCode.PRICE_ERROR);
		int result = dao.insert(productDTO);
		return result;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		dao.delete(code);
		return 0;
	}

	@Override
	public ProductDTO selectByCode(String code) throws MyErrorException {
		ProductDTO dto = dao.selectByCode(code);
		return dto;
	}

	@Override
	public int updateByCode(ProductDTO productDTO) throws MyErrorException {
		dao.updateByCode(productDTO);
		
		return 1;
	}

}
