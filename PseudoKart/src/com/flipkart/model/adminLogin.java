package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mast.util.DB;
import com.mast.util.MyLog;

public class adminLogin {
	
	String email;
	String passwd;
	int level;
	
	
	public static ArrayList<adminLogin> find(String selectionModifier) {
		
		ArrayList<adminLogin> selection = new ArrayList<adminLogin>();
		ResultSet resultSet = null;
		String query = "select email, password ,level " +
				"from adminlogin " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		
		try {
			while (resultSet.next()) {
				adminLogin login = new adminLogin();
				login.email=resultSet.getString("email");
				login.passwd = resultSet.getString("password");
				login.level=resultSet.getInt("level");
				selection.add(login);
			}
		} catch (SQLException e) {
            MyLog.myCatch("Login.java",50, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
		
	}
	

	
	
	public static adminLogin findOne(String selectionModifier)
	{

		ResultSet rs=null;
		String query = "select * from adminlogin " + selectionModifier;
		//System.out.println(query);
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			if (rs.next()) {
				adminLogin login=new adminLogin();
				login.email=rs.getString("email");
				login.passwd=rs.getString("password");
				login.level=rs.getInt("level");
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
	

	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

}
