package com.revature.daos;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.BankAccounts;
import com.revature.models.BankTransaction;

public interface BankTransactionDao {
		

		public List<BankTransaction> findAll() throws SQLException;
		public BankTransaction findById(int id);
		public BankTransaction insert(BankTransaction t);
		public boolean update(BankTransaction t);
		public BankTransaction findAccountType(String type);

	}




