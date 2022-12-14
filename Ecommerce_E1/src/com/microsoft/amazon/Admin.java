 package com.microsoft.amazon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Admin extends ConnectionDetails {
	
	String pName;
	String pQuantity;
	
	public void getAdmin() throws InterruptedException {
		
		String adminUserName="Admin";
		String adminPassword="12345";
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter admin username");
        String s1 = scanner.nextLine();		
		System.out.println("--------------------");

        System.out.println("Enter admin password");
        String s2=scanner.nextLine();
		System.out.println("--------------------");

        
        if((s1.equals(adminUserName))&&(s2.equals(adminPassword))) {
        	
        	System.out.println("Admin successfully logged in....");
    		System.out.println("--------------------------------");
            Thread.sleep(1200);
        	System.out.println("Hey Admin please check Available Product name And Quantity");
        	Thread.sleep(1200);
    		System.out.println("----------------------------------------------------------");

        	try {
        	
        Connection connection = getConnectionDetails();
        	
        	//Prepare Statement
       PreparedStatement prepareStatement = connection.prepareStatement("select Product_id,Name,Quantity from products_table");
       
           //execute statement
       ResultSet rs = prepareStatement.executeQuery();
        
		  System.out.printf("%15s  %15s ", "NAME", "QUANTITY");

       while (rs.next()) { 	
    	   
    	 pName=rs.getString("Name"); 
    	 pQuantity=rs.getString("Quantity");
         System.out.printf("\n" + "%15s %15s  ", pName,pQuantity);		  

    	 
    	   Thread.sleep(1200);
    	   
       }
    		   
     }catch(Exception e) {
        		
    	 System.out.println(e);
        		
       }
        	
   }else {
        	
        	System.err.println("Please enter correct admin username password");
			System.out.println("--------------------------------------------");

        	getAdmin();
        	
        }
	
	 }
	
}
