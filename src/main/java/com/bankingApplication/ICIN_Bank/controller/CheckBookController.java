package com.bankingApplication.ICIN_Bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankingApplication.ICIN_Bank.model.CheckBook;
import com.bankingApplication.ICIN_Bank.service.CheckBookService;


@RestController
public class CheckBookController {

	
	@Autowired
	CheckBookService chkService;
	
	@PostMapping("/createcheck")
	public CheckBook createCheckBook(@RequestBody CheckBook checkbook) {
		System.out.println(checkbook);
		String cust = checkbook.getCustName();
		return chkService.createCheckBook(checkbook,cust);
		
	}

	@GetMapping("/allchecks")
	public List<CheckBook> AllChequeBooks() {
		return chkService.listAll();
	}

	@GetMapping("/getcheck/{id}")
	public CheckBook findCheckbookById(@PathVariable("id") int id) {
		return (CheckBook) chkService.findByCheckNo(id);
	}

	
	
}
