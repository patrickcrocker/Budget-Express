package com.tdavis.be.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdavis.be.entity.Budget;
import com.tdavis.be.repository.BudgetRepository;

@Service
@Transactional
public class BudgetService {
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	public Iterable<Budget> findAll () {
		
		return budgetRepository.findAll();
		
	}

	public Iterable<Budget> findByYear(String year) {

		return budgetRepository.findByYear(year);
	}
	
	//public Iterable<Budget> findDistinctYear() {
				
	//	return budgetRepository.findDistinctYear();
	//}
	//public Object findDistinctByYear() {
	//	return budgetRepository.findDistinctByYear();
	//}
}
