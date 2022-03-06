package com.bankingApplication.ICIN_Bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bankingApplication.ICIN_Bank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> retrieveTransactionsForAccount(int accountNumber);

    public void transferMoney(Transaction transaction);
    
    public int retreiveAccountNumber(Long id);

}
