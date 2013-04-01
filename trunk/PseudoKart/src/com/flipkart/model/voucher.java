package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mast.util.DB;
import com.mast.util.MyLog;

public class voucher {

	
	int voucher_id;
	String voucher_number;
	String voucher_pin;
	double balance;
	
	
	public static int update(String voucherno,double bal) {

		int no = Integer.parseInt(voucherno);
		String updateSQL = 
				"update voucher "
						+ "set balance=" + bal +   
						" where voucher_number = " +no+";" ;
		System.out.println("query = " + updateSQL);
		return DB.update(updateSQL);
	}


	
	
	
	public static ArrayList<voucher> findAll()
	{
		ArrayList<voucher> list=new ArrayList<voucher>();
		ResultSet resultSet = null;
		String query = "select * from voucher";
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				voucher v=new voucher();
				v.voucher_number=resultSet.getInt("voucher_number")+"";
				v.voucher_pin=resultSet.getInt("voucher_pin")+"";
				v.balance=resultSet.getDouble("balance");
			   list.add(v);
			}
		} catch (SQLException e) {
	        MyLog.myCatch("Customer.java",50, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return list;
	}
	
	public int getVoucher_id() {
		return voucher_id;
	}
	public void setVoucher_id(int voucher_id) {
		this.voucher_id = voucher_id;
	}
	
	public String getVoucher_number() {
		return voucher_number;
	}

	public void setVoucher_number(String voucher_number) {
		this.voucher_number = voucher_number;
	}

	public String getVoucher_pin() {
		return voucher_pin;
	}

	public void setVoucher_pin(String voucher_pin) {
		this.voucher_pin = voucher_pin;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
