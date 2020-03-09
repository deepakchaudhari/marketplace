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

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
@Table(name = "projects")
public class Project extends BaseEntity {

	@ManyToOne
    @JoinColumn(name = "username")
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project", fetch = FetchType.EAGER)
	private Set<Bid> bids;
	
	@Column(name = "max_budget")
	private BigDecimal maxBudget;
	
	@Column(name = "lowest_bid_amount")
	private BigDecimal lowestBidAmount;
	
	@Column(name = "project_name")
	private String projectName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "submition_lastdate")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd")
	private Date submitionLastDay;
	


	public Project() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
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
	
	public BigDecimal getLowestBidAmount() {
		return lowestBidAmount;
	}

	public void setLowestBidAmount(BigDecimal lowestBidAmount) {
		this.lowestBidAmount = lowestBidAmount;
	}
	
   
}
