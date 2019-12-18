package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.daos.BankUserDao;
import com.revature.daos.BankUserDaoImpl;
import com.revature.models.User;

public class BankUserService {

	BankUserDao repository = null;
	
	public BankUserService() {
		repository = new BankUserDaoImpl();
	}
		

	public List<User> findAll() throws SQLException {
		return repository.findAll();
	}

	public BankUserService(BankUserDao dao) {
		repository = dao;
	}
	
//	public boolean insert(User u) {
//		return repository.insert(u);
//	}
	
	
	public boolean login(String email, int password) {
		BankUserDao u = new BankUserDaoImpl();
		u.findbyUsernameAndPassword(email, password);
//		if(email == "correctEmail") {
//			if(password == u.) {
		if (u.findbyUsernameAndPassword(email, password) != null) {
				return true;
		}
		return false; 
//		BankUserDao u = new BankUserDaoImpl();
		
//		User dao = (User) u;
//		return dao;
		
	}
	
	public User findbyUsernameAndPassword(String email, int password) {

		return repository.findbyUsernameAndPassword(email, password);
		
	}
	
	public User createBankUser(int id, String userType, String fname, String lname,String email, int pw) {
		return new User(0, userType, fname, lname, email, pw);
	}
}
