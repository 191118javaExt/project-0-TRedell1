package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.BankAccounts;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class BankAccountDaoImpl implements BankAccountDao {
	
	public List<BankAccounts> findAll() throws SQLException {
		// represents select * from bank user
		// this is the administrator job to be able to find all 
		// users and their accounts 
		List<BankAccounts> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.Connect()) {
			
			String sql = "SELECT * FROM BankAccount";
			
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("bankaccount_id");
				String account_type = rs.getString("account_type");
				int bankuser_id = rs.getInt("bankuser_id");
				Float balance = rs.getFloat("balance");
				String account_open = rs.getString("account_open");
				
				BankAccounts a = new BankAccounts(id, account_type, bankuser_id, balance, account_open);
				
				list.add(a);
			}
			rs.close();
		}
		catch (SQLException a) {
			a.printStackTrace();
			return null;
		}
		return list; 
	}
	
	public BankAccounts insert(BankAccounts a) {
		try (Connection conn = ConnectionUtil.Connect()) {
			
			
			String sql = "INSERT INTO user (first_name, last_name, email, password) " +
					"VALUES (?, ?, ?, ?, ?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, a.getBankacount_id());
			stmt.setString(2, a.getAccount_type());
			stmt.setInt(3, a.getBankacount_id());
			stmt.setFloat(4, a.getBalance());
			stmt.setString(4, a.getAccount_open());
			
			
			if(!stmt.execute()) {
				return null;
			}
		} catch(SQLException ex) {
			//logger.warn("Unable to retrieve all users", ex);
			ex.printStackTrace();
			return null;
		}
		
		return a;
	}
	@Override
	public BankAccounts findById(int id) {
		try (Connection conn = ConnectionUtil.Connect()) {
			
			//query to select user by id from db
			String sql = "SELECT * FROM bankaccount WHERE bankaccount_id=?";
			//used prepared statement to prevent sql injection with user id
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			//extracting user information from db and storing it in user model in java
			ResultSet rs = ps.executeQuery();
			/*refere here for bs*/
			if (rs.next()) {
				int bankaccount_id = rs.getInt("bankaccount_id");
				String account_type = rs.getString("account_type");
				int bankuser_id = rs.getInt("bankuser_id");
				Float balance = rs.getFloat("balance");
				String account_open = rs.getString("account_open");
				
				BankAccounts a = new BankAccounts(bankaccount_id, account_type, bankuser_id, balance, account_open);
				return a;
			}else {
				//if extracting user from db unsuccessful return null
				return null;
			}
			
		} catch (SQLException e) {
			//and print stack trace if catch errors
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public boolean update(BankAccounts a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BankAccounts findAccountType(String type) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

