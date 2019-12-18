package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionUtil {
//		static String url = "jdbc:postgresql://localhost:5432/";
//		static String username = "postgres";
//		static String password = "Dolphin23";
	
		// private static Logger logger = Logger.getLogger(ConnectionUtil.class);
		 static Logger logger = Logger.getAnonymousLogger();

	public static Connection Connect() throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/";
		String username = "postgres";
		String password = "Dolphin23";
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, username, password);
				System.out.println("Connection Successful");
			}catch (SQLException e) {
				logger.warning("Connection Failed");
				e.printStackTrace();
			}
			return conn;
		
	}
//		public static void main(String [] args) throws SQLException {
//			@SuppressWarnings("unused")
//			ConnectionUtil ConnectionUtil = new ConnectionUtil();
//			com.revature.util.ConnectionUtil.Connect();
//		}
//		public static Connection getConnection() {
//			// TODO Auto-generated method stub
//			return null;
//		}
}
