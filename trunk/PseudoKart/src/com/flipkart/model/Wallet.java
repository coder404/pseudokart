package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mast.util.DB;
import com.mast.util.MyLog;
import com.opensymphony.xwork2.ActionContext;

public class Wallet {

	int wallet_id;
	int customer_id;
	double balance;
	
	public static int insert(String email, double bal)
	{
		int id=Customer.getCustId(email);
		String query="insert into wallet(customer_id,balance) values("+id+","+bal+"); ";
		System.out.println(query);
		return DB.update(query);
	}
	
	public static int update(String email,double bal)
	{
		int id=Customer.getCustId(email);
		double balan=Wallet.getWalletBalance(id)+bal;
		String sql="update wallet set balance = "+balan+" where customer_id="+id+";";
		System.out.println(sql);
		return DB.update(sql);
	}
	
	public static double findCustExists() throws Exception
	{
	
		return Wallet.findBalance();
		
	}
	
	
	public static double getWalletBalance(int cust){
		double bal=0;
		ResultSet resultSet = null;
		String query = "select  balance from wallet where customer_id='"+cust+"'" ;
		System.out.println(query);
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		if(resultSet!=null){
		try {
			while (resultSet.next()) {
				bal=resultSet.getDouble("balance");
			}
		} catch (SQLException e) {
			MyLog.myCatch("Customer.java", 50, e);
			e.printStackTrace();
		}
		}
		DB.close(resultSet);
		DB.close(connection);
		return bal;

	}

	public static double findBalance() throws Exception
	{
		double bal=-1;
		String tmp="";
		ResultSet rs = null;
		String uemail=(String)ActionContext.getContext().getSession().get("email");
		Customer c=Customer.findOne("where email='"+uemail+"';");
		if(c!=null)
			{
				tmp="select * from wallet where customer_id = "+c.getId()+";";
					
				Connection connection = DB.getConnection();
				rs = DB.readFromDB(tmp, connection);
				if(rs.next())
				{
					return rs.getDouble("balance");//assuming a customer has only one wallet
				}
				return bal;
			}
		else
			return -1;
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
