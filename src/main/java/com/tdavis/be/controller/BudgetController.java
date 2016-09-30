package com.tdavis.be.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tdavis.be.entity.Budget;
import com.tdavis.be.service.BudgetService;


@Controller
public class BudgetController {
	

	@Autowired
	private BudgetService budgetService;
	
	@ModelAttribute("budget")
	public Budget construct() {
		return new Budget();
	}
	
	@RequestMapping("/budget")
	public String budgetIndex (Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String name = auth.getName(); //get logged in username
    	model.addAttribute("username", name);
		model.addAttribute("title", "Budget Express");
		return "budget";
	}
	
	@RequestMapping("/budget-details")
	public String detail(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String name = auth.getName(); //get logged in username
    	model.addAttribute("username", name);
		model.addAttribute("title", "Budget Details");
		model.addAttribute("budgets", budgetService.findAll());
		model.addAttribute("links", allYears());
		return "budget-details";
	}
	
	@RequestMapping("/budget-details/{year}")
	public String detail_year(Model model, @PathVariable String year) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String name = auth.getName(); //get logged in username
    	model.addAttribute("username", name);
		model.addAttribute("title", "Budget Details - "+ year);
		model.addAttribute("budgets" , budgetService.findByYear(year));
		model.addAttribute("links", allYears());
		return "budget-details";
	}
	
	@RequestMapping("/budget-add")
	public String addBudget(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String name = auth.getName(); //get logged in username
    	model.addAttribute("username", name);
		model.addAttribute("title", "Add Budget");
		return "/budget-add";
	}
	
	public List<String> allYears () {
		List<String> temp = new ArrayList<String>();
		Iterable<Budget> temp_bug = budgetService.findAll();
		Set<String> hs = new HashSet<>();
		
		for(Budget b : temp_bug) {
			temp.add((String)b.getYear());
		}
		
		hs.addAll(temp);
		temp.clear();
		temp.addAll(hs);
		
		return temp;
	}
	

}
