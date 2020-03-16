package spring05.book.service;

import org.springframework.beans.factory.annotation.Autowired;

import spring05.book.dao.BookDao;
import spring05.book.dto.Book;

public class BookSearchService {

	@Autowired
	private BookDao bookDao;

	public BookSearchService() {
		
	}
	
	public Book searchBook(String bNum) {
		Book book = bookDao.select(bNum);
		return book;
	}
}
