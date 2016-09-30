package com.tdavis.be.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class ProjectGroup {
	
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 3, message = "Name must be at least 3 characters!")
	@Column(unique = true)
	private String name;
	
	private String description;
	
	@OneToMany(mappedBy="project")
	private List<Quote> quotes;

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}
	
	
}