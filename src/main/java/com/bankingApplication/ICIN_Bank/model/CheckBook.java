package com.bankingApplication.ICIN_Bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CheckBook {
	
		@Id
	    private Long checkNo;
		private int accountNumber;
		private boolean accepted;
		private String custName;
		
		public int getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}
		public Long getCheckNo() {
			return checkNo;
		}
		public void setCheckNo(Long checkNo) {
			this.checkNo = checkNo;
		}
		public boolean isAccepted() {
			return accepted;
		}
		public void setAccepted(boolean accepted) {
			this.accepted = accepted;
		}
		
		
		public String getCustName() {
			return custName;
		}
		public void setCustName(String custName) {
			this.custName = custName;
		}
		@Override
		public String toString() {
			return "CheckBook [checkNo=" + checkNo + ", accountNumber=" + accountNumber + ", accepted=" + accepted
					+ ", custName=" + custName + "]";
		}
		
}
