package com.bankingApplication.ICIN_Bank.DAO;


import org.springframework.data.repository.CrudRepository;

import com.bankingApplication.ICIN_Bank.model.SavingsAccount;


public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber (int accountNumber);

}
