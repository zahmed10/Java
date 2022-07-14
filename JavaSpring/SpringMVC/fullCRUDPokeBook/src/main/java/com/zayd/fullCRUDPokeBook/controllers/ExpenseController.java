package com.zayd.fullCRUDPokeBook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zayd.fullCRUDPokeBook.models.Expense;
import com.zayd.fullCRUDPokeBook.services.ExpenseService;

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
	
	@RequestMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense foundExpense = expenseService.findExpense(id);
//		model.addAttribute("id", id);
		model.addAttribute("foundExpense", foundExpense);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/expenses/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
            return "error.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expenses"; 
        }
	}
	
	@RequestMapping(value="/expenses/delete/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
	
	@RequestMapping("/expenses/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Expense showExpense = expenseService.findExpense(id);
		model.addAttribute("showExpense", showExpense);
		return "show.jsp";
		
		
	}
	

}
