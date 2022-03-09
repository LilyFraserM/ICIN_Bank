package com.bankingApplication.ICIN_Bank.DAO;

import org.springframework.data.repository.CrudRepository;

import com.bankingApplication.ICIN_Bank.model.User;



public interface UserRepo extends CrudRepository<User, Long> {
	User findByMailid(String mailid);

	User findByFullname(String name);
}
