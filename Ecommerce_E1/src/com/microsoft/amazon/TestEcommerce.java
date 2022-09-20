package com.microsoft.amazon;



public class TestEcommerce {
	
	
	public static void main(String[] args) throws InterruptedException {
	
    ProductDetails productDetails=new ProductDetails();
	productDetails.insertData();
	Thread.sleep(3000);
	
	UserRegister userRegister=new UserRegister();
	userRegister.getUserInputForUserRegister();
	Thread.sleep(3000);
	
	AddToCart addToCart=new AddToCart();
	addToCart.getToCart();
	Thread.sleep(3000);
	
	SortedProductData sortedProductData=new SortedProductData();
	sortedProductData.getSortedProductList();
	Thread.sleep(3000);
	
	Admin admin=new Admin();
	admin.getAdmin();
	Thread.sleep(3000);
	
	RegisteredUserList registeredUserList=new RegisteredUserList();
	registeredUserList.getUserList();
	
	System.out.println("THANK YOU FOR VISITING AMAZON HAVE A GREAT DAY");
	
	}

}
