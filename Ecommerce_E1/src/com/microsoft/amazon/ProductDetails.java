package com.microsoft.amazon;

import java.sql.*;
import java.util.*;


public class ProductDetails extends ConnectionDetails implements Ecommerce{
	
	//Declare DB Connection
	Connection connection=null;
	PreparedStatement prepareStatement =null;
	
	public void insertData(){
		
		
		  
		  try {
			
			String sql="insert into products_table (Name,Price,Quantity,Description)"
					+ "Values ('Iphone','45000','2','ram 128 gb'), "
					+"('Washing machine','40000','3','front load type'),"
					+"('Organic wheat','500','4','purely organic'),"
					+"('Edible oil','200','3','almond oil'),"
					+"('Soap','50','2','bathing soap'),"
					+"('Facewash','100','5','for oily skin'),"
					+"('T shirt','400','3','polo t shirt'),"
					+"('Saree','1000','4','silk saree'),"
					+"('sofa','4500','4','luxurious'),"
					+"('study table','5500','3','for kids')";
			  
			Connection connection = getConnectionDetails();
		    
			
			//step-3  Create the sql Statement
			
			        Statement statement = connection.createStatement();
			
			
		   //step-4 Submit sql statement to database
		    
		     statement.executeUpdate(sql);
		    
		    System.out.println("Product list  inserted successfully " );
		    
		} catch (Exception e) {
			
			System.out.println(e);
		}
		  
 
	}
	
	static {
		   
		   System.out.println("Welcome To Amazon Have A Great Shopping");
		   
		   try {
			Thread.sleep(1200);
		} catch (Exception e) {
			
			System.out.println(e);
		}
		   
	   }
	@Override
	public void getToCart() {
		// TODO Auto-generated method stub
		
	}

}

