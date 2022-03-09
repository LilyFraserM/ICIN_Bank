package com.bankingApplication.ICIN_Bank.service;

import java.util.List;

import com.bankingApplication.ICIN_Bank.model.ChequeBook;
import com.bankingApplication.ICIN_Bank.model.User;



public interface ChequeBookService {
	public ChequeBook createChequeBook(ChequeBook chequebook,User user);
	public List<ChequeBook> AllChequeBooks();
	public ChequeBook findChequebookById(long id);
	public void ChequeBookRequestTrue(long id);
	public void ChequeBookRequestFalse(long id);
	

}
