package com.revature.daos;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.User;

public interface BankUserDao {


		public List<User> findAll() throws SQLException;
		public User findById(int id) throws SQLException;
		public User insert(User e);
		//public boolean insert(User e);
		public boolean update(User e);
		public User findUserType(String type); 
		
		public User findbyUsernameAndPassword(String email, int password);
		// Makes sure that the user name and password works
		
		

}
