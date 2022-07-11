package com.zayd.addToPokeBook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zayd.addToPokeBook.models.Expense;
import com.zayd.addToPokeBook.services.ExpenseService;

@Controller
public class ExpenseController {
	// Here we are creating our member variables for the ExpenseController class
	private ExpenseService expenseService;
	// constructor
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@RequestMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("lists", expenses);
		return "index.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
            return "error.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/expenses";
        }
	}
	

}
