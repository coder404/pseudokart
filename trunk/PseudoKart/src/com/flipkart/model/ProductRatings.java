package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mast.util.DB;
import com.mast.util.MyLog;

public class ProductRatings {
	private String prodId;
	private int rating;
	private int numberOfCustomers;
	String productName;
	
	public int update(String prodId, int i, int j) {
		// TODO Auto-generated method stub
		String mod="where productId='"+prodId+"'";
		String updateSQL = "update productratings " + "set rating= " + (i+rating)
				+ "," + "numberOfCustomers= "+(j+1)+ " "+ mod +";";
		System.out.println("query = " + updateSQL);
		return DB.update(updateSQL);

	}
	
	public static ProductRatings findOne(String selectionModifier) {

		ResultSet rs = null;
		String query = "select * from productRatings " + selectionModifier;
		// System.out.println(query);
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			if (rs.next()) {
				ProductRatings pr=new ProductRatings();
				pr.prodId=rs.getString("productId");
				//pr.prodId="prod1";//change it
				
				pr.rating=Integer.parseInt(rs.getString("rating"));
			    pr.numberOfCustomers=Integer.parseInt(rs.getString("numberOfCustomers"));
				DB.close(rs);
				DB.close(connection);
				return pr;
			}

		} catch (SQLException e) {
			MyLog.myCatch("Customer.java", 70, e);
			e.printStackTrace();

		}
		DB.close(rs);
		DB.close(connection);
		return null;
	}

	
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public int getRating() {
		return rating;
	}
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	public void setNumberOfCustomers(int numberOfCustomers) {
		this.numberOfCustomers = numberOfCustomers;
	}

	public int insert(String prodId2, int rating2) {
		// TODO Auto-generated method stub
		String insertSQL = "insert into productRatings"
				+ "(productId,rating,numberOfCustomers) "
				+ "values(" + "'" + prodId2 + "'," + rating2 + ", "
				+ 1 + ");";

		System.out.println(insertSQL);

		return DB.update(insertSQL);
		
		
	}
	
}