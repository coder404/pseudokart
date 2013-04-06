package com.flipkart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mast.util.DB;
import com.mast.util.MyLog;
import com.opensymphony.xwork2.ActionContext;

public class Customer {
	private int id;

	private String firstName = "";
	private String lastName = "";
	private String mobileNumber = "";
	private String landlineNumber = "";
	private String gender = "";
	private String email = "";
	private String profileName = "";
	private String updatedProfileName = "";
	private String updated_email="";
	String cartAppendNo = "1";

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

	public String getCartAppendNo() {
		return cartAppendNo;
	}

	public void setCartAppendNo(String cartAppendNo) {
		this.cartAppendNo = cartAppendNo;
	}

	public String getUpdatedProfileName() {
		return updatedProfileName;
	}

	public void setUpdatedProfileName(String updatedProfileName) {
		this.updatedProfileName = updatedProfileName;
	}

	public String getUpdated_email() {
		return updated_email;
	}

	public void setUpdated_email(String updated_email) {
		this.updated_email = updated_email;
	}

	public static ArrayList<Customer> find(String selectionModifier) {
		ArrayList<Customer> selection = new ArrayList<Customer>();
		ResultSet resultSet = null;
		String query = "select * " + "from customer " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.id = resultSet.getInt("id");
				customer.firstName = resultSet.getString("firstName");
				customer.lastName = resultSet.getString("lastName");
				customer.mobileNumber = resultSet.getString("mobileNumber");
				customer.landlineNumber = resultSet.getString("landlineNumber");
				customer.gender = resultSet.getString("gender");
				customer.profileName = resultSet.getString("profileName");
				customer.updatedProfileName = resultSet
						.getString("updatedProfileName");
				selection.add(customer);
			}
		} catch (SQLException e) {
			MyLog.myCatch("Customer.java", 50, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public static int cartAppendNoInc() {
		String em = (String) ActionContext.getContext().getSession()
				.get("email");
		Customer c = Customer.findOne("where email='" + em + "'");
		if (c != null) {
			int tmp_no = Integer.parseInt((String) ActionContext.getContext()
					.getSession().get("cartAppendNo"));
			tmp_no = tmp_no + 1;
			String appnd_no = tmp_no + "";

			String query = "update customer set CartAppendNo='" + appnd_no
					+ "' where email='" + em + "';";
			System.out.println("update query for appendno=" + query);
			return DB.update(query);
		}

		return 0;
	}

	public static Customer findOne(String selectionModifier) {

		ResultSet rs = null;
		String query = "select * from customer " + selectionModifier;
		// System.out.println(query);
		Connection connection = DB.getConnection();
		rs = DB.readFromDB(query, connection);
		try {
			if (rs.next()) {
				Customer customer = new Customer();
				customer.id = Integer.parseInt(rs.getString("id"));
				customer.firstName = rs.getString("firstName");
				customer.lastName = rs.getString("lastName");
				customer.mobileNumber = rs.getString("mobileNumber");
				customer.landlineNumber = rs.getString("landlineNumber");
				customer.gender = rs.getString("gender");
				customer.profileName = rs.getString("profileName");
				customer.updatedProfileName = rs.getString("updatedProfileName");
				customer.updated_email=rs.getString("updated_email");
				customer.cartAppendNo = rs.getString("CartAppendNo");
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

	public int updatePersonalInformation() {
		// TODO Auto-generated method stub
		String updateSQL = "update customer " + "set firstName= '" + firstName
				+ "'," + "lastName= '" + lastName + "'," + "mobileNumber= '"
				+ mobileNumber + "'," + "landlineNumber= '" + landlineNumber
				+ "'," + " gender = '" + gender + "'" + " where email='"
				+ email + "'";
		System.out.println("query = " + updateSQL);
		return DB.update(updateSQL);

	}

	public int insert() {
		// TODO Auto-generated method stub
		String insertSQL = "insert into customer"
				+ "(firstName,lastName,mobileNumber,landlineNumber,gender,email,profileName,updatedProfileName,CartAppendNo,updated_email) "
				+ "values(" + "'" + firstName + "','" + lastName + "', '"
				+ mobileNumber + "','" + landlineNumber + "' , '" + gender
				+ "' , '" + email + "','" + profileName + "','"
				+ updatedProfileName + "', '" + 1 + "' , '" + updated_email + "');";

		System.out.println(insertSQL);

		return DB.update(insertSQL);

	}

	public int update_profile(String profileName2, String email2) {
		// TODO Auto-generated method stub
		String updateSQL = "update customer " + "set updatedProfileName= '"
				+ profileName2 + " '"+ " where email='" + email2 + "'";
		System.out.println("query = " + updateSQL);
		return DB.update(updateSQL);
	}

	public int update_email(String updated_email2, String email2) {
		// TODO Auto-generated method stub
		String updateSQL = "update customer " + "set updated_email= '"
				+ updated_email2 + " '"+ " where email='" + email2 + "'";
		System.out.println("query = " + updateSQL);
		return DB.update(updateSQL);
	}

	public int update_newemail(String updated_email2, String email2) {
		System.out.println("in customer update....");
		// TODO Auto-generated method stub
		String updateSQL = "update customer " + "set email= '"
				+ updated_email2 + " '"+ " where email='" + email2 + "'";
		System.out.println("query = " + updateSQL);
		return DB.update(updateSQL);
	}


}
