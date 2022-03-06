package com.bankingApplication.ICIN_Bank.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.bankingApplication.ICIN_Bank.service.CustomerService;
import com.bankingApplication.ICIN_Bank.model.customers;

@RestController
public class CustomerController {


	
	@Autowired
	private CustomerService service;
	
	
	
	// retrieve all customers from database
	@GetMapping("/customers")
	public List<customers> list() {
        return service.listAllCustomer();
    }
	

	
	//get particular customers by their ID
		@GetMapping("/customers/{custid}")
		public ResponseEntity<customers> getCustomer(@PathVariable Integer custid)
		{
			try {
				customers cust= service.getCustomer(custid);
				return new ResponseEntity<customers>(cust,HttpStatus.OK);
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				return new ResponseEntity<customers>(HttpStatus.NOT_FOUND);
			}
		}
	// insert new customer into user table
	@PostMapping("/customers")
	public void add(@RequestBody customers customer)
	{
		service.saveCustomer(customer);
	}
	
	@PutMapping("customers/{custid}")
	public ResponseEntity<?> update(@RequestBody customers customer, @PathVariable Integer custid){
	
		try {
			customers customerExists = service.getCustomer(custid);
			service.saveCustomer(customer);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// delete particular student from database
	@DeleteMapping("customers/{custid}")
	public void deleteCustomer(@PathVariable int custid)
	{
		service.deleteCustomer(custid);
	}


}
