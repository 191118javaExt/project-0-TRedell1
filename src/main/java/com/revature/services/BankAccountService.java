package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.daos.BankAccountDao;
import com.revature.daos.BankAccountDaoImpl;
import com.revature.daos.BankUserDaoImpl;
import com.revature.models.BankAccounts;


public class BankAccountService {

BankAccountDao repository = null;
	
	public BankAccountService() {
		repository = new BankAccountDaoImpl();
	}
		

	public List<BankAccounts> findAll() throws SQLException {
		return repository.findAll();
	}

	public BankAccountService(BankAccountDao dao) {
		repository = dao;
	}
	
//	public boolean insert(BankAccounts a ) {
//		return repository.insert(a);
//	}
	
}
