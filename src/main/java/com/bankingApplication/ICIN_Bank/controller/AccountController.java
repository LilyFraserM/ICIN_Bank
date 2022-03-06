package com.bankingApplication.ICIN_Bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bankingApplication.ICIN_Bank.model.CheckingAccount;
import com.bankingApplication.ICIN_Bank.model.SavingsAccount;
import com.bankingApplication.ICIN_Bank.model.Transaction;
import com.bankingApplication.ICIN_Bank.repository.CheckingAccountRepository;
import com.bankingApplication.ICIN_Bank.service.CheckingService;
import com.bankingApplication.ICIN_Bank.service.SavingsService;
import com.bankingApplication.ICIN_Bank.service.TransactionService;



public class AccountController {
	

	
	@Autowired
	private CheckingService checkingService;
	
	@Autowired
	private SavingsService savingsService;
	
	@Autowired
	private CheckingAccountRepository checkingAccountrepo;
	
	@GetMapping("/deposit/{accType}/{accNo}/{amount}" )
	//@CrossOrigin(origins = "http://localhost:4200")
    public Object deposit(@PathVariable String accType, @PathVariable String accNo, @PathVariable String amount) {
		//System.out.println(accNo);
		//System.out.println(accType.getClass());
		if(accType.equals("Checking")) {
			System.out.println(accType);
			checkingService.deposit(Integer.parseInt(accNo) , Long.parseLong(amount));
			CheckingAccount chkingAcc = CheckingService.getAccount(Integer.parseInt(accNo));
			return chkingAcc;
		}	
		else {
			System.out.println(accType);
			savingsService.deposit(Integer.parseInt(accNo) , Long.parseLong(amount));
			SavingsAccount savingsAcc = savingsService.getAccount(Integer.parseInt(accNo));
			return savingsAcc;
		}
			
    }
	
	@GetMapping("/withdraw/{accType}/{accNo}/{amount}" )
	//@CrossOrigin(origins = "http://localhost:4200")
    public Object withdraw(@PathVariable String accType, @PathVariable String accNo, @PathVariable String amount) {
		//System.out.println(accNo);
		//System.out.println(accType.getClass());
		if(accType.equals("Checking")) {
			System.out.println(accType);
			String val = checkingService.withdraw(Integer.parseInt(accNo) , Long.parseLong(amount));
			if(val.equals("Done")) {
			CheckingAccount checkingAcc = checkingService.getAccount(Integer.parseInt(accNo));
			return checkingAcc;
			}
			else {
				return "Insufficient Balance";
			}
		}	
		else {
			System.out.println(accType);
			String val = savingsService.withdraw(Integer.parseInt(accNo) , Long.parseLong(amount));
			if(val.equals("Done")) {
			SavingsAccount savingsAcc = savingsService.getAccount(Integer.parseInt(accNo));
			return savingsAcc;
			}
			else
			{
				return "Insufficient Balance";
			}
		}
			
    }
	
	@Autowired
    private TransactionService transactionService;
    
    /**
     * Finds all available accounts in the system
     * @return - List of accounts
     */
    @GetMapping(path="/accounts")
   // @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<CheckingAccount> retrieveAllAccounts() {
        return checkingAccountrepo.findAll();
    }

    /**
     * Finds the balance available for a given account
     * @param accountId - Unique account ID
     * @return Balance available for an account
     */
    @GetMapping(path = "/accounts/{accountNumber}/balance")
   // @CrossOrigin(origins = "http://localhost:4200")
    public Long retrieveAccountBalance(@PathVariable int accountNumber) {
       CheckingAccount account = CheckingAccountRepository.findByAccountNumber(accountNumber);
//        if (!account.isPresent()) {
//            throw new AccountNotFoundException(
//                  String.format("Account %s not found.", accountId));
//        }
        return account.getAccountBalance();
    }
    
    /**
     * Finds all transactions for a given bank account
     * @param accountId - Unique account ID
     * @return List of transactions for a given bank account
     */
    @GetMapping(path = "/accounts/{accountId}/transactions")
  //  @CrossOrigin(origins = "http://localhost:4200")
    public List<Transaction> retrieveAccountTransactions(@PathVariable int accountId) {
        //PrimaryAccount account = primaryAccountDao.findByAccountNumber(accountId);
		/*
		 * if (!account.isPresent()) { throw new AccountNotFoundException(
		 * String.format("Account %s not found.", accountId)); }
		 */
        return transactionService.retrieveTransactionsForAccount(accountId);
    }
    
  
    



}
