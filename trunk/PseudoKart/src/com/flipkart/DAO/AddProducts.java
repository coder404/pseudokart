package com.flipkart.DAO;

import java.sql.*;

import com.flipkart.model.Product;
import com.mast.util.DB;
import com.mast.util.MyLog;
import com.mast.util.RuntimeSettings;

public class AddProducts {
	
	
	public static int addProducts(String category, String ProductID,String name,String price,String Description) {
		
		String categoryID;
		String insertSQL=null;
		ResultSet rs=null;
		String query = "select categoryID from category where name='" + category+"'";
		System.out.println(query);
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		
	
			try {
				if (rs.next()) {
					
					categoryID=rs.getString("categoryID");
			
		
		System.out.println("in insert products ");
		insertSQL = "insert into product"
				+ "(productId,name,categoryID,price,description) "
				+ "values(" + "'" + ProductID + "','" + name + "', '"
				+ categoryID + "','" + price + "' , '" + Description +"' );";
		
		System.out.println(insertSQL);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		return DB.update(insertSQL);
	}
	
	

}
