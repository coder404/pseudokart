package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mast.util.DB;
import com.mast.util.MyLog;

public class Login {
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static Login findOne(String selectionModifier)
	{

		ResultSet rs=null;
		String query = "select * from login " + selectionModifier;
		//System.out.println(query);
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			if (rs.next()) {
				Login login=new Login();
				login.email=rs.getString("email");
				login.password=rs.getString("password");
				DB.close(rs);
				DB.close(connection);
				return login;
			}
			
		} catch (SQLException e) {
			MyLog.myCatch("Customer.java", 70, e);
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(connection);
		return null;
	}
	
	public int update() {
		// TODO Auto-generated method stub
		String updateSQL = 
				"update login "
						+ "set password= '" + password +"'" 
						+" where email='"+email +"'";
		//System.out.println("query = " + updateSQL);
		return DB.update(updateSQL);
	
		
	}

}
