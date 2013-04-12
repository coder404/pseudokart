package com.flipkart.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.flipkart.DAO.RetrieveSubCategories;
import com.opensymphony.xwork2.ActionSupport;

public class AddProduct extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<String> subCategories_list = new ArrayList<String>();
	
	public ArrayList<String> getSubCategories_list() {
		return subCategories_list;
	}

	public void setSubCategories_list(ArrayList<String> subCategories_list) {
		this.subCategories_list = subCategories_list;
	}

	ResultSet rs;
	
	public String execute() {
		
		rs = RetrieveSubCategories.getSubCategories();
		try {
			while (rs.next()) {
				subCategories_list.add(rs.getString("name"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setSubCategories_list(subCategories_list);
		return "success";
		
	
	
	
	
	}
	

}
