package com.bankingApplication.ICIN_Bank.repository;


import org.springframework.data.repository.CrudRepository;

import com.bankingApplication.ICIN_Bank.model.CheckingTransaction;
import com.bankingApplication.ICIN_Bank.model.SavingsAccount;

public interface SavingsAccountRepository extends CrudRepository<SavingsAccount, Integer> {
	
	SavingsAccount findByAccountNumber (int accountNumber);

	void save(CheckingTransaction checkingTransaction);

}
