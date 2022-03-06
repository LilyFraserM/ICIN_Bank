package com.bankingApplication.ICIN_Bank.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.bankingApplication.ICIN_Bank.model.CheckingAccount;
import com.bankingApplication.ICIN_Bank.model.CheckingTransaction;
import com.bankingApplication.ICIN_Bank.model.Transaction;
import com.bankingApplication.ICIN_Bank.repository.CheckingAccountRepository;
import com.bankingApplication.ICIN_Bank.repository.checkBookRepository;


@Service 
@Transactional
public class CheckingService {


	@Autowired
	private CheckingAccountRepository checkingAccRepo;
	
	private static int nextAccountNumber = 3344;
	

	public CheckingAccount createCheckingAccount() {
		CheckingAccount checkingAccount = new CheckingAccount();
		checkingAccount.setAccountBalance(new Long(0));
        nextAccountNumber += 1;
        checkingAccount.setAccountNumber(nextAccountNumber);
        checkingAccRepo.save(checkingAccount);
        return CheckingAccountRepository.findByAccountNumber(checkingAccount.getAccountNumber());
	}

	public List<CheckingAccount> getAllCheckingAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deposit(Integer accountNumber, long l) {
		//System.out.println(accNo);
		
		CheckingAccount checkingAccount = CheckingAccountRepository.findByAccountNumber(accountNumber);
      	Long prevBal = checkingAccount.getAccountBalance();
      	Long newBal = checkingAccount.getAccountBalance() + l;
      	checkingAccount.setAccountBalance(newBal );
      	checkingAccRepo.save(checkingAccount);
        
        Date date = new Date();
        CheckingTransaction checkingTransaction = new CheckingTransaction(accountNumber ,date, prevBal , newBal, "Deposit" ,"Checking");
        checkingAccRepo.save(checkingTransaction);

		
	}

	public String withdraw(Integer accNo, Long amount){
		CheckingAccount chkngAccount = CheckingAccountRepository.findByAccountNumber(accNo);
		
		if(chkngAccount.getAccountBalance()>=amount) {
			Long prevBal = chkngAccount.getAccountBalance();
			Long newBal = chkngAccount.getAccountBalance() - amount;
			chkngAccount.setAccountBalance(newBal);
			checkingAccRepo.save(chkngAccount);
	        Date date = new Date();
	        CheckingTransaction checkingTransaction = new CheckingTransaction(accNo ,date, prevBal, newBal, "Withdraw" ,"Primary");
	        checkingAccRepo.save(checkingTransaction);

	        return "Done";
		} else {
			return "Insufficient Balance";
		}

		
	}

	public static CheckingAccount getAccount(int accNo) {
		return CheckingAccountRepository.findByAccountNumber(accNo);
	}


    public Long retrieveAccountBalance(Integer accountId) throws AccountNotFoundException {
        Optional<CheckingAccount> account = checkingAccRepo.findById(accountId);
        if (!account.isPresent()) {
            throw new AccountNotFoundException(
                  String.format("Account %s not found.", accountId));
        }
        return account.get().getAccountBalance();
    }
    
  
}
