package com.bankingApplication.ICIN_Bank.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingApplication.ICIN_Bank.model.ChequeBook;



public interface ChequeBookDao extends JpaRepository<ChequeBook,Long> {
	

}
