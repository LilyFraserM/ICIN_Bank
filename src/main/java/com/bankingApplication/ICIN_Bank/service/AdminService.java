package com.bankingApplication.ICIN_Bank.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingApplication.ICIN_Bank.model.Admin;
import com.bankingApplication.ICIN_Bank.repository.adminRepository;


@Service
@Transactional
public class AdminService {

	
	@Autowired
	private adminRepository admRepository;

	

	public Admin getAdmin(Integer admin_id) {
		return admRepository.findById(admin_id).get();
	}

	



}
