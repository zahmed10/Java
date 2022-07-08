package com.zayd.allbooks.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zayd.allbooks.models.Book;
import com.zayd.allbooks.services.BookService;

@Controller
public class BookController {
//	Here we are creating our member variables for the BookController class
	private BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    
//  Route that renders the table of all the books after getting the list of all the books
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
    
//    @RequestMapping("/")
//	public String index() {
//		return "books.jsp";
//	}

    }
