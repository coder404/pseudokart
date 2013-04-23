package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mast.util.DB;
import com.mast.util.MyLog;
import com.mysql.jdbc.Statement;

public class Cart {
	private int cartId;
	public String productId;
	public String ItemDesc;
	public String DeliveryTime;
	public double price;
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
				obj.price=Cart.getPrice(resultSet.getString("productId"));
				obj.quantity=resultSet.getInt("quantity");
				obj.subtotal=(obj.quantity)*(Cart.getPrice(resultSet.getString("productId")));
				System.out.println(obj.subtotal);
				
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
	
	/*public static double getsubTotal(String productId)
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
*/
	public static double getPrice(String productId)
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
	
	public static ArrayList<Cart> findAll(String selectionModifier) {
		ArrayList<Cart> selection = new ArrayList<Cart>();
		ResultSet rs = null;
		String query = "select * " +
				"from cart " + selectionModifier;
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			while (rs.next()) {
				Cart cart=new Cart();
				cart.cartId=rs.getInt("cartId");
				cart.email=rs.getString("email");
				cart.cartAppendNo=rs.getString("cartAppendNo");
				cart.productId=rs.getString("productId");
				cart.quantity=rs.getInt("quantity");
				selection.add(cart);
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
			    "delete from cart "+"where email= '" + email2+"'";
		System.out.println(deleteSQL);
		return DB.update(deleteSQL);
	}
	
	
	public int insert() {
		// TODO Auto-generated method stub
		String insertSQL = "insert into cart"
				+ "(email,cartAppendNo,productId,quantity) "
				+ "values(" + "'" + email + "','" + cartAppendNo + "', '"
				+ productId + "','" + quantity + "');";

		System.out.println(insertSQL);

		return DB.update(insertSQL);

	}
	
	public static String checkProduct(String prodId,String mailid,String appendNo)
	{
		int count=0;
		ResultSet resultSet = null;
		 String query= "select count(*) from cart where email='"+mailid+"'and productId='"+prodId+"'and cartAppendNo='"+appendNo+"'";
				
		System.out.println("********"+query);
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while(resultSet.next())
			count=resultSet.getInt("count(*)");
			//System.out.println(result);
			
		} catch (SQLException e) {
            MyLog.myCatch("Product.java",50, e);
			e.printStackTrace();
		}
		
		DB.close(resultSet);
		DB.close(connection);
	
		if(count!=0)
			return "found";
		else
			return "notfound";
		
	}
	
	public static void updateQuantity(String email,String appendNo,String product_id,int qty ){
		//ResultSet rs;
		String query = "update cart set quantity='"+qty+"'"+" where email='"+email+"' and cartAppendNo='"+appendNo+"' and productId='"+product_id+"'";
		System.out.println("********"+query);
		Connection con = DB.getConnection();
		//rs=DB.readFromDB(query, connection);
		try{
		Statement stmt= (Statement) con.createStatement();
		stmt.executeUpdate(query);
		}
		catch(Exception e){
			System.out.println("In Cart.java");
		}
		//DB.close(rs);
		DB.close(con);
		
		
	}
	
	/*
	 * This method removes the cart item
	 * */
	
	public static void removeItem(String email,String appendNo,String product_id ){
		//ResultSet rs;
		String query = "delete from cart  where email='"+email+"' and cartAppendNo='"+appendNo+"' and productId='"+product_id+"'";
		System.out.println("********"+query);
		Statement stmt=null;
		Connection con = DB.getConnection();
		//rs=DB.readFromDB(query, connection);
		try{
		stmt= (Statement) con.createStatement();
		stmt.executeUpdate(query);
		}
		catch(Exception e){
			System.out.println("In Cart.java");
		}
		//DB.close(rs);
		try {
			stmt.close();
			DB.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
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

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getItemDesc() {
		return ItemDesc;
	}

	public void setItemDesc(String itemDesc) {
		ItemDesc = itemDesc;
	}

	public String getDeliveryTime() {
		return DeliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		DeliveryTime = deliveryTime;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
