package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mast.util.DB;
import com.mast.util.MyLog;


public class bankAccount {

	int accountNo;
	String accountName;
	String cardNo;
	String cardType;
	String pin;

	String expiryDate;
	int cvvNo;
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
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
		String query = "select * from bankProxy " + selectionModifier;
		System.out.println(query);
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			if (rs.next()) {
				bankAccount account=new bankAccount();
				account.accountNo = Integer.parseInt(rs.getString("accountNo"));
				account.accountName = rs.getString("accountName");
				account.cardNo = rs.getString("cardNo");
				account.cardType = rs.getString("cardType");
				account.expiryDate = rs.getString("expiryDate");
				account.pin = rs.getString("pin");
				account.cvvNo = Integer.parseInt(rs.getString("cvvNo"));
				
				
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
	public static int updatebank(String username,String timeStamp)
	{
		Date ll=null;

		String query="update student set lastlogged='"+timeStamp+"' where rollno='"+username+"';";
		//System.out.println(query);
		return DB.update(query);


	}
}
