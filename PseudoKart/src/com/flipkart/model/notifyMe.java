package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mast.util.DB;
import com.mast.util.MyLog;

public class notifyMe {

	
	
	public static void insertNotifyMe(String sql)
	{
		String query = "insert into notifyme(email,productId) values(" + sql + ")";
		DB.update(query);
		
		
	}

	public static void deleteNotifyme(String sql) {
		
		String query = "delete from notifyme " +  sql ;
		
	System.out.println(query);
		DB.update(query);
		
	}

	 public static boolean findOne(String selectionModifier) {
		
		 boolean checkNotify = false;
         ResultSet rs = null;
         String query = "select * " +
                         "from notifyme " + selectionModifier;
         System.out.println(query);
         Connection connection = DB.getConnection();
         rs = DB.readFromDB(query, connection);
         try {
                 if(rs.next()) {
                       System.out.println("Already asked to be notified"); 
                       checkNotify = true;
                	
                         }
                
         } catch (SQLException e) {
         MyLog.myCatch("NotifyMe.java",50, e);
                 e.printStackTrace();
         }
         DB.close(rs);
         DB.close(connection);
         return checkNotify;
 }


}
