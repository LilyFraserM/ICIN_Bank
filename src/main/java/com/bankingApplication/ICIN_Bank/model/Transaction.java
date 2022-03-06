package com.bankingApplication.ICIN_Bank.model;

import javax.activity.InvalidActivityException;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Transaction {
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer transactionId;
	    private String description;

	    @JsonProperty (required = true)
	    private Long transactionAmount;

	   
	    @JsonProperty (required = true)
	    private int sourceAccountnumber;

	    @JsonProperty (required = true)
	    private int destinationAccountnumber;

		public Integer getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(Integer transactionId) {
			this.transactionId = transactionId;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Long getTransactionAmount() {
			return transactionAmount;
		}

		public void setTransactionAmount(Long transactionAmount) {
			this.transactionAmount = transactionAmount;
		}

		public int getSourceAccountnumber() {
			return sourceAccountnumber;
		}

		public void setSourceAccountnumber(int sourceAccountnumber) {
			this.sourceAccountnumber = sourceAccountnumber;
		}

		public int getDestinationAccountnumber() {
			return destinationAccountnumber;
		}

		public void setDestinationAccountnumber(int destinationAccountnumber) {
			this.destinationAccountnumber = destinationAccountnumber;
		}

		public Transaction() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Transaction [transactionId=" + transactionId + ", description=" + description
					+ ", transactionAmount=" + transactionAmount + ", sourceAccountnumber=" + sourceAccountnumber
					+ ", destinationAccountnumber=" + destinationAccountnumber + "]";
		}

		    public void runValidationTests(CheckingAccount sourceAccount, CheckingAccount destinationAccount) throws Exception {
        Long transactionAmount = getTransactionAmount();
        
        if (sourceAccount ==null || destinationAccount == null) {
            throw new InvalidActivityException(
                    String.format("Invalid source account %s "
                            + "or destination account %s", 
                            sourceAccount.getAccountNumber(),
                            destinationAccount.getAccountNumber()));
        }
        if (transactionAmount.compareTo(Long.valueOf(0)) <0) {
            throw new Exception(
                    String.format("Transaction %s is invalid"
                            + " due to negative value", getTransactionId()));
        }
//        if (sourceAccount.getAccountBalance().
//                subtract(transactionAmount).compareTo(Long.valueOf(0)) <0) {
//            throw new InvalidTransactionException(
//                    String.format("Transaction %s is invalid due to "
//                            + "insufficient balance for account %s",
//                    getTransactionId(), sourceAccount.getAccountId()));
//        }
       
    }

			

}
