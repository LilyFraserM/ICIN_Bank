package com.bankingApplication.ICIN_Bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bankingApplication.ICIN_Bank.model.CheckingAccount;
import com.bankingApplication.ICIN_Bank.model.CheckingTransaction;




public interface CheckingAccountRepository  extends CrudRepository<CheckingAccount, Integer> {
	
	static CheckingAccount findByAccountNumber (int accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	public CheckingAccount createPrimaryAccount();
	public String withdraw(Integer accountNumber, int amount);
	public void deposit(Integer accountNumber, int amount);
	
    public Long retrieveAccountBalance(int accountId);
	void save(CheckingTransaction checkingTransaction);
    
	
   

}
