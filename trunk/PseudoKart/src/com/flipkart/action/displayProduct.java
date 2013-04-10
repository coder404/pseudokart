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
	boolean inStock;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map session = ActionContext.getContext().getSession();
	public String execute() {

		
		String sql = "where name = '" + productName + "'";
		System.out.println("sql=" + sql);

		product = Product.findProduct(sql);
		
		session.put("productId", product.getProdid());
		
		sql = "where productId = '" + product.getProdid() + "'";
		System.out.println("SQL :" + sql);
		product_rating = Product.ratingsProduct(sql);
		System.out.println(product_rating);

		Stock s=Stock.findOne("where stockProductID='"+product.getProdid()+"'");
		//System.out.println("Syock"+s.getQuantity());
		if(s==null || s.getQuantity()==0 )
			inStock = false;
		else
			inStock = true;
		
		
		session.put("productRatings", product_rating);

		return "success";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
