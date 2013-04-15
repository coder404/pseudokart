package com.flipkart.action;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.flipkart.model.*;

public class displayProduct extends ActionSupport {

	
	String productName;
	float product_rating;
	String productId;
   boolean inStock;
   
   Map session = ActionContext.getContext().getSession();
   private String email;
   	public boolean isInStock() {
   		
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
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


	public String execute() {

		email=(String)session.get("email");
		if(email==null){
			String sql = "where productId = '" + productId + "'";
			System.out.println("sql=" + sql);
			
		product	 = Product.findProduct(sql);
			
		sql = "where productId = '" + product.getProdid() + "'";
		session.put("pro_id",product.getProdid());
		System.out.println("SQL :" + sql);
		 product_rating = Product.ratingsProduct(sql);
		System.out.println(product_rating);
		session.put("productID",product_rating);
		Stock s=Stock.findOne("where stockProductID='"+product.getProdid()+"'");
			if(s.getQuantity()<=5)
				inStock = false;
			else
				inStock = true;
					
		return "error";
		}else{
		String sql = "where productId = '" + productId + "'";
		System.out.println("sql=" + sql);
		
	product	 = Product.findProduct(sql);
		
	sql = "where productId = '" + product.getProdid() + "'";
	session.put("pro_id",product.getProdid());
	System.out.println("SQL :" + sql);
	 product_rating = Product.ratingsProduct(sql);
	System.out.println(product_rating);
	session.put("productID",product_rating);
	Stock s=Stock.findOne("where stockProductID='"+product.getProdid()+"'");
		if(s.getQuantity()<=5)
			inStock = false;
		else
			inStock = true;
				
		
		
		return "success";
		}
		
	}

	public Product getProduct() {
		return product;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}