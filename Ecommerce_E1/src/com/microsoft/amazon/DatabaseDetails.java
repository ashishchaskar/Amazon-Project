package com.microsoft.amazon;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseDetails {
	
	 static final String USERNAME ="root";
	 static final String PASSWORD ="root";
	 static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	 static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
	 Connection connection = null;

	 public Connection getConnection() {
		 try {
			 Class.forName(DRIVER);
				
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
//			System.out.println("Successfully..");
			 
		 }catch(Exception e) {
			 System.out.println(e);
		 }
		 
		 return connection;
	 }
	
}
