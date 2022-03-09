package com.bankingApplication.ICIN_Bank.service;

import java.util.List;
import java.util.Set;

import com.bankingApplication.ICIN_Bank.model.User;



public interface UserService {
    User findByEmail(String email);
	User findByUsername(String name);
	User findByFullname(String name);
}
