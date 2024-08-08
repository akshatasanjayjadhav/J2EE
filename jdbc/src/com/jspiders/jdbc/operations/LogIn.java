package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LogIn {
	private static Driver driver;
	private static Statement statement;
	private static Connection connection;
	private static String query;
	private static ResultSet resultSet;
	
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter user email");
		String email=scanner.nextLine();
		System.out.println("Enter password");
		String password=scanner.nextLine();
		scanner.close();
		try {
			openConnection();
			statement=connection.createStatement();
			query="SELECT * FROM user WHERE email= '"+email+"' AND password='"+password+"'";
			boolean res = statement.execute(query);
			System.out.println(res);
			resultSet = statement.getResultSet();
			if (resultSet.next())
				System.out.println("User found");
			else
				System.out.println("Invalid email or password");
			
			
			
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
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root&password=root");

		
	}
	private static void closeConnection() throws SQLException {

		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
		if (driver != null) {
			DriverManager.deregisterDriver(driver);
		}

	}


}
