package com.flipkart.action;


import java.util.ArrayList;

import com.flipkart.model.Product;
import com.opensymphony.xwork2.ActionSupport;

public class SearchProductAction extends ActionSupport{
	
	/**
	 * 
	 */

	ArrayList<Product> products;
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	private static final long serialVersionUID = 1L;
	
	String searchedProduct;

	public String getSearchedProduct() {
		return searchedProduct;
	}

	public void setSearchedProduct(String searchedProduct) {
		this.searchedProduct = searchedProduct;
	}

	public String execute()
	{	
		
		System.out.println("searched item: "+ searchedProduct);
		String selectionModifier="where name like '"+searchedProduct+"%'";
		System.out.println(selectionModifier);
		products=Product.findAll(selectionModifier);
		System.out.println(products.size());
		return "success";
		
		
	}

}
