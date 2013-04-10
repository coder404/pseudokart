package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mast.util.DB;
import com.mast.util.MyLog;
import com.opensymphony.xwork2.ActionContext;

public class Stock {

	int stockID;
	String stockProductID;
	int quantity;
	public int getStockID() {
		return stockID;
	}
	public void setStockID(int stockID) {
		this.stockID = stockID;
	}
	public String getStockProductID() {
		return stockProductID;
	}
	public void setStockProductID(String stockProductID) {
		this.stockProductID = stockProductID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	 public static Stock findOne(String selectionModifier) {
		 Stock s= new Stock();
         ResultSet rs = null;
         String query = "select * " +
                         "from stock " + selectionModifier;
         System.out.println(query);
         Connection connection = DB.getConnection();
         rs = DB.readFromDB(query, connection);
         try {
                 if(rs.next()) {
                        
                         s.stockID=rs.getInt("stockID");
                         s.stockProductID=rs.getString("stockProductID");
                         s.quantity=rs.getInt("quantity");
                         return s;
                         }
                
         } catch (SQLException e) {
         MyLog.myCatch("Product.java",50, e);
                 e.printStackTrace();
         }
         DB.close(rs);
         DB.close(connection);
         return null;
 }

	 public static int updatequantity(String query)
		{
			return DB.update(query);
		}
		
	 
public static void reduceQunatity(ArrayList<Cart> items)
{
	
	for(int i=0;i<items.size();i++)
	{
		Stock s = Stock.findOne("where stockProductId='"+items.get(i).productId+"';");
		s.quantity=s.quantity-1;
		String query="update stock set quantity="+s.quantity+" where stockProductId='"+s.stockProductID+"';";
		System.out.println(query);
		Stock.updatequantity(query);
	}
	
}

@SuppressWarnings("null")
public static ArrayList<String> findAllNotifyMe(String sql)
{

	ArrayList<String> email_list = new ArrayList<String>();

    ResultSet rs = null;
    String query = "select * " +
                    "from notifyme " + sql;
    System.out.println(query);
    Connection connection = DB.getConnection();
    rs = DB.readFromDB(query, connection);
    try {
    	
    	
            while(rs.next()) {
                   
            	email_list.add(rs.getString("email"));
            	System.out.println(rs.getString("email"));
                    
                    }
           
    
           
    } catch (SQLException e) {
    MyLog.myCatch("Product.java",50, e);
            e.printStackTrace();
    }
    DB.close(rs);
    DB.close(connection);
    return email_list;
	
}

public static void insertNotifyMe(String sql)
{
	String query = "insert into notifyme(email,productId) values(" + sql + ")";
	DB.update(query);
	
	
}

public static void updateStock(String sql){
	
	String query = "update stock set quantity=quantity+" + sql ;
	System.out.println(query);
	Stock.updatequantity(query);
	
	
}
	

public static void insertStock(String sql){
	
	String query = "insert into stock(stockProductId,quantity) values (" +  sql + ")" ;
	System.out.println(query);
	Stock.updatequantity(query);
	
	
}
public static void deleteNotifyme(String sql) {
	
	String query = "delete from notifyme " +  sql ;
	
System.out.println(query);
	DB.update(query);
	
}


}
