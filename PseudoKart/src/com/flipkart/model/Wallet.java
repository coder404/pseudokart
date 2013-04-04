package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mast.util.DB;
import com.opensymphony.xwork2.ActionContext;

public class Wallet {

	int wallet_id;
	int customer_id;
	double balance;
	
	
	public static double findBalance() throws Exception
	{
		double bal=0.0;
		String tmp="";
		ResultSet rs = null;
		String uemail=(String)ActionContext.getContext().getSession().get("email");
		Customer c=Customer.findOne("where email='"+uemail+"';");
		if(c!=null)
			tmp="select * from wallet where customer_id = "+c.getId()+";";
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(tmp, connection);
		if(rs.next())
		{
			return rs.getDouble("balance");//assuming a customer has only one wallet
		}
		return bal;
	}
	
	public static void updateBalance(double amt)
	{
		String tmp="";
		ResultSet rs = null;
		String uemail=(String)ActionContext.getContext().getSession().get("email");
		Customer c=Customer.findOne("where email='"+uemail+"';");
		if(c!=null)
			tmp="update wallet set balance="+amt+" where customer_id = "+c.getId()+";";
		DB.update(tmp);
	}
	
	
	
	public int getWallet_id() {
		return wallet_id;
	}
	public void setWallet_id(int wallet_id) {
		this.wallet_id = wallet_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
