package com.tdavis.be.service.initdb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tdavis.be.entity.Budget;
import com.tdavis.be.entity.ProjectGroup;
import com.tdavis.be.entity.Quote;
import com.tdavis.be.entity.Role;
import com.tdavis.be.entity.User;
import com.tdavis.be.repository.BudgetRepository;
import com.tdavis.be.repository.ProjectGroupRepository;
import com.tdavis.be.repository.QuoteRepository;
import com.tdavis.be.repository.RoleRepository;
import com.tdavis.be.repository.UserRepository;



@Transactional
@Service
public class InitDbService {

	@Autowired
	private BudgetRepository budgetRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired QuoteRepository quoteRepository;
	
	@Autowired ProjectGroupRepository projectgroupRepository;
	
	@PostConstruct
	public void init() throws IOException {
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		User userUser = new User();
		userUser.setEnabled(true);
		userUser.setName("user");
		userUser.setPassword(encoder.encode("user"));
		List<Role> uroles = new ArrayList<Role>();
		uroles.add(roleUser);
		userUser.setRoles(uroles);
		userRepository.save(userUser);
		
		Budget budget = new Budget();
		budget.setName("Servers");
		budget.setDescriptionshort("Refresh for Datacenter Servers");
		budget.setCategory("Datacenter");
		budget.setRegion("Global Corporate Strategy");
		budget.setCriticality("1 - Lights Out");
		budget.setRanking(1);
		budget.setRequested_amount(50000);
		budget.setQ1(15000);
		budget.setQ2(15000);
		budget.setQ3(10000);
		budget.setQ4(10000);
		budget.setYear("2016");
		budgetRepository.save(budget);
		
		Budget budget1 = new Budget();
		budget1.setName("Backups");
		budget1.setDescriptionshort("Refresh Capacity for Datacenter backups");
		budget1.setCategory("Datacenter");
		budget1.setRegion("Global Corporate Strategy");
		budget1.setCriticality("1 - Lights Out");
		budget1.setRanking(1);
		budget1.setRequested_amount(25000);
		budget1.setQ1(5000);
		budget1.setQ2(5000);
		budget1.setQ3(5000);
		budget1.setQ4(10000);
		budget1.setYear("2016");
		budgetRepository.save(budget1);
		
		Budget budget2 = new Budget();
		budget2.setName("Servers");
		budget2.setDescriptionshort("Refresh for Datacenter servers");
		budget2.setCategory("Datacenter");
		budget2.setRegion("Global Corporate Strategy");
		budget2.setCriticality("1 - Lights Out");
		budget2.setRanking(1);
		budget2.setRequested_amount(100000);
		budget2.setQ1(50000);
		budget2.setQ2(25000);
		budget2.setQ3(25000);
		budget2.setQ4(0);
		budget2.setYear("2015");
		budgetRepository.save(budget2);
		
		Budget budget3 = new Budget();
		budget3.setName("Backups");
		budget3.setDescriptionshort("Refresh Capacity for Datacenter backups");
		budget3.setCategory("Datacenter");
		budget3.setRegion("Global Corporate Strategy");
		budget3.setCriticality("1 - Lights Out");
		budget3.setRanking(1);
		budget3.setRequested_amount(15000);
		budget3.setQ1(5000);
		budget3.setQ2(5000);
		budget3.setQ3(2500);
		budget3.setQ4(2500);
		budget3.setYear("2015");
		budgetRepository.save(budget3);
		
		Budget budget4 = new Budget();
		budget4.setName("Servers");
		budget4.setDescriptionshort("Refresh for Datacenter servers");
		budget4.setCategory("Datacenter");
		budget4.setRegion("Global Corporate Strategy");
		budget4.setCriticality("1 - Lights Out");
		budget4.setRanking(1);
		budget4.setRequested_amount(10000);
		budget4.setQ1(0);
		budget4.setQ2(5000);
		budget4.setQ3(5000);
		budget4.setQ4(0);
		budget4.setYear("2014");
		budgetRepository.save(budget4);
		
		Budget budget5 = new Budget();
		budget5.setName("Backups");
		budget5.setDescriptionshort("Refresh Capacity for Datacenter backups");
		budget5.setCategory("Datacenter");
		budget5.setRegion("Global Corporate Strategy");
		budget5.setCriticality("1 - Lights Out");
		budget5.setRanking(1);
		budget5.setRequested_amount(5000);
		budget5.setQ1(0);
		budget5.setQ2(2500);
		budget5.setQ3(2500);
		budget5.setQ4(0);
		budget5.setYear("2014");
		budgetRepository.save(budget5);
		
		Quote quote = new Quote();
		quote.setName("Quote #1");
		quote.setVendor("PC Direct");
		quote.setCapex(50000);
		quote.setOpex(10000);
		quote.setJustification("This is justified");
		quote.setBudget("Link to Budgets");
		quoteRepository.save(quote);
		
		Quote quote2 = new Quote();
		quote2.setName("Quote #2");
		quote2.setVendor("CDW");
		quote2.setCapex(100000);
		quote2.setOpex(10000);
		quote2.setJustification("This is justified");
		quote2.setBudget("Link to Budgets");
		quoteRepository.save(quote2);
		
		ProjectGroup project = new ProjectGroup();
		project.setName("Buy some Servers");
		project.setDescription("Refresh Servers");
		List<Quote> quotes = new ArrayList<Quote>();
		quotes.add(quote);
		quotes.add(quote2);
		project.setQuotes(quotes);
		projectgroupRepository.save(project);
		
		
	}
	
}
