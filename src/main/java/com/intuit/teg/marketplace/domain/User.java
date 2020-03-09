package com.intuit.teg.marketplace.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;


/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username")
    private String username;
    
    @Column(name = "role")
    private TypeEnum role =null;
    
    

    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  
    @JsonCreator
    public User role(TypeEnum role) {
    	this.role = role;
    	return this;
    }	
    
    
    public enum TypeEnum {
        SELLER("seller"),
        
        BUYER("buyer");

        private String value;

        TypeEnum(String value) {
          this.value = value;
        }
        
    }
    
    public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public TypeEnum getRole() {
		return role;
	}


	public void setRole(TypeEnum role) {
		this.role = role;
	}
}

    
 // Future enhancemnet for the Auto-Bid Feature
  //  @Column(name = "auto_bid_enabled", columnDefinition = "boolean default false")
  //  private Boolean autoBidEnabled = false;
    
   //// Future enhancemnet for the Auto-Bid Feature 
   //  @Column(name= "auto_bid_min")
   // private BigDecimal autoBidMin;


    /**
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Column(name = "firstname")
	private String firstname;
    
    @Column(name = "lastname")
	private String lastname;
    
	@Column(name = "email")
	private String email;
    
    @Column(name = "phoneNumber")
	private String phoneNumber;**/
 
/**
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    **/
 

    /**



	public Boolean getAutoBidEnabled() {
		return autoBidEnabled;
	}


	public void setAutoBidEnabled(Boolean autoBidEnabled) {
		this.autoBidEnabled = autoBidEnabled;
	}


	public BigDecimal getAutoBidMin() {
		return autoBidMin;
	}


	public void setAutoBidMin(BigDecimal autoBidMin) {
		this.autoBidMin = autoBidMin;
	}
	
}**/
