package com.bankingApplication.ICIN_Bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "admin")  
public class Admin {
 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private long admin_id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
}
