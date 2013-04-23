package com.flipkart.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mast.util.DB;
import com.mast.util.MyLog;
import com.mast.util.SendEmail;
import com.opensymphony.xwork2.ActionContext;

public class voucher {

	
	int voucher_id;
	String voucher_number;
	String voucher_pin;
	double balance;
	Date purchase_Date;
	String purchaser_Email;
	
	//String uemail=(String)ActionContext.getContext().getSession().get("email");
	
	public String getPurchaser_Email() {
		return purchaser_Email;
	}

	public void setPurchaser_Email(String purchaser_Email) {
		this.purchaser_Email = purchaser_Email;
	}

	public Date getPurchase_Date() {
		return purchase_Date;
	}

	public void setPurchase_Date(Date purchase_Date) {
		this.purchase_Date = purchase_Date;
	}

	public static int update(String voucherno,double bal) {

		int num = Integer.parseInt(voucherno);
		String updateSQL = 
				"update voucher "
						+ "set balance=" + bal +   
						" where voucher_number = " +num+";" ;
		System.out.println("query = " + updateSQL);
		return DB.update(updateSQL);
	}
	
	public static int insert(Double bal,String uemail) {
		
		System.out.println("Inside insert method of Voucher");
		System.out.println(bal);
		BigDecimal balance = new BigDecimal(bal);
		
		System.out.println("balance="+balance);
		
		int num=0;
		int pin=0;
		
		int Min=100000000;
		int Max=999999999;
		
		num = Min + (int)(Math.random() * (Max - Min));
		pin = 1000 + (int)(Math.random() * 9999);
		
		System.out.println("num="+num);
		System.out.println("pin="+pin);
		
		ActionContext.getContext().getSession().put("vouchernum",num);
		ActionContext.getContext().getSession().put("voucherpin",pin);
		
		String insertSQL = 
				"insert into voucher values"
						+ "(NULL,"+num+","+pin+","+balance+","+"curdate()"+",'"+uemail+"')";
		
		System.out.println("query = " + insertSQL);
		
		System.out.println("Sending Email to receipient: " + (String)ActionContext.getContext().getSession().get("receiverEmail"));
		SendEmail send = new SendEmail();
		String mailID = (String)ActionContext.getContext().getSession().get("receiverEmail");
		System.out.println("mailid: " + mailID);
		send.Mail(mailID, 2);
		
		return DB.update(insertSQL);
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
				v.purchase_Date=resultSet.getDate("purchase_Date");
				v.purchaser_Email=resultSet.getString("purchaser_Email");
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