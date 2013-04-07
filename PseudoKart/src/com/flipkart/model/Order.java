package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import com.mast.util.DB;
import com.mast.util.MyLog;
import com.opensymphony.xwork2.ActionContext;

public class Order {

	int orderId;
	String orderNo;
	String cartNo;//same as cart append number
	String email;
	String orderstatus;
	String paidstatus;
	
	
	public static Order findOne(String selectionModifier) {

		ResultSet rs = null;
		String query = "select * from orderDetails " + selectionModifier;
		System.out.print("IN findone order....");
		System.out.println(query);
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			if (rs.next()) {
				Order order=new Order();
				order.orderId=Integer.parseInt(rs.getString("orderId"));
				order.orderNo=rs.getString("orderNo");
				order.cartNo=rs.getString("cartNo");
				order.email=rs.getString("email");
				order.orderstatus=rs.getString("orderstatus");
				order.paidstatus=rs.getString("paidstatus");
				DB.close(rs);
				DB.close(connection);
				return order;
			}

		} catch (SQLException e) {
			MyLog.myCatch("Customer.java", 70, e);
			e.printStackTrace();

		}
		DB.close(rs);
		DB.close(connection);
		return null;
	}

	
	public static ArrayList<Order> findAll(String selectionModifier) {
		ArrayList<Order> selection = new ArrayList<Order>();
		ResultSet rs = null;
		String query = "select * " +
				"from orderDetails " + selectionModifier;
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			while (rs.next()) {
				Order order=new Order();
				order.orderId=rs.getInt("orderId");
				order.orderNo=rs.getString("orderNo");
				order.cartNo=rs.getString("cartNo");
				order.email=rs.getString("email");
				order.orderstatus=rs.getString("orderStatus");
				order.paidstatus=rs.getString("paidStatus");

				selection.add(order);
			}
		} catch (SQLException e) {
			MyLog.myCatch("Product.java",50, e);
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(connection);
		return selection;
	}

	public int delete(String email2) {
		// TODO Auto-generated method stub
		String deleteSQL = 
				"delete from orderDetails "+"where email= '" + email2+"'";
		System.out.println(deleteSQL);
		return DB.update(deleteSQL);
	}

	public int insert() {
		// TODO Auto-generated method stub
		String insertSQL = "insert into orderDetails"
				+ "(orderNo,cartNo,email,orderstatus,paidstatus) "
				+ "values(" + "'" + orderNo + "','" + cartNo + "', '"
				+ email + "','" + orderstatus + "' , '" + paidstatus
				+ "');";

		System.out.println(insertSQL);

		return DB.update(insertSQL);

	}

	public void setPaidstatus(String paidstatus) {
		this.paidstatus = paidstatus;
	}
	public static void createOrder(String email,String append_num){
		Order o=new Order();
		o.orderstatus="SHIPPED";

		o.paidstatus="N";
		Random generator=new Random();
		int minimum=1;
		int maximum=50;
		o.orderNo="OD"+minimum + (int)(Math.random()*maximum)+"";
		o.cartNo=append_num;
		o.email=email;
		insert(o.orderNo,o.cartNo,o.email,o.orderstatus,o.paidstatus);

	}

	public static int insert(String orderno,String cartno,String email,String ostatus,String paidstatus)

	{
		String insertSQL = "insert into orderdetails"
				+ "(orderNo,cartNo,email,orderstatus,paidstatus) " + "values('"+orderno+"','"+cartno+"','"+email+"','"+ostatus+"','"+paidstatus+"')"
				;
		return DB.update(insertSQL);

	}

	public static int updatePaidStatus()
	{
		String em=(String)ActionContext.getContext().getSession().get("email");
		String num=(String)ActionContext.getContext().getSession().get("cartAppendNo");
		String query="update orderdetails set paidstatus='Y' where email='"+em+"' and cartNo='"+num+"';";
		return DB.update(query);
	}

	public static String rtrnorderNum()
	{
		ResultSet rs=null;
		String tmp="";
		String em=(String)ActionContext.getContext().getSession().get("email");
		String query="select orderNo from orderdetails where email='"+em+"';";
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			if (rs.next()) {
				tmp=rs.getString("orderNo");  
				DB.close(rs);
				DB.close(connection);
				return tmp;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(connection);
		return null;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCartNo() {
		return cartNo;
	}
	public void setCartNo(String cartNo) {
		this.cartNo = cartNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getPaidstatus() {
		return paidstatus;
	}

}
