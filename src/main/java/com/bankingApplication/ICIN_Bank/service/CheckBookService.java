package com.bankingApplication.ICIN_Bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingApplication.ICIN_Bank.model.CheckBook;
import com.bankingApplication.ICIN_Bank.repository.checkBookRepository;


@Service
@Transactional
public class CheckBookService {

	@Autowired
	private checkBookRepository checkBookRepo;
	
	
	public List<CheckBook> listAll() {
		return (List<CheckBook>) checkBookRepo.findAll();
	}

	public List<CheckBook> findByCheckNo(int id) {
		return checkBookRepo.findBycheckNo(id);
	}

	public CheckBook createCheckBook(CheckBook checkbook, String cust) {
		// TODO Auto-generated method stub
		return null;
	}

}
