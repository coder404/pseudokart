package com.flipkart.action;

import java.sql.ResultSet;

import java.util.ArrayList;

import com.flipkart.DAO.ProductSelection;
import com.flipkart.DAO.RetrieveCategories;
import com.flipkart.model.Category;
import com.flipkart.model.Product;

import com.opensymphony.xwork2.ActionSupport;

public class Categories_List extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<Category> categories_list = new ArrayList<Category>();

	public ArrayList<Category> getCategories_list() {
		return categories_list;
	}

	public void setCategories_list(ArrayList<Category> categories_list) {
		this.categories_list = categories_list;
	}

	ArrayList<String> subcategories_list = new ArrayList<String>();
	ArrayList<String> products_list = new ArrayList<String>();
	ArrayList<Product> mobiles = new ArrayList<Product>();
	ArrayList<Product> allmobiles = new ArrayList<Product>();
	ArrayList<Product> computers = new ArrayList<Product>();
	public ArrayList<Product> getComputers() {
		return computers;
	}

	public void setComputers(ArrayList<Product> computers) {
		this.computers = computers;
	}

	public ArrayList<Product> getAllcomputers() {
		return allcomputers;
	}

	public void setAllcomputers(ArrayList<Product> allcomputers) {
		this.allcomputers = allcomputers;
	}

	ArrayList<Product> allcomputers = new ArrayList<Product>();

	public ArrayList<Product> getAllmobiles() {
		return allmobiles;
	}

	public void setAllmobiles(ArrayList<Product> allmobiles) {
		this.allmobiles = allmobiles;
	}

	public ArrayList<Product> getMobiles() {
		return mobiles;
	}

	public void setMobiles(ArrayList<Product> mobiles) {
		this.mobiles = mobiles;
	}

	public ArrayList<String> getProducts_list() {
		return products_list;
	}

	public void setProducts_list(ArrayList<String> products_list) {
		this.products_list = products_list;
	}

	ResultSet rs, rs1;

	public String execute() {
		categories_list = RetrieveCategories.getCategories();

		this.setCategories_list(categories_list);

		String query = "select name from product";
		System.out.println(query);
		// Connection connection = DB.getConnection();
		// rs1 = DB.readFromDB(query, connection);
		//
		// try {
		// while (rs1.next()) {
		//
		// products_list.add(rs1.getString("name"));
		// }
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		//
		// e.printStackTrace();
		// }
		// this.setProducts_list(products_list);
		mobiles = ProductSelection.getTwoProducts("Mobiles & Tablets");
		this.setMobiles(mobiles);
		System.out.println("mobiles size is " + mobiles.size());
		allmobiles = ProductSelection.getAllProducts("Mobiles & Tablets");
		this.setAllmobiles(allmobiles);
		System.out.println("mobiles size is " + allmobiles.size());
		computers = ProductSelection.getTwoProducts("Computers");
		this.setComputers(computers);
		System.out.println("computers size is " + computers.size());
		allcomputers = ProductSelection.getAllProducts("Computers");
		this.setAllcomputers(allcomputers);
		System.out.println("computers size is " + allcomputers.size());


		return "success";

	}

	public ArrayList<Category> getSubCategories(String category) {
		System.out.println("category  " + category);
		ArrayList<Category> subcategories_list = new ArrayList<Category>();
		subcategories_list = RetrieveCategories.getSubCategories(category);

		return subcategories_list;

	}

	public ArrayList<Product> getProducts(String subcategory) {
		System.out.println("subcategory  " + subcategory);
		ArrayList<Product> products_list = new ArrayList<Product>();
		products_list = RetrieveCategories.getProducts(subcategory);

		return products_list;

	}
}
