package com.bankingApplication.ICIN_Bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingApplication.ICIN_Bank.model.CheckingTransaction;



public interface CheckingTransactionRepository extends JpaRepository<CheckingTransaction, Integer> {

}
