package com.intuit.teg.marketplace.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BidDTO extends BaseEntity{
	
	    private Long projectID;
		private BigDecimal bidAmount;
		private User user;
		private int estimatedDays;
		private String descProposal;
	    private Date date;
	    
	    
		public Long getProjectID() {
			return projectID;
		}
		public void setProjectID(Long projectID) {
			this.projectID = projectID;
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
