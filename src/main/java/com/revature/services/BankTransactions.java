package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.daos.BankTransactionDao;
import com.revature.daos.BankTransactionDaoImpl;
import com.revature.models.BankTransaction;


public class BankTransactions {

BankTransactionDao repository = null;
	
	public BankTransactions() {
		repository = new BankTransactionDaoImpl();
	}
		

	public List<BankTransaction> findAll() throws SQLException {
		return repository.findAll();
	}

	public BankTransactions(BankTransactionDao dao) {
		repository = dao;
	}
	
}
