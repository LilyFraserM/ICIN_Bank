package com.bankingApplication.ICIN_Bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingApplication.ICIN_Bank.model.CheckBook;
import com.bankingApplication.ICIN_Bank.model.customers;

public interface customerRepository extends JpaRepository<customers, Integer>  {


}
