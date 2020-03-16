package spring05.book.service;

import org.springframework.beans.factory.annotation.Autowired;

import spring05.book.dao.BookDao;
import spring05.book.dto.Book;

public class BookRegisterService {

	@Autowired
	private BookDao bookDao;

	public BookRegisterService() {
		
	}
	
	public void register(Book book) {
		bookDao.insert(book);
	}
}
