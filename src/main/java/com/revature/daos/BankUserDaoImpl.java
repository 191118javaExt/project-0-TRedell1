package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class BankUserDaoImpl implements BankUserDao {

	@Override
	public List<User> findAll() throws SQLException {
		// represents select * from bank user
		// this is the administrator job to be able to find all 
		// users and their accounts 
		List<User> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.Connect()) {
			
			// This String represents the SQL which we will execute on our database
			String sql = "SELECT * FROM BankUser;";
			
			// This Statement object is a wrapper around our SQL string
			// And is obtained through our connection to the database
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("bankuser_id");
				String bank_type_id = rs.getString("bank_type_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				int password = rs.getInt("password");
				
				User e = new User(id, bank_type_id, first_name, last_name, email, password);
				
				list.add(e);
			}
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list; 
	}

	@Override
	public User findById(int id) throws SQLException {
		//create connection to db
		try (Connection conn = ConnectionUtil.Connect()) {
		
			//query to select user by id from db
			String sql = "SELECT * FROM bankuser WHERE bankuser_id=?";
			//used prepared statement to prevent sql injection with user id
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			//extracting user information from db and storing it in user model in java
			ResultSet rs = ps.executeQuery();
			/*refere here for bs*/
			if (rs.next()) {
				int user_id = rs.getInt("bankuser_id");
				String bank_type_id = rs.getString("bank_type_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				int password = rs.getInt("password");
				
				User u = new User(user_id, bank_type_id, first_name, last_name, email, password);
				return u;
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
	public User insert(User e) {
		try (Connection conn = ConnectionUtil.Connect()) {
			
			
			String sql = "INSERT INTO user (first_name, last_name, email, password) " +
					"VALUES (?, ?, ?, ?, ?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getBank_type_id());
			stmt.setString(2, e.getFirst_name());
			stmt.setString(3, e.getLast_name());
			stmt.setString(4, e.getEmail());
			stmt.setInt(5, e.getPassword());
			
			
			if(!stmt.execute()) {
				return null;
			}
		} catch(SQLException ex) {
			//logger.warn("Unable to retrieve all users", ex);
			ex.printStackTrace();
			return null;
		}
		
		return e;
	}

	@Override
	public boolean update(User e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findUserType(String type) {
		// user find by userID as a template to complete this
		//make connection using try connection conn
		// string sql = "select * from bankuser where bankusertype=?"
		//prepared statment ps = conn.
		//ps.setString(1, type)
		//Result rs = ps.executeQuery
		//copy all that bs from
		return null;
	}

	@Override
	public User findbyUsernameAndPassword(String email, int password) {
		 try(Connection conn = ConnectionUtil.Connect()){
			 String sql = "select * from bankuser where email =? and password =?";
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 stmt.setString(1, email);
			 stmt.setInt(2, password);
			 ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					int id = rs.getInt("bankuser_id");
					String bank_type_id = rs.getString("bank_type_id");
					String first_name = rs.getString("first_name");
					String last_name = rs.getString("last_name");
					email = rs.getString("email");
					password = rs.getInt("password");
					
					User e = new User(id, bank_type_id, first_name, last_name, email, password);
					
					return e;
				}

		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return null;
	}

}
