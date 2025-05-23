package sample07;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller("controller") //생성 <bean class="" id="controller"
@RequiredArgsConstructor //final 필드를 기준으로 생성자
public class BoardController {
	//@Autowired //자동주입 byType기준
	private final BoardService boardService;
	@Autowired
	private BoardDTO boardDTO;
	@Autowired
	private BoardDTO boardDTO2;
	@PostConstruct
	public void init() {
		System.out.println(boardService);
		System.out.println(boardDTO);
		System.out.println(boardDTO2);
	}
	public void test() {
		System.out.println("BoardController의 test() 호출됨...");
		System.out.println("boardService="+boardService);
		System.out.println("boardDTO="+boardDTO);
		System.out.println("boardDTO2="+boardDTO2);
		
		boardService.select();
	}
	
	
	

}
