package com.microsoft.amazon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AddToCart extends ConnectionDetails implements Ecommerce {
	
	String Name;
	String Quantity;
	String Price;
	
 public void getToCart() {
	  
	  AddToCart cart2=new AddToCart();
	  
	  
	  try {
		  
		  List<String> outer=new LinkedList<String>();
		  
		  Connection connection = getConnectionDetails();
		  
		  PreparedStatement prepareStatement = connection.prepareStatement("Select Name,Quantity,Price from products_table ");
		  
		  ResultSet rs = prepareStatement.executeQuery();
		  
		  System.out.println("We have such attractive products available You can select the product");
		  
		  Thread.sleep(1200);
		  
		  while(rs.next()) {
			  
	    List<String> inner=new LinkedList<String>();
	    
	    Name =rs.getString("Name");
	    inner.add(Name);
		Price=rs.getString("Price");
        Quantity=rs.getString("Quantity");
        outer.addAll(inner);
		
	  System.out.println(Name + " "+ Price+ " "+Quantity);
		
	  Thread.sleep(1200);
	  }
		  
	  System.out.println(outer);
	  Scanner scanner=new Scanner(System.in); 
	  System.out.println("Enter the product u wanna buy");
	  String s1= scanner.nextLine();
	  
	  List<String> outercart=new LinkedList<String>();
	  
	  if(outer.contains(s1)) {	  
		  
		  System.out.println("yes product available we are adding product in cart");
		  Thread.sleep(1200);
          System.out.println("Please check the product price and available quantity in above displayed list");
		  Thread.sleep(1200);
		  List<String> innercart=new LinkedList<String>();
		  innercart.add(s1);
		  outercart.addAll(innercart);
		  
		  
		}else {
			
		System.out.println("Sorry Product unavailable you can select other product");
		System.out.println("please enter other product");
		String s2= scanner.nextLine();
		  
		    if(outer.contains(s2)) {   
		    	
		    	System.out.println("yes product available we are adding product in cart");
				Thread.sleep(1000);
				List<String> innercart2=new LinkedList<String>();
                innercart2.add(s2);
                outercart.addAll(innercart2);

		    }else {
		    	
		    	System.out.println("Sorry this product also unavailable please check list again");
		    	Thread.sleep(1200);
		    	getToCart();
		    }
		
	    }
		Thread.sleep(1000);
	    System.out.println("please see items in your cart and proceed to pay");
	    System.out.println(outercart);
		Thread.sleep(1300);
        System.out.println("Payment done successfully .Thanks for purchasing with Amazon good day");
        
				  
	} catch (Exception e) {
		
		System.out.println(e);
	}
  
  }

@Override
public void insertData() {
	// TODO Auto-generated method stub
	
  }

}


