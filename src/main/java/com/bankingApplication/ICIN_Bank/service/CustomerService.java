package com.bankingApplication.ICIN_Bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingApplication.ICIN_Bank.model.customers;
import com.bankingApplication.ICIN_Bank.repository.customerRepository;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private customerRepository customerRepository;

	public List<customers> listAllCustomer() {
		return customerRepository.findAll();
	}

	public void saveCustomer(customers cust) {
		customerRepository.save(cust);
	}

	public customers getCustomer(Integer custid) {
		return customerRepository.findById(custid).get();
	}

	public void deleteCustomer(Integer custid) {
		customerRepository.deleteById(custid);
	}


}
