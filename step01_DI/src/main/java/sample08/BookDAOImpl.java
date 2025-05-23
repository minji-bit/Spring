package sample08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.NoArgsConstructor;
@Repository
@NoArgsConstructor
public class BookDAOImpl implements BookDAO {
	@Autowired
	private DbUtil dbUtil;
	public void save(EmailSender emailSender, MessageSender ms, BookDTO bookDto1, BookDTO bookDto2) {
		System.out.println("emailSender ="+emailSender);
		System.out.println("messageSender ="+ms);
		System.out.println("book1 ="+bookDto1);
		System.out.println("book2 ="+bookDto2);
		System.out.println("dbUtil ="+dbUtil);
	};
}
