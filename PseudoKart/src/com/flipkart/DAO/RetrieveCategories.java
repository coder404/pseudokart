package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mast.util.RuntimeSettings;

public class RetrieveCategories {

	
	
	public static ResultSet getCategories() {
		ResultSet res;

		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/flipkart";
			con = DriverManager.getConnection(url, RuntimeSettings.dbUserID,
					RuntimeSettings.dbPassword);

			System.out.println("In retrieve categories ");
			PreparedStatement stmt = con
					.prepareStatement("select name from category where parentCatID='NA';");
			System.out.println(stmt);
			res = stmt.executeQuery();

		} catch (Exception e) {
			res = null;

			e.printStackTrace();
		}

		return res;
	}
	public static ResultSet getSubCategories(String name) {
		ResultSet res;
		String categoryID=null;

		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/flipkart";
			con = DriverManager.getConnection(url, RuntimeSettings.dbUserID,
					RuntimeSettings.dbPassword);
			PreparedStatement stmt = con
					.prepareStatement("select categoryID from category where name='"+name+"';");
			System.out.println(stmt);
			res = stmt.executeQuery();
			while(res.next())
			{
				categoryID = res.getString("categoryID");
				
			}

			System.out.println("In retrieve categories ");
			PreparedStatement stmt1 = con
					.prepareStatement("select name from category where parentCatID='"+categoryID+"';");
			System.out.println(stmt1);
			res = stmt1.executeQuery();

		} catch (Exception e) {
			res = null;

			e.printStackTrace();
		}

		return res;
	}
	public static ResultSet getProducts(String subcategory) {
		ResultSet res;
		String categoryID=null;

		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/flipkart";
			con = DriverManager.getConnection(url, RuntimeSettings.dbUserID,
					RuntimeSettings.dbPassword);
			PreparedStatement stmt = con
					.prepareStatement("select categoryID from category where name='"+subcategory+"';");
			System.out.println(stmt);
			res = stmt.executeQuery();
			while(res.next())
			{
				categoryID = res.getString("categoryID");
				
			}

			System.out.println("In retrieve categories ");
			PreparedStatement stmt1 = con
					.prepareStatement("select name from  product where categoryID='"+categoryID+"';");
			System.out.println(stmt1);
			res = stmt1.executeQuery();

		} catch (Exception e) {
			res = null;

			e.printStackTrace();
		}

		return res;
	}
	
}
