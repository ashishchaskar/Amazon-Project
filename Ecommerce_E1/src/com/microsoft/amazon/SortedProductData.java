package com.microsoft.amazon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SortedProductData extends ConnectionDetails {
	
	public void getSortedProductList() {
	
		try {
			   
		
	 Connection connection = getConnectionDetails();
		         
		     //Prepare Statement
		   
     PreparedStatement prepareStatement = connection.prepareStatement(" Select Name "
				                    + "from products_table order by Name ");   
		    
            //Execute statement
     
     ResultSet rs = prepareStatement.executeQuery();
	
     System.out.println("Displaying Sorted product list by product name");
     Thread.sleep(1000);
     
	 while(rs.next()) {	
		 
		 System.out.println(rs.getString(1));
		 Thread.sleep(1000);
		
	 }
     
	}catch(Exception e) { 
			 
		System.out.println(e);
			   
		}
	}
	
	public static void main(String[] args) {
		
		SortedProductData s= new SortedProductData();
		s.getSortedProductList();
	}	
}

