package com.zayd.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.zayd.bookclub.models.Book;
import com.zayd.bookclub.models.LoginUser;
import com.zayd.bookclub.models.User;
import com.zayd.bookclub.services.BookService;
import com.zayd.bookclub.services.UserService;

@Controller
public class HomeController {
    
    @Autowired
    private UserService userServ;
    
    @Autowired
    private BookService bookServ;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "users/index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "users/index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "users/index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/home";
    }
    
//    dashboard
    @GetMapping("/home")
    public String goHome(Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	} 
    	return "redirect:/books";
    	
    }
    
    @GetMapping("/books")
    public String books(Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	} 
    	List<Book> allBooks = bookServ.allBooks();
//    	System.out.println(allCourses);
//    	Long user_id = (Long) session.getAttribute("user_id");
    	User loggedUser = userServ.findOne(userId); // break it into two
    	Long user_id = (Long) session.getAttribute("user_id");
    	model.addAttribute("books", allBooks);
    	System.out.println("user id is: " + userId);
    	
    	model.addAttribute("user", loggedUser);
    	model.addAttribute("user_id", user_id);
    	return "users/dashboard.jsp";
    }
    
//    logout route
    @GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
    
    
    
//    Books ------------------------------------------
//    new book form
    @GetMapping("/books/new")
    public String newBooks(HttpSession session, @ModelAttribute("book") Book book, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("userId", userId);
    	return "books/new.jsp";
    	
    }
    
//    New book post method
    @PostMapping("/books/processnew")
    public String processBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	}
    	
    	if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookServ.createBook(book);
            return "redirect:/books";
        }
    	
    }
    
//    display book info after finding by id
    @GetMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long id, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("userId", userId);
    	Book foundBook = bookServ.findBook(id);
    	Long foundBookUserId = (Long) foundBook.getUser().getId();
    	model.addAttribute("foundBook", foundBook);
    	model.addAttribute("foundBookUserId", foundBookUserId);
    	
    	return "books/show.jsp";
    }
    
//    Edit book page with form
    @GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	}
    	Book foundBook = bookServ.findBook(id);
    	model.addAttribute("book", foundBook);
//    	User foundUser = userServ.findOne(userId);
//    	model.addAttribute("foundUser", foundUser);
        return "/books/edit.jsp";
    }
    
//    Edit book put method
    @PutMapping("/books/{id}/processedit")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, @PathVariable("id") Long id) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	}
    	if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            bookServ.updateBook(book);
            return "redirect:/books";
        }
    	
    }
    
    
    
    
}
