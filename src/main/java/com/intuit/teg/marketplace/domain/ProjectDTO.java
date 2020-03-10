package com.intuit.teg.marketplace.domain;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ProjectDTO {

	private User user;	
	private BigDecimal maxBudget;
	private String projectName;
	private String description;
	private Date submitionLastDay;
	


	public ProjectDTO() {
		super();
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public BigDecimal getMaxBudget() {
		return maxBudget;
	}



	public void setMaxBudget(BigDecimal maxBudget) {
		this.maxBudget = maxBudget;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getSubmitionLastDay() {
		return submitionLastDay;
	}



	public void setSubmitionLastDay(Date submitionLastDay) {
		this.submitionLastDay = submitionLastDay;
	}

	
	
   
}
