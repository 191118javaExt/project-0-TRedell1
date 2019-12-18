package com.revature.daos;

import java.sql.SQLException;
import java.util.List;
import com.revature.models.BankAccounts;

public interface BankAccountDao {
		

	public List<BankAccounts> findAll() throws SQLException;
	public BankAccounts findById(int id);
	public BankAccounts insert(BankAccounts a);
	public boolean update(BankAccounts a);
	public BankAccounts findAccountType(String type);
	

}
