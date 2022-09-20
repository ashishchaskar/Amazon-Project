package com.microsoft.amazon;

import java.sql.*;
import java.util.*;

public class UserRegister extends ConnectionDetails  {

	Scanner scanner=new Scanner(System.in);
	String username,mobile_number,email_id,user_password=null;
	String emailFormat="@gmail.com";
	
	public void registerUser(String username,String mobile_number,String email_id, String user_password  ) {
		
		  try {
		      
			  Connection connection = getConnectionDetails();
		      
    //Step - 3 : Prepare Statement
		      
	PreparedStatement prepareStatement = connection.prepareStatement("insert into registered_users_list "+
		                    "(username,mobile_number,email_id,user_password)values(?,?,?,?)");
	
	         prepareStatement.setString(1, username);
	         prepareStatement.setString(2, mobile_number);
	         prepareStatement.setString(3, email_id);
	         prepareStatement.setString(4, user_password);
		      
	//Step -4: Execute Prepare statement
	
	                    int k = prepareStatement.executeUpdate();
	                    
	         System.out.println("Data inserted successfully");           
	         System.out.println("----------------------");

	                   
		        }catch(Exception e) {
		    	 
		    	 System.out.println(e);
		        
		    }
	
	}
	
	public void getUserInputForUserRegister() {
		
		System.out.println("------Enter Details of Registration of Users----------");
		
		
			System.out.println("Enter Username");
			username = scanner.nextLine();
			System.out.println("----------------");
			System.out.println("Enter Mobile number");
			mobile_number = scanner.nextLine();
			System.out.println("----------------");
			System.out.println("Enter email id");
			email_id=scanner.nextLine();
			System.out.println("----------------");
			if(email_id.endsWith(emailFormat)) {
				
				System.out.println("Enter Password");
				user_password=scanner.nextLine();
				System.out.println("----------------");


				registerUser(username,mobile_number,email_id,user_password);
				
			}else {
				
				System.err.println("Please enter valid email");
			    getUserInputForUserRegister();
			}
		
		
	 }
	
}

