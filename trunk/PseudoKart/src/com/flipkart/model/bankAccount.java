package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mast.util.DB;
import com.mast.util.MyLog;


public class bankAccount {

	private String accountNo;
	private String accountName;
	private String cardNo;
	private String cardType;
	private String pin;
	double balance;

	String expiryDate;
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	int cvvNo;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getCvvNo() {
		return cvvNo;
	}
	public void setCvvNo(int cvvNo) {
		this.cvvNo = cvvNo;
	}
	
	public static bankAccount findAccount(String selectionModifier)
	{

		ResultSet rs=null;
		System.out.println("selection mod :" + selectionModifier);
		String query = "select * from bankProxy " + selectionModifier;
		System.out.println(query);
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			if (rs.next()) {
				bankAccount account=new bankAccount();
				account.accountNo = rs.getString("accountNo");
				account.accountName = rs.getString("accountName");
				account.cardNo = rs.getString("cardNo");
				account.cardType = rs.getString("cardType");
				account.expiryDate = rs.getString("expiryDate");
				account.pin = rs.getString("pin");
				account.cvvNo = Integer.parseInt(rs.getString("cvvNo"));
				account.balance = Double.parseDouble(rs.getString("balance"));
				
				DB.close(rs);
				DB.close(connection);
				return account;
			}
			
		} catch (SQLException e) {
			MyLog.myCatch("bankAccount.java", 70, e);
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(connection);
		return null;
	}
	public static int updateBank(String sql)
	{
		
		String query="update bankProxy set balance="+ sql;
		//System.out.println(query);
		return DB.update(query);


	}
	
	public static boolean checkBalance(double amt,double balance) {
		// TODO Auto-generated method stub
		
		if(amt < balance)
			return true;
		
		
		return false;
	}
}