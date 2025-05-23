package sample08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import lombok.NoArgsConstructor;
@NoArgsConstructor
@Controller("con")
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private BookDTO book1;
	@Autowired
	private BookDTO book2;
	
	public void invoker() {
		bookService.save(book1, book2);
	}

}
