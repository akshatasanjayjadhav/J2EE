package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdate2 {
	private static Driver driver;
	private static Statement statement;
	private static Connection connection;
	private static String query;
	
	public static void main(String[] args) {
		try {
			openConnection();
			statement=connection.createStatement();
			query="UPDATE user SET name='Suresh' where id=1";
			int res=statement.executeUpdate(query);
			System.out.println(res +" row(s) affected");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root","root");
		
	}
	private static void closeConnection() throws SQLException {
		if(statement !=null) {
			statement.close();
		}
		if(connection !=null) {
			connection.close();
		}
		if(driver != null) {
			DriverManager.deregisterDriver(driver);
		}
	}

}
