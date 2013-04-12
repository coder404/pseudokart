package com.flipkart.action;

import java.util.ArrayList;

import com.flipkart.DAO.ProductSelection;
import com.flipkart.model.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ShowAllProducts extends ActionSupport{
	
	ArrayList<Product> allmobiles = new ArrayList<Product>();
	
	public ArrayList<Product> getAllmobiles() {
		return allmobiles;
	}

	public void setAllmobiles(ArrayList<Product> allmobiles) {
		this.allmobiles = allmobiles;
	}

	public String execute() {
		
		return "success";
	}
	
	public String showAllMobiles()
	{
		
		allmobiles=ProductSelection.getAllProducts("Mobiles & Tablets");
		this.setAllmobiles(allmobiles);
		System.out.println("mobiles size is "+allmobiles.size());
		return "success";
	}
	
	

}
