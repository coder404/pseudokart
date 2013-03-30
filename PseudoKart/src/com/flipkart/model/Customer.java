package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mast.util.DB;
import com.mast.util.MyLog;


public class Customer {
	private int id;
	private String firstName="";
	private String lastName="";
	private String mobileNumber="";
	private String landlineNumber="";
	private String gender="";
	private String email="";
	private String profileName="";
	private String updatedProfileName="";
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getLandlineNumber() {
		return landlineNumber;
	}
	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getUpdatedProfileName() {
		return updatedProfileName;
	}
	public void setUpdatedProfileName(String updatedProfileName) {
		this.updatedProfileName = updatedProfileName;
	}
	
	
	public static ArrayList<Customer> find(String selectionModifier) {
		ArrayList<Customer> selection = new ArrayList<Customer>();
		ResultSet resultSet = null;
		String query = "select * " +
				"from customer " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				Customer customer=new Customer();
				customer.id=resultSet.getInt("id");
				customer.firstName=resultSet.getString("firstName");
				customer.lastName=resultSet.getString("lastName");
				customer.mobileNumber=resultSet.getString("mobileNumber");
				customer.landlineNumber=resultSet.getString("landlineNumber");
				customer.gender=resultSet.getString("gender");
				customer.profileName=resultSet.getString("profileName");
				customer.updatedProfileName=resultSet.getString("updatedProfileName");
				selection.add(customer);
			}
		} catch (SQLException e) {
	        MyLog.myCatch("Customer.java",50, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}



		public static Customer findOne(String selectionModifier)
		{

			ResultSet rs=null;
			String query = "select * from customer " + selectionModifier;
			//System.out.println(query);
			Connection connection = DB.getConnection();
			rs = DB.readFromDB(query, connection);
			try {
				if (rs.next()) {
					Customer customer=new Customer();
					customer.id=Integer.parseInt(rs.getString("id"));
					customer.firstName=rs.getString("firstName");
					customer.lastName=rs.getString("lastName");
					customer.mobileNumber=rs.getString("mobileNumber");
					customer.landlineNumber=rs.getString("landlineNumber");
					customer.gender=rs.getString("gender");
					customer.profileName=rs.getString("profileName");
					customer.updatedProfileName=rs.getString("updatedProfileName");
					DB.close(rs);
					DB.close(connection);
					return customer;
				}
				
			} catch (SQLException e) {
				MyLog.myCatch("Customer.java", 70, e);
				e.printStackTrace();
			}
			DB.close(rs);
			DB.close(connection);
			return null;
		}




	
	
}
