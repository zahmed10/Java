package com.zayd.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zayd.booksapi.models.Book;
import com.zayd.booksapi.repositories.BookRepository;

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
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // updates a book's info
    public Book updateBook(Long id, String title, String desc, String lang,
    		Integer numOfPages) {
    	Book foundBook = findBook(id);
    	foundBook.setTitle(title);
    	foundBook.setDescription(desc);
    	foundBook.setLanguage(lang);
//    	foundBook.setDescription(desc);
    	foundBook.setNumberOfPages(numOfPages);
//    	bookRepository.save(foundBook);
//    	return bookRepository.save(foundBook); 
    	return foundBook;
    	
    	
    	
    }
    
    public void deleteBook(Long id) {
//    	Book output = this.findBook(id);
    	bookRepository.deleteById(id);
    }

}
