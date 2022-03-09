package com.bankingApplication.ICIN_Bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingApplication.ICIN_Bank.model.User;


@Service
public class AdminService {
	
	@Autowired
	com.bankingApplication.ICIN_Bank.DAO.MyRepo repo;
	
	public List<User> getAllUsers(){
		return (List<User>) repo.findAll();
		
	}
	
	public User getUserById( long id) {
		return repo.findById(id);
		
	}
	
	public void deleteUserById(long id) {
		repo.delete(repo.findById(id));
		
	}	
	
}
