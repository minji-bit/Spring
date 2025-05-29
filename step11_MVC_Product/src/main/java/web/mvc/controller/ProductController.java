package web.mvc.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import web.mvc.dto.ProductDTO;
import web.mvc.service.ProductService;
@RequiredArgsConstructor
@Controller
public class ProductController {
	
	private final ProductService service;
	
	@GetMapping("/")
	public ModelAndView selectAll(ModelAndView mv) {
		List<ProductDTO> list = service.select();
		Collections.sort(list,Comparator.comparing(p->p.getCode()));
		mv.addObject("productList", list);
		mv.setViewName("productList");
		return mv;
	}
	
	@RequestMapping("/{url}")
	public void view() {}
	
	@PostMapping("/products")
	public String insert(ProductDTO dto) {
		dto.setDetail(dto.getDetail().replace("<", "&lt;"));
		service.insert(dto);
		return "redirect:/";
	}
	
	@RequestMapping("/read")
	public void read(String code,Model model) {
		ProductDTO dto = service.selectByCode(code);
		model.addAttribute("product",dto);
	}
	
	@RequestMapping("/del/{code}")
	public String delete(@PathVariable String code) {
		service.delete(code);
		return "redirect:/";
	}
	@RequestMapping("/updateForm/{code}")
	public ModelAndView updateForm(@PathVariable String code) {
		ProductDTO dto=service.selectByCode(code);
		ModelAndView mv =  new ModelAndView("updateForm");
		mv.addObject("product",dto);
		return mv;
	}
	
	@PostMapping("/products/{code}")
	public String update(
			@ModelAttribute("product") ProductDTO dto,
			@PathVariable String code) {
		dto.setCode(code);
		service.updateByCode(dto);
	//	return "redirect:/read?code="+code;// db를 갔다와야함
		return "read";
	}
	
	
	
	
	
	

}
