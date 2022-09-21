package com.microsoft.amazon;

import java.sql.*;
import java.util.*;

public class User extends ConnectionDetails {
	
	String u;
	String p;
	
	public void checkUser() {
		
		System.out.println("----------------------------");
		System.out.println("Enter login credentials.....");
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your registered username");
		u = scanner.nextLine();
			
		System.out.println("Enter your password");
	    p = scanner.nextLine();
		
	HashMap<String, String> outer=new HashMap<String,String>();	
	    
	      
	try {
		
	       Connection connection = getConnectionDetails();
	       
	       PreparedStatement prepareStatement = connection.prepareStatement("select username,user_password from registered_users_list");
	
	       ResultSet rs = prepareStatement.executeQuery(); 
	      
	    while(rs.next()) {
	    	   
	    	HashMap<String, String> inner=new HashMap<String,String>();
	    	
	        inner.put(rs.getString("username"), rs.getString("user_password")); 
	        
	        outer.putAll(inner);
	    	
	         }
	    
	    
	    if((outer.containsKey(u))&&(outer.containsValue(p))){
			  
    		  
  	 	  AddToCart addToCart=new AddToCart();
			  
			  addToCart.getToCart();
  		  
  	  
  	    
	}else {
		  
		  System.err.println("Please enter valid registered username and password");
		  User user2=new User();
		  user2.checkUser();
		
	}
	       
	  }catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
}

