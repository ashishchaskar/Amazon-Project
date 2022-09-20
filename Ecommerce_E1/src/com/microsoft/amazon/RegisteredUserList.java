package com.microsoft.amazon;

import java.sql.*;
import java.util.*;


public class RegisteredUserList extends ConnectionDetails {
	
	public void getUserList() {
		
		System.out.println(" Displaying registered users list...");
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
		try {
			List<String> outerList=new ArrayList<String>();
			
			Connection connection = getConnectionDetails();
			
			//Step-3 Prepare Statement

			PreparedStatement prepareStatement = connection.prepareStatement("Select username from registered_users_list ");
			
            //step-4 Execute Query

			ResultSet rs = prepareStatement.executeQuery();
			
			while(rs.next()) {
				
				List<String> innerList=new ArrayList<String>();
				
				innerList.add(rs.getString("username"));
				
				outerList.addAll(innerList);
				
			}
			
	     Iterator<String> itr = outerList.iterator();
	      
	     while(itr.hasNext()) {
	    	 
	    	 System.out.println(itr.next());
	    	 Thread.sleep(1200);
	    	 
	     }
		 
	}catch(Exception e) {
			
			System.out.println(e);
		}
	
	}
}
