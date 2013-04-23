package com.flipkart.DAO;

import java.sql.*;

import com.flipkart.model.Product;
import com.flipkart.model.Stock;
import com.mast.util.DB;
import com.mast.util.MyLog;
import com.mast.util.RuntimeSettings;

public class AddProducts {
	
	
	public static int addProducts(String category,String name,String price,String Description) {
		
		ResultSet rs = null;
		String productId;
		int count=0;
		String query = "select count(*) from product";
		System.out.println(query);
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			while (rs.next()) {

				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			MyLog.myCatch("Product.java", 50, e);
			e.printStackTrace();
		}
		count+=1;
		productId="prod"+count;		
		DB.close(rs);
		DB.close(connection);
		
		
		String insertSQL=null;
			
		System.out.println("in insert products ");
		insertSQL = "insert into product"
				+ "(productId,name,categoryID,price,description,imageUrl) "
				+ "values('" + productId + "','" + name + "', '"
				+ category + "','" + price + "' , '" + Description +"','./images/default.png' );";
		
		System.out.println(insertSQL);
		int a= DB.update(insertSQL);
		if(a!=0)
		{
		String modifier="'"+productId+"',5";
		System.out.println(modifier);
		Stock.insertStock(modifier);
		}

		return a;
	}
	
	

}
