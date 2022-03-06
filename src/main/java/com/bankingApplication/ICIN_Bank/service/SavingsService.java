package com.bankingApplication.ICIN_Bank.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bankingApplication.ICIN_Bank.model.CheckingTransaction;
import com.bankingApplication.ICIN_Bank.model.SavingsAccount;
import com.bankingApplication.ICIN_Bank.repository.CheckingAccountRepository;
import com.bankingApplication.ICIN_Bank.repository.SavingsAccountRepository;





public class SavingsService {

	 @Autowired
	    private SavingsAccountRepository savingsAccountRepo;
	 
	    @Autowired
	    private CustomerService custService;
		private static int nextAccountNumber = 2347;
		
		@Autowired
		private CheckingAccountRepository checkingAccRepo;
		
	//	@Autowired
	//	private PersonalTransactionRepository personalTransactionrepo;
		
		public SavingsAccount createSavingsAccount() {
		        SavingsAccount savingsAccount = new SavingsAccount();
		        savingsAccount.setAccountBalance(new Long(0));
		        nextAccountNumber += 1;
		        savingsAccount.setAccountNumber(nextAccountNumber);
		        System.out.println(savingsAccount);
		        savingsAccountRepo.save(savingsAccount);

		        return savingsAccountRepo.findByAccountNumber(savingsAccount.getAccountNumber());
		    }
		public void deposit( Integer accNo, Long amount) {
					SavingsAccount savingsAccount = savingsAccountRepo.findByAccountNumber(accNo);
					Long prevBal = savingsAccount.getAccountBalance();
					Long newBal = savingsAccount.getAccountBalance() + amount;
			        savingsAccount.setAccountBalance((long) (savingsAccount.getAccountBalance() + amount) );
			        savingsAccountRepo.save(savingsAccount);
			        Date date = new Date();
			        CheckingTransaction checkingTransaction = new CheckingTransaction(accNo , date, prevBal, newBal, "Deposit" ,"Savings");
			        checkingAccRepo.save(checkingTransaction);
		        }
		    
		    
		    public String withdraw(Integer accNo, Long amount) {
		    	    SavingsAccount savingsAccount = savingsAccountRepo.findByAccountNumber(accNo);
		    	    if(savingsAccount.getAccountBalance()>=amount) {
		    	    	Long prevBal = savingsAccount.getAccountBalance();
		    	    	Long newBal = savingsAccount.getAccountBalance() - amount;
		    	    	savingsAccount.setAccountBalance(newBal);
		    	    	savingsAccountRepo.save(savingsAccount);
			            Date date = new Date();
			            CheckingTransaction checkingTransaction = new CheckingTransaction(accNo ,date, prevBal, newBal, "Withdraw" ,"Savings");
				        savingsAccountRepo.save(checkingTransaction);
				        return "Done";
		    	    }
		    	    else {
		    	    	return "Insufficient balance";
		    	    }
		            
		    }
		    
		   
			public List<SavingsAccount> getAllSavingsAccounts() {
				// TODO Auto-generated method stub
				return null;
			}

			public SavingsAccount getAccount(int accNo) {
				return savingsAccountRepo.findByAccountNumber(accNo);
			}
			
			
			 public Long retrieveAccountBalance(Integer accountId) throws AccountNotFoundException {
			        Optional<SavingsAccount> account = savingsAccountRepo.findById(accountId);
			        if (!account.isPresent()) {
			           
			                  String.format("Account %s not found.", accountId);
			        }
			        return account.get().getAccountBalance();
			    }
		
}
