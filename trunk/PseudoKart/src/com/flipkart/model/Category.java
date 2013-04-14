package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mast.util.DB;
import com.mast.util.MyLog;

public class Category {

	private String name;
	private String categoryID;
	private String parentCatID;
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
	public String getParentCatID() {
		return parentCatID;
	}
	public void setParentCatID(String parentCatID) {
		this.parentCatID = parentCatID;
	}
	
	public static Category findCategory(String selectionModifier)
	{

		ResultSet rs=null;
		String query = "select * from Category "+ selectionModifier;
		System.out.println(query);
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			if (rs.next()) {
			    Category category=new Category();
				category.categoryID=rs.getString("categoryID");
				category.name=rs.getString("name");
				category.parentCatID=rs.getString("parentCatID");
				DB.close(rs);
				DB.close(connection);
				return category;
			}
			
		} catch (SQLException e) {
			MyLog.myCatch("Category.java", 70, e);
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(connection);
		return null;
	}
	public static ArrayList<Category> findAll(String selectionModifier) {
		ArrayList<Category> selection = new ArrayList<Category>();
		ResultSet rs = null;
		String query = "select * from Category "+ selectionModifier;
		System.out.println(query);
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			while (rs.next()) {
				 Category category=new Category();
					category.categoryID=rs.getString("categoryID");
					category.name=rs.getString("name");
					category.parentCatID=rs.getString("parentCatID");
					
				selection.add(category);
			}
		} catch (SQLException e) {
	        MyLog.myCatch("Category.java",50, e);
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(connection);
		return selection;
	}
	
}
