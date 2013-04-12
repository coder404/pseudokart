package com.flipkart.action;
import com.flipkart.DAO.*;

import com.opensymphony.xwork2.ActionSupport;

public class AddProductsAction extends ActionSupport {
	
	
	String category;
	String name;
	String price;
	String ProductID;
	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getProductID() {
		return ProductID;
	}



	public void setProductID(String productID) {
		ProductID = productID;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	String Description;

	
	
	public String execute()
	{	
		
		
		int a= AddProducts.addProducts(category, ProductID,name,price,Description);
		System.out.println(a);
		return "success";
		
		
	}

}
