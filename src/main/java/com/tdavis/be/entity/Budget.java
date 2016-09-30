package com.tdavis.be.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="budget")
public class Budget {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String descriptionShort;
    private String descriptionLong;
    private String category;
    private String region;
    private String criticality;
    private int ranking;
    private double requested_amount;
    private double q1;
    private double q2;
    private double q3;
    private double q4;
    private String year;
        
    public Budget() {}
    
    
    
	public String getDecriptionlong() {
		return descriptionLong;
	}



	public void setDecriptionlong(String descriptionLong) {
		this.descriptionLong = descriptionLong;
	}



	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescriptionshort() {
		return descriptionShort;
	}


	public void setDescriptionshort(String descriptionShort) {
		this.descriptionShort = descriptionShort;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getCriticality() {
		return criticality;
	}


	public void setCriticality(String criticality) {
		this.criticality = criticality;
	}


	public int getRanking() {
		return ranking;
	}


	public void setRanking(int ranking) {
		this.ranking = ranking;
	}


	public double getRequested_amount() {
		return requested_amount;
	}


	public void setRequested_amount(double requested_amount) {
		this.requested_amount = requested_amount;
	}


	public double getQ1() {
		return q1;
	}


	public void setQ1(double q1) {
		this.q1 = q1;
	}


	public double getQ2() {
		return q2;
	}


	public void setQ2(double q2) {
		this.q2 = q2;
	}


	public double getQ3() {
		return q3;
	}


	public void setQ3(double q3) {
		this.q3 = q3;
	}


	public double getQ4() {
		return q4;
	}


	public void setQ4(double q4) {
		this.q4 = q4;
	}
		
}
