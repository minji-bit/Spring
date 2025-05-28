package web.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.ErrorCode;
import web.mvc.exception.MyErrorException;
@Repository
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO {
	private final List<ProductDTO> list;
	
	@Override
	public List<ProductDTO> select() {
		return list;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		if(selectByCode(productDTO.getCode())!=null) throw new MyErrorException(ErrorCode.DUPLICATE_CODE);
		list.add(productDTO);
		return 1;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		list.remove(selectByCode(code));
		return 1;
	}

	@Override
	public ProductDTO selectByCode(String code) {
		for (ProductDTO dto : list) {
			if(dto.getCode().equals(code)) return dto;
		}
		return null;
	}

	@Override
	public int updateByCode(ProductDTO productDTO) throws MyErrorException {
		String code = productDTO.getCode();
		ProductDTO dto=	selectByCode(code);
		if(dto!=null) {
			list.remove(dto);
			list.add(productDTO);
		}
		return 1;
	}

}
