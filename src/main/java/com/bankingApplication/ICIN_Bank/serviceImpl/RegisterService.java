package com.bankingApplication.ICIN_Bank.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingApplication.ICIN_Bank.DAO.MyRepo;
import com.bankingApplication.ICIN_Bank.model.User;
import com.bankingApplication.ICIN_Bank.service.PrimaryAccountService;
import com.bankingApplication.ICIN_Bank.service.SavingsAccountService;




@Service
public class RegisterService {
	
	@Autowired
	MyRepo repo;
	@Autowired
	private SavingsAccountService savingsAccountService;
	
	@Autowired
	private PrimaryAccountService primaryAccountService; 
		
	
	public User addUser(User user)
	{
		user.setPrimaryAccount(primaryAccountService.createPrimaryAccount());
        user.setSavingsAccount(savingsAccountService.createSavingsAccount());
        return repo.save(user);
	}
	
	public User matchEmailPassword(String mailid, String password)
	{
		return repo.findByMailidAndPassword(mailid, password);
	}
}
