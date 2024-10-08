package com.jspiders.jdbc.operations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCCall2 {
	private static Driver driver;
	private static Connection connection;
	private static CallableStatement callableStatement;
	private static ResultSet resultSet;
	private static String query;
	
	public static void main(String[] args) {
		System.out.println("Enter user id");
		Scanner scanner=new Scanner(System.in);
		int id=scanner.nextInt();
		scanner.close();
		try {
			openConnection();
			query="call fetchUserById(?)";
			callableStatement=connection.prepareCall(query);
			callableStatement.setInt(1,id);
			boolean res=callableStatement.execute();
			System.out.println(res);
			resultSet=callableStatement.getResultSet();
			if(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
				System.out.println(resultSet.getLong(5));
				
			}else
				System.out.println("User Not Found");
			
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
	
	private static void openConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/user" ,"root" ,"root");
		
	}
	private static void closeConnection() throws SQLException {
		if(callableStatement != null) {
			callableStatement.close();
		}
		if(connection != null) {
			connection.close();
		}
		if(driver != null) {
			DriverManager.deregisterDriver(driver);
		}
	}

}
