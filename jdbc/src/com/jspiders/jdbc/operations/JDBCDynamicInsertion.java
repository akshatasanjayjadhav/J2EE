package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDynamicInsertion {
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;
	
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter user id");
		int id=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter user name");
		String name=scanner.nextLine();
		System.out.println("Enter user email");
		String email =scanner.nextLine();
		System.out.println("Enter password");
		String password =scanner.nextLine();
		System.out.println("Enter mobile number");
		long mobile=scanner.nextLong();
		scanner.close();
		
		try {
			openConnection();
			statement=connection.createStatement();
			query="INSERT INTO user VALUES('"+id+"','"+name+"','"+email+"','"+password+"','"+mobile+"')" ;
			boolean res=statement.execute(query);
			System.out.println(res);
					
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		;
	}
	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/user? user=root&password=root");
		
	}
	private static void closeConnection() throws SQLException {
		if(statement !=null) {
			statement.close();
		}
		if(connection !=null) {
			connection.close();
		}
		if(driver !=null) {
			DriverManager.deregisterDriver(driver);
		}
	}

}
