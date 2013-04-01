package com.flipkart.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.DAO.RetrieveCategories;

import com.mast.util.DB;
import com.opensymphony.xwork2.ActionSupport;

public class Categories_List extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<String> categories_list = new ArrayList<String>();
	ArrayList<String> subcategories_list = new ArrayList<String>();
	

	public ArrayList<String> getCategories_list() {
		return categories_list;
	}

	public void setCategories_list(ArrayList<String> categories_list) {
		this.categories_list = categories_list;
	}

	ResultSet rs;

	public String execute() {
		rs = RetrieveCategories.getCategories();
		try {
			while (rs.next()) {
				categories_list.add(rs.getString("name"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setCategories_list(categories_list);
		return "success";

	}

	public ArrayList<String> getSubCategories(String category) {
		System.out.println("category  " + category);
		rs = RetrieveCategories.getSubCategories(category);
		try {
			while (rs.next()) {
				subcategories_list.add(rs.getString("name"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return subcategories_list;

	}

	public ArrayList<String> getProducts(String subcategory) {
		System.out.println("subcategory  " + subcategory);
		ArrayList<String> products_list = new ArrayList<String>();
		rs = RetrieveCategories.getProducts(subcategory);
		try {
			while (rs.next()) {
				products_list.add(rs.getString("name"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products_list;

	}
}
