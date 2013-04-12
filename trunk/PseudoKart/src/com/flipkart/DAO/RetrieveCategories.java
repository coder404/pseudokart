package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.flipkart.model.Category;
import com.flipkart.model.Product;
import com.mast.util.DB;
import com.mast.util.RuntimeSettings;

public class RetrieveCategories {

	
	
	public static ArrayList<Category> getCategories() {
		ArrayList<Category> category=new ArrayList<Category>();
		String selectionModifier="where parentCatID='NA';";
		category=Category.findAll(selectionModifier);
		
			return category;
	}
	public static ArrayList<Category> getSubCategories(String categoryname) {
		
		String categoryID=null;

		ArrayList<Category> category=new ArrayList<Category>();
		
		String selectionModifier="where name='"+categoryname+"';"; 
		Category c=Category.findCategory(selectionModifier);
		categoryID = c.getCategoryID();
		String selectionModifier1="where parentCatID='"+categoryID+"';";
		category=Category.findAll(selectionModifier1);
	    return category;

			
	}
	public static ArrayList<Product> getProducts(String subcategory) {
		
		String categoryID=null;

		ArrayList<Product> product=new ArrayList<Product>();
		String selectionModifier="where name='"+subcategory+"';"; 
		Category c=Category.findCategory(selectionModifier);
		categoryID = c.getCategoryID();
		String selectionModifier1= "where categoryID='"+categoryID+"'";

       product=Product.findAll(selectionModifier1);
       return product;
	}
       
}
