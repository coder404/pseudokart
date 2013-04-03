package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public int insert() {
		String insertSQL = "insert into login"
				+ "(email,password) " + "values('" + email
				+ "', '" + password + "');";
		return DB.update(insertSQL);
	}
	
	public static int update_pwd(String emailAddr,String pwd)
	{
		String sql = "update login set password = '" + pwd + " ' where email='" + emailAddr +"'";
		System.out.println(sql);
		return DB.update(sql);
	}
	
	public static ArrayList<Login> find(String selectionModifier) {
		
		ArrayList<Login> selection = new ArrayList<Login>();
		ResultSet resultSet = null;
		String query = "select email, password " +
				"from login " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		
		try {
			while (resultSet.next()) {
				Login login = new Login();
				login.email=resultSet.getString("email");
				login.password = resultSet.getString("password");
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

