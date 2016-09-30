package com.tdavis.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdavis.be.entity.Budget;

//public interface BudgetRepository extends CrudRepository<Budget, Integer> {

//Iterable<Budget> findAllByYear(String year);

//}

public interface BudgetRepository extends JpaRepository<Budget, Integer> {
	
	List<Budget> findByYear(String year);
	
	//List<Budget> findDistinctYear();
	
	//@Query("SELECT DISTINCT year FROM budget")
	//List<Budget> findDistinctByYear();
}