package com.tomnguyen7.MVC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tomnguyen7.MVC.models.Book;
import com.tomnguyen7.MVC.repositories.BookRepository;

@Service
public class BookService {
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
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public void deleteBook(Long id) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    		bookRepository.deleteById(id);
    	}
    }
    
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Book oneBook = findBook(id);
    	if(oneBook.getId()==id) {
    		oneBook.setTitle(title);
    		oneBook.setDescription(desc);
    		oneBook.setLanguage(lang);
    		oneBook.setNumberOfPages(numOfPages);
    		return createBook(oneBook);
    	}else {
    		return null;
    	}
    }
}
