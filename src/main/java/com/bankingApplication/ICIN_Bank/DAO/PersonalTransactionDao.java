package com.bankingApplication.ICIN_Bank.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingApplication.ICIN_Bank.model.PersonalTransaction;


public interface PersonalTransactionDao extends JpaRepository<PersonalTransaction, Integer>{

}
