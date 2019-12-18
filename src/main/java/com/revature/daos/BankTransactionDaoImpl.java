package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.BankTransaction;
import com.revature.util.ConnectionUtil;

public class BankTransactionDaoImpl implements BankTransactionDao {

	public List<BankTransaction> findAll() throws SQLException {
		// represents select * from bank user
		// this is the administrator job to be able to find all 
		// users and their accounts 
		List<BankTransaction> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.Connect()) {
			
			String sql = "SELECT * FROM BankTransaction";
			
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("banktransaction_id");
				int bankaccount_id = rs.getInt("bankaccount_id");
				String bankuser_id = rs.getString("bankuser_id");
				Float amount = rs.getFloat("amount");
				
				BankTransaction t = new BankTransaction(id, bankaccount_id, bankuser_id, amount);
				
				list.add(t);
			}
			rs.close();
		}
		catch (SQLException t) {
			t.printStackTrace();
			return null;
		}
		return list; 
	}
	
	public BankTransaction insert(BankTransaction t) {
		try (Connection conn = ConnectionUtil.Connect()) {
			
			
			String sql = "INSERT INTO user (first_name, last_name, email, password) " +
					"VALUES (?, ?, ?, ?, ?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, t.getBanktransaction_id());
			stmt.setInt(2, t.getBankaccount_id());
			stmt.setString(3, t.getBankuser_id());
			stmt.setFloat(4, t.getAmount());
			
			if(!stmt.execute()) {
				return null;
				} 
			}catch(SQLException ex) {
				//logger.warn("Unable to retrieve all users", ex);
				ex.printStackTrace();
				return null;
			}
			
			return t;
		}

public BankTransaction findById(int id) {
	try (Connection conn = ConnectionUtil.Connect()) {
		
		//query to select user by id from db
		String sql = "SELECT * FROM banktransaction WHERE banktransaction_id=?";
		//used prepared statement to prevent sql injection with user id
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		//extracting user information from db and storing it in user model in java
		ResultSet rs = ps.executeQuery();
		/*refere here for bs*/
		if (rs.next()) {
			int banktransaction_id = rs.getInt("banktransaction_id");
			int bankaccount_id = rs.getInt("bankaccount_id");
			String bankuser_id = rs.getString("bankuser_id");
			Float amount = rs.getFloat("amount");
			
			BankTransaction t = new BankTransaction(banktransaction_id, bankaccount_id, bankuser_id, amount);
			return t;
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
public boolean update(BankTransaction t) {
	// TODO Auto-generated method stub
	return true;
}

@Override
public BankTransaction findAccountType(String type) {
	// TODO Auto-generated method stub
	return null;
}
}

