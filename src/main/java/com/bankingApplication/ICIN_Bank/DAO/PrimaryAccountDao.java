package com.bankingApplication.ICIN_Bank.DAO;

import org.springframework.data.repository.CrudRepository;

import com.bankingApplication.ICIN_Bank.model.PrimaryAccount;



public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber (int accountNumber);

}
