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

public class ProductSelection {
	public static ArrayList<Product> getProductnames(String categoryname) {
		
		String categoryID=null;
		ArrayList<Product> products_selecion= new ArrayList<Product>();
	
		String selectionModifier="where name='"+categoryname+"';";
		Category c=Category.findCategory(selectionModifier);
		categoryID=c.getCategoryID();
		String selectionModifier1="where categoryID IN (select categoryID from category where parentCatID='"+categoryID+"');";
			
		products_selecion=Product.findAll(selectionModifier1);
		
			
	
		return products_selecion;
	}
	public static String getCategoryID(String categoryname) {
		ResultSet res;
		String categoryID=null;
		
		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/flipkart";
			con = DriverManager.getConnection(url, RuntimeSettings.dbUserID,
					RuntimeSettings.dbPassword);
			PreparedStatement stmt = con
					.prepareStatement("select categoryID from category where name='"+categoryname+"';");
			System.out.println(stmt);
			res = stmt.executeQuery();
			while(res.next())
			{
				categoryID = res.getString("categoryID");
				
			}

			System.out.println("In retrieve categories ");
			//PreparedStatement stmt1 = con
				//	.prepareStatement("select * from product where categoryID IN (select categoryID from category where parentCatID='"+categoryID+"');");
			

		} catch (Exception e) {
			res = null;

			e.printStackTrace();
			
		}
		
		return categoryID;
	}
	public static ArrayList<Product> getTwoProducts(String categoryname) {
		ResultSet res;
		String categoryID=null;
		ArrayList<Product> products= new ArrayList<Product>();
		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/flipkart";
			con = DriverManager.getConnection(url, RuntimeSettings.dbUserID,
					RuntimeSettings.dbPassword);
			PreparedStatement stmt = con
					.prepareStatement("select categoryID from category where name='"+categoryname+"';");
			System.out.println(stmt);
			res = stmt.executeQuery();
			while(res.next())
			{
				categoryID = res.getString("categoryID");
				
			}

			System.out.println("In retrieve categories ");
			
			String selectionModifier="where categoryID IN (select categoryID from category where parentCatID='"+categoryID+"') limit 2;";
			products=Product.findAll(selectionModifier);
			

		} catch (Exception e) {
			res = null;
			
			e.printStackTrace();
		}
	
		return products;
	}
	public static ArrayList<Product> getAllProducts(String categoryname) {
		ResultSet res;
		String categoryID=null;
		ArrayList<Product> products= new ArrayList<Product>();
		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/flipkart";
			con = DriverManager.getConnection(url, RuntimeSettings.dbUserID,
					RuntimeSettings.dbPassword);
			PreparedStatement stmt = con
					.prepareStatement("select categoryID from category where name='"+categoryname+"';");
			System.out.println(stmt);
			res = stmt.executeQuery();
			while(res.next())
			{
				categoryID = res.getString("categoryID");
				
			}

			System.out.println("In retrieve categories ");
			
			String selectionModifier="where categoryID IN (select categoryID from category where parentCatID='"+categoryID+"');";
			products=Product.findAll(selectionModifier);
			

		} catch (Exception e) {
			res = null;
			
			e.printStackTrace();
		}
	
		return products;
	}
	
}
