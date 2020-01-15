package com.example.model;

  

import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="expense")
public class Expense {  
	
	@Id
	private Long id;  
	
	//Gives a time stamp as a object to pin point the date
	private String expensedate; 
	
	
	private String descript; 
	
	//Many expenses can go under one category
	@ManyToOne 
	private Category category; 
	
	//Many Expenses go to one user
	@ManyToOne 
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpensedate() {
		return expensedate;
	}

	public void setExpensedate(String expensedate) {
		this.expensedate = expensedate;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	} 
	
	
	

}
