package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mast.util.DB;
import com.mast.util.MyLog;

public class Cart {
	public String productId;
	public String ItemDesc;
	public String DeliveryTime;
	public int quantity;
	private String cartAppendNo;
	private String email;
	public double subtotal;
	//public static double amount=0;
	//public  ArrayList<Cart> CartList=new ArrayList<Cart>();
	public static String getCurrentAppendNo(String email)
	{
		String result="";
		ResultSet resultSet = null;
		String query= "select CartAppendNo from customer where email ='"+email+"'";
				
		System.out.println("********"+query);
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while(resultSet.next())
			result=resultSet.getString("CartAppendNo");
			System.out.println(result);
			
		} catch (SQLException e) {
            MyLog.myCatch("Course.java",50, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
			
		
		
		return result;
	}
	
	public static boolean checkCurrentCart(String email,String appendNo)
	{
		String result="";
		ResultSet resultSet = null;
		String query= "select * from cart where email ='"+email+"' and CartAppendNo='"+appendNo+"'";
				
		System.out.println("********"+query);
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while(resultSet.next())
			result=resultSet.getString("CartAppendNo");
			//System.out.println(result);
			
		} catch (SQLException e) {
            MyLog.myCatch("Course.java",50, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		if(result=="")
			return false;
		else 
			return true;
			
	}
	public static int insertIntoCart(String email,String productId,String appendNo,int quantity)
	
	{
		String insertSQL = "insert into cart"
				+ "(email,productId,cartAppendNo,quantity) " + "values('"+email+"','"+productId+"','"+appendNo+"','"+quantity+"')"
			;
		return DB.update(insertSQL);

	}
	
	public static ArrayList<Cart> getCart(String email,String appendNo)
	{
		ArrayList<Cart> CartList=new ArrayList<Cart>();
		String result="";
		ResultSet resultSet = null;
		String query= "select * from cart where email ='"+email+"' and CartAppendNo='"+appendNo+"'";
				
		System.out.println("********"+query);
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while(resultSet.next())
			{
				Cart obj=new Cart();
				obj.DeliveryTime="2-3 days";
				obj.productId=resultSet.getString("productId");
				obj.ItemDesc=Cart.getItemDescription(resultSet.getString("productId"));
				System.out.println(obj.ItemDesc);
				obj.subtotal=Cart.getsubTotal(resultSet.getString("productId"));
				System.out.println(obj.subtotal);
				obj.quantity=resultSet.getInt("quantity");
				//amount+=obj.subtotal;
				CartList.add(obj);
				
				
			}
			//System.out.println(result);
			
		} catch (SQLException e) {
            MyLog.myCatch("Course.java",50, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		
		return CartList;
	}
	
	public static String getItemDescription(String productId)
	{
		String result="";
		ResultSet resultSet = null;
		String query= "select description from product where productId='"+productId+"'";
				
		System.out.println("********"+query);
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while(resultSet.next())
			result=resultSet.getString("description");
			//System.out.println(result);
			
		} catch (SQLException e) {
            MyLog.myCatch("Course.java",50, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return result;
		
	}
	
	public static double getsubTotal(String productId)
	{
		double result=0;
		ResultSet resultSet = null;
		String query= "select price from product where productId='"+productId+"'";
				
		System.out.println("********"+query);
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while(resultSet.next())
			result=(double)resultSet.getDouble("price");
			//System.out.println(result);
			
		} catch (SQLException e) {
            MyLog.myCatch("Course.java",50, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return result;
		
	}

	public static double getTotalAmount(ArrayList<Cart> CartItems)
	{
		double amt=0;
		System.out.println("^^^^^^^"+CartItems.size());
		for(int i=0;i<CartItems.size();i++){
			
			amt+=CartItems.get(i).subtotal;
			System.out.println("******"+amt);}
		System.out.println(amt);
		return amt;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCartAppendNo() {
		return cartAppendNo;
	}

	public void setCartAppendNo(String cartAppendNo) {
		this.cartAppendNo = cartAppendNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
