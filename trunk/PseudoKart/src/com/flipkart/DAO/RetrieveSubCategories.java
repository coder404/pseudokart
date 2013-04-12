package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mast.util.DB;
import com.mast.util.RuntimeSettings;

public class RetrieveSubCategories {
	
	
	public static ResultSet getSubCategories() {
		ResultSet res;

		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/flipkart";
			con = DriverManager.getConnection(url, RuntimeSettings.dbUserID,
					RuntimeSettings.dbPassword);

			System.out.println("In retrieve sub categories ");
			PreparedStatement stmt = con
					.prepareStatement("select name from category where parentCatID NOT IN ('NA');");
			System.out.println(stmt);
			res = stmt.executeQuery();

		} catch (Exception e) {
			res = null;
			
			e.printStackTrace();
		}
		
		return res;

}
}
