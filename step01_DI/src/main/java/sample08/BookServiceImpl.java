package sample08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
@Service
@NoArgsConstructor
public class BookServiceImpl implements BookService {
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private MessageSender messageSender;
	@Autowired
	private BookDAO bookDao;
	
	@Override
	public void save(BookDTO bookDTO1, BookDTO bookDTO2) {
		
		bookDao.save(emailSender, messageSender, bookDTO1, bookDTO2);
	}

}
