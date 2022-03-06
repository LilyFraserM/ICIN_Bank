package com.bankingApplication.ICIN_Bank.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CheckingTransaction {

	@Id
	@GeneratedValue
	private int transactionId;
	private int accountNumber;
	private Date date;
	private int prevBalance;
	private int newBalance;
	private String transactionType;
	private String accountType;
	
	

	public CheckingTransaction(int transactionId, int accountNumber, Date date, int prevBalance, int newBalance,
			String transactionType, String accountType) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.date = date;
		this.prevBalance = prevBalance;
		this.newBalance = newBalance;
		this.transactionType = transactionType;
		this.accountType = accountType;
	}
	
	
	

	public CheckingTransaction(Integer accountNumber2, Date date2, Long prevBal, Long newBal, String string,
			String string2) {
		// TODO Auto-generated constructor stub
	}


	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPrevBalance() {
		return prevBalance;
	}
	public void setPrevBalance(int prevBalance) {
		this.prevBalance = prevBalance;
	}
	public int getNewBalance() {
		return newBalance;
	}
	public void setNewBalance(int newBalance) {
		this.newBalance = newBalance;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "CheckingTransaction [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", date="
				+ date + ", prevBalance=" + prevBalance + ", newBalance=" + newBalance + ", transactionType="
				+ transactionType + ", accountType=" + accountType + "]";
	}
	
	
	
}
