package com.tyrone.jpademo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.tyrone.jpademo.repositories.BookRepository;
import com.tyrone.jpademo.models.Book;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	//updates a book
	public Book upDateBook(Book b) {
		return bookRepository.save(b);
	}
	
//	public List<Book> booksContaining(String search){
//		return bookRepository.findByDescriptionContaining(search);
//	}
//

	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			bookRepository.deleteById(id);
		}
	}
}
