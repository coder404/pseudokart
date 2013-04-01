package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mast.util.DB;
import com.mast.util.MyLog;


public class Product {

	String prodid;
	String name;
	String categoryID;
	Double price;
	String description;

	
	
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public static Product findProduct(String selectionModifier)
	{

		ResultSet rs=null;
		String query = "select * from product " + selectionModifier;
		System.out.println(query);
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			if (rs.next()) {
				Product product=new Product();
				product.prodid = rs.getString("productId");
				product.name = rs.getString("name");
				product.categoryID = rs.getString("categoryID");
//				product.price = rs.getString("price");
				product.description = rs.getString("description");
				
				
				DB.close(rs);
				DB.close(connection);
				return product;
			}
			
		} catch (SQLException e) {
			MyLog.myCatch("Product.java", 70, e);
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(connection);
		return null;
	}
	
	public static ArrayList<Product> find(String selectionModifier) {
		ArrayList<Product> selection = new ArrayList<Product>();
		ResultSet rs = null;
		String query = "select * " +
				"from product " + selectionModifier;
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			while (rs.next()) {
				Product product=new Product();
				product.prodid = rs.getString("productId");
				product.name = rs.getString("name");
				product.categoryID = rs.getString("categoryID");
//				product.price = rs.getString("price");
				product.description = rs.getString("description");
				selection.add(product);
			}
		} catch (SQLException e) {
	        MyLog.myCatch("Product.java",50, e);
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(connection);
		return selection;
	}

	
	
}
