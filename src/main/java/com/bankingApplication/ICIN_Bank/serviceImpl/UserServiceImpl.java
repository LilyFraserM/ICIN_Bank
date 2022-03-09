package com.bankingApplication.ICIN_Bank.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingApplication.ICIN_Bank.DAO.UserRepo;
import com.bankingApplication.ICIN_Bank.model.User;
import com.bankingApplication.ICIN_Bank.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	 
	 @Autowired
	 private UserRepo userRepo;
	 
	 public User findByEmail(String email) {
	        return userRepo.findByMailid(email);
	    }

	@Override
	public User findByUsername(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByFullname(String name) {
		return userRepo.findByFullname(name);
	}
}
