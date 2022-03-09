package com.bankingApplication.ICIN_Bank.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankingApplication.ICIN_Bank.model.User;



@Repository
public interface MyRepo extends JpaRepository<User, Integer>{
	User findByMailid(String mailid);
	User findByMailidAndPassword(String mailid, String password);
	public User findById(Long id);

}
