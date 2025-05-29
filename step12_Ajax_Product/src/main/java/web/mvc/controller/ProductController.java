package web.mvc.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import web.mvc.dto.ProductDTO;
import web.mvc.service.ProductService;
@RequiredArgsConstructor
@RestController
public class ProductController {
	
	private final ProductService service;
	
	@GetMapping("/")
	public ResponseEntity<?> selectAll() {
		List<ProductDTO> list = service.select();
		Collections.sort(list,Comparator.comparing(p->p.getCode()));
		return ResponseEntity.status(200).body(list);
	}
	
	/*@RequestMapping("/{url}")
	public void view() {}*/
	
	@PostMapping("/products")
	public ResponseEntity<?> insert(@RequestBody ProductDTO dto) {
		dto.setDetail(dto.getDetail().replace("<", "&lt;"));
		int result = service.insert(dto);
		return ResponseEntity.status(201).body(result);
	}
	
	@GetMapping("/read")
	public ResponseEntity<?> read(String code) {
		ProductDTO dto = service.selectByCode(code);
		return ResponseEntity.status(200).body(dto);
	}
	
	@DeleteMapping("/del/{code}")
	public ResponseEntity<?> delete(@PathVariable String code) {
		service.delete(code);
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>("삭제가 완료되었습니다.", resHeaders, 200);
	}
	/*@RequestMapping("/updateForm/{code}")
	public ModelAndView updateForm(@PathVariable String code) {
		ProductDTO dto=service.selectByCode(code);
		ModelAndView mv =  new ModelAndView("updateForm");
		mv.addObject("product",dto);
		return mv;
	}*/
	
	@PutMapping("/products/{code}")
	public ResponseEntity<?> update(
			@RequestBody ProductDTO dto,
			@PathVariable String code) {
		dto.setCode(code);
		service.updateByCode(dto);
		
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>("수정이 완료되었습니다.", resHeaders, 200);
		//return ResponseEntity.status(200).body("수정이 완료되었습니다.");
	}
	
	
	
	
	
	

}
