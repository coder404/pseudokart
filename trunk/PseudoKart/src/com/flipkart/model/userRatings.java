package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mast.util.DB;
import com.mast.util.MyLog;

public class userRatings {
	private int userRatings_id;
	private String email;
	private String productId;
	private int ratings;
	
	
	public static userRatings findOne(String selectionModifier) {

		ResultSet rs = null;
		String query = "select * from userRatings " + selectionModifier;
		// System.out.println(query);
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			if (rs.next()) {
				userRatings user=new userRatings();
				user.productId=rs.getString("productId");
				//pr.prodId="prod1";//change it
				
				user.ratings=Integer.parseInt(rs.getString("ratings"));
			    user.email=rs.getString("email");
				DB.close(rs);
				DB.close(connection);
				return user;
			}

		} catch (SQLException e) {
			MyLog.myCatch("Customer.java", 70, e);
			e.printStackTrace();

		}
		DB.close(rs);
		DB.close(connection);
		return null;
	}

	
	
	
	public int getUserRatings_id() {
		return userRatings_id;
	}
	public void setUserRatings_id(int userRatings_id) {
		this.userRatings_id = userRatings_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}




	public int insert(String prodId, int rating, String email2) {
		// TODO Auto-generated method stub
		String insertSQL = "insert into userRatings"
				+ "(email,productId,ratings) "
				+ "values(" + "'" + email + "','" + prodId + "', "
				+ rating + ");";

		System.out.println(insertSQL);

		return DB.update(insertSQL);
		

	}
	
	
}
