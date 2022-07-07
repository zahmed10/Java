package com.zayd.renderingbooks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zayd.renderingbooks.models.Book;
import com.zayd.renderingbooks.services.BookService;


@Controller
public class BookController {
		private BookService bookService;
	    public BookController(BookService bookService){
	        this.bookService = bookService;
	}
	    
	    //home page
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	// show book page
	@RequestMapping("/books/{id}")
    public String show(Model model, @PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }
	
	// languages and poke book 
	
	

}