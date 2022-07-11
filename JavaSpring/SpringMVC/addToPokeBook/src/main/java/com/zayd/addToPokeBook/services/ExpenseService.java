package com.zayd.addToPokeBook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zayd.addToPokeBook.models.Expense;
import com.zayd.addToPokeBook.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	// adding the expense repository as a dependency
	private final ExpenseRepository expenseRepo;
	
	//constructor
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	//returns all the expenses
	public List<Expense> allExpenses() {
		return expenseRepo.findAll();
	}
	
	//creates an expense
	public Expense createExpense(Expense e) {
		return expenseRepo.save(e);
	}
	
	//retrieves an expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent() ) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	// updates an expense's info
	public void updateExpense(Long id, String name, String vendor, double amount, 
			String description) {
			// here maybe use the new way of doing this. not sure yet.
			// change void return to Expense instead when you are ready to fix it iA
		
	}
	
	//deletes an expense
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
	

}
