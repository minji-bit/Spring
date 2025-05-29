package web.mvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;
import web.mvc.dto.UserDto;
import web.mvc.exception.AjaxException;
import web.mvc.exception.ErrorInfo;

@RestController
@Slf4j
public class AjaxController {
	
	@Autowired
	private List<ProductDTO> list;
	
	
	@PostMapping("/ajax.do")
	public ProductDTO btn(String email,String pwd) {
		log.info("email={},pwd={}",email,pwd);
		return ProductDTO.builder().code("A08").detail("재미있다").price(1000).name("Spring").build();
	}
	
	
	/**
	 * 
	 * @param : @RequestBody 선언은 front에서 json으로 데이터 전송시 사용
	 */
	@PostMapping("/ajax2.do")
	public ResponseEntity<?> ajax2(@RequestBody UserDto userDto){
		log.info("userDto = {}",userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("OK");
	}
	
	
	@PostMapping("/ajax3.do")
	public ResponseEntity<?> ajax3(@RequestBody UserDto userDto){
		log.info("ajax3: userDto = {}",userDto);
		if(userDto.getAge()<18) {
			//예외발생
			throw new AjaxException(ErrorInfo.INVALID_AGE);
			
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	
	@RequestMapping("/ajax4.do")
	public ResponseEntity<?> ajax4(@RequestBody  UserDto userDTO) {
		log.info("userDTO = {}", userDTO);
		 
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>("OK", resHeaders, HttpStatus.CREATED);
		
	}
	
	
}
