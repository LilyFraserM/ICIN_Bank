package com.bankingApplication.ICIN_Bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bankingApplication.ICIN_Bank.model.CheckBook;


public interface checkBookRepository extends CrudRepository<CheckBook, Integer>  {
		
//	public List<CheckBook> AllCheckBooks();
	
	public List<CheckBook>findBycheckNo(int id);
	
	
	
	
}
