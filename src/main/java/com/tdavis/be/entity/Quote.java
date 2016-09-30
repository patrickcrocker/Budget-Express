package com.tdavis.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;



@Entity
public class Quote {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 3, message = "Name must be at least 3 characters!")
	@Column(unique = true)
	private String name;
	private double capex;
	private double opex;
	private byte[] data;
	private String justification;
	private String budget;
	
	private String vendor;
	
	@ManyToOne
	@JoinColumn(name="project_group_id")
	private ProjectGroup project;
	
	public Quote() {}
	
	
	
	public String getVendor() {
		return vendor;
	}



	public void setVendor(String vendor) {
		this.vendor = vendor;
	}



	public ProjectGroup getProject() {
		return project;
	}

	public void setProject(ProjectGroup project) {
		this.project = project;
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
	public double getCapex() {
		return capex;
	}
	public void setCapex(double capex) {
		this.capex = capex;
	}
	public double getOpex() {
		return opex;
	}
	public void setOpex(double opex) {
		this.opex = opex;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	
	
	
}
