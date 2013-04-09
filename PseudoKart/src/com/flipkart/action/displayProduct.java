package com.flipkart.action;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.flipkart.model.*;

public class displayProduct extends ActionSupport {

	
	String productName;
	String prodId;
	
	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	float product_rating;
	public float getProduct_rating() {
		return product_rating;
	}

	public void setProduct_rating(float product_rating) {
		this.product_rating = product_rating;
	}

	Product product = new Product();
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() {

		Map session = ActionContext.getContext().getSession();
		String sql = "where name = '" + productName + "'";
		System.out.println("sql=" + sql);
		
	product	 = Product.findProduct(sql);
		
	sql = "where productId = '" + product.getProdid() + "'";
	System.out.println("SQL :" + sql);
	 product_rating = Product.ratingsProduct(sql);
	System.out.println(product_rating);
	session.put("productID",product_rating);
	
				
		
		
		return "success";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
