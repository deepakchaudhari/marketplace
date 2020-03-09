package com.intuit.teg.marketplace.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Bid
 *
 */
@Entity
@Table(name = "bids")
public class Bid extends BaseEntity {

	
    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private Project project;
    
    @Column(name = "bid_amount")
	private BigDecimal bidAmount;
    
    @ManyToOne
    @JoinColumn(name = "username")
	private User user;
    
    @Column(name = "estimated_days")
	private int estimatedDays;
    
    @Column(name = "desc_proposal")
	private String descProposal;

   @Column(name = "bid_date")
   @Temporal(TemporalType.TIMESTAMP)
   @DateTimeFormat(pattern = "yyyy/MM/dd")
   @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd")
   private Date date;
   

	public Bid() {
		super();
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public BigDecimal getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(BigDecimal bidAmount) {
		this.bidAmount = bidAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getEstimatedDays() {
		return estimatedDays;
	}

	public void setEstimatedDays(int estimatedDays) {
		this.estimatedDays = estimatedDays;
	}

	public String getDescProposal() {
		return descProposal;
	}

	public void setDescProposal(String descProposal) {
		this.descProposal = descProposal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	
   
}
