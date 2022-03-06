package com.bankingApplication.ICIN_Bank.service;

import java.util.List;
import java.util.Optional;

import javax.activity.InvalidActivityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingApplication.ICIN_Bank.model.CheckingAccount;
import com.bankingApplication.ICIN_Bank.model.Transaction;
import com.bankingApplication.ICIN_Bank.repository.CheckingAccountRepository;
import com.bankingApplication.ICIN_Bank.repository.TransactionRepository;



@Service
public class TransactionService {

	  @Autowired
	    private TransactionRepository transactionRepository;
	  
	  @Autowired
		private CheckingAccountRepository checkingAccRepo;
	  
	  
	   public List<Transaction> retrieveTransactionsForAccount(int accountNumber) {
	        
	        return transactionRepository.retrieveTransactionsForAccount(accountNumber);
	    }
	    
	    public void transferMoney(Transaction transaction) throws Exception {

	       CheckingAccount sourceAccount = 
	    		   CheckingAccountRepository.findByAccountNumber(transaction.getSourceAccountnumber());
	       CheckingAccount destinationAccount = 
	    		   CheckingAccountRepository.findByAccountNumber(transaction.getDestinationAccountnumber());
	        if (sourceAccount==null || destinationAccount==null) {
	            throw new InvalidActivityException(
	                    "Invalid source account " + "or destination account ");
	        }

	        transaction.runValidationTests(
	                sourceAccount, destinationAccount);

	        Long transactionAmount = 
	                transaction.getTransactionAmount();
	        sourceAccount.setAccountBalance(
	                sourceAccount.getAccountBalance() - transactionAmount); // subtraction logic
	        destinationAccount.setAccountBalance(
	                destinationAccount.getAccountBalance() + transactionAmount); // addition logic

	        transactionRepository.save(transaction);

	        checkingAccRepo.save(sourceAccount);
	        checkingAccRepo.save(destinationAccount);

	    }

		public int retreiveAccountNumber(Integer id) {
			Optional<CheckingAccount> account =  checkingAccRepo.findById(id);
			int accNo = account.get().getAccountNumber();
			return accNo;
		}

		
		
	    
}
