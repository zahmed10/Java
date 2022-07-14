package com.zayd.fullCRUDPokeBook.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zayd.fullCRUDPokeBook.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	// this method retrieves all the books from the database
    List<Expense> findAll();
    // this method finds expenses with descriptions containing the search string
    List<Expense> findByDescriptionContaining(String search);
    // this method counts how many names contain a certain string
    Long countByNameContaining(String search);
    // this method deletes an expense that starts with a specific title
    Long deleteByNameStartingWith(String search);


}
