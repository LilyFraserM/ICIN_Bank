package com.bankingApplication.ICIN_Bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankingApplication.ICIN_Bank.model.Transaction;
import com.bankingApplication.ICIN_Bank.service.TransactionService;



@RestController
public class TransactionController {

	  @Autowired
	   // private Transaction transactionService;
	  private TransactionService transactionService;
	  
	  @PostMapping(path = "/transfer")
	   
	    public Object transferMoney(@RequestBody Transaction transaction) throws Exception {

	    	  transactionService.transferMoney(transaction);
	         
	          return transaction;
	        

	    }
}
