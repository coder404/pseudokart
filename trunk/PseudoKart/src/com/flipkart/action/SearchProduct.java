package com.flipkart.action;

import java.util.ArrayList;

import com.flipkart.DAO.ProductSelection;
import com.flipkart.model.Product;
import com.opensymphony.xwork2.ActionSupport;

public class SearchProduct extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private String sear;
	private String categ;
	
	

	public String getSear() {
		System.out.println(".....getter......");
		return sear;
	}

	public void setSear(String sear) {
		System.out.println(sear+".....setter......");
		this.sear = sear;
	}

	public String getCateg() {
		System.out.println(".....setter......");
		return categ;
	}

	public void setCateg(String categ) {
		System.out.println(categ+".....getter......");
		this.categ = categ;
	}



	ArrayList<Product> products;
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	
	
	public String execute()
	{
		String selectionModifier;
		System.out.println("this action getter value"+this.categ);
		System.out.println("search "+sear);
		System.out.println("category"+categ);
		if(categ.equals("all"))
			selectionModifier="where name like '"+sear+"%';";
		
		else
		{
		
		String categoryId=ProductSelection.getCategoryID(categ);
		selectionModifier="where name like '"+sear+"%' and categoryID IN (select categoryID from category where parentCatID='"+categoryId+"');";
		
		}System.out.println(selectionModifier);
		products=Product.findAll(selectionModifier);
		System.out.println(products.size());
		
		
		return "success";
	}

}
