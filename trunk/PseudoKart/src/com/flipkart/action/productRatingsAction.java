package com.flipkart.action;

import com.flipkart.model.Product;
import com.flipkart.model.ProductRatings;
import com.opensymphony.xwork2.ActionSupport;

public class productRatingsAction extends ActionSupport{
	private String prodId;
	private int rating;
	private int numberOfCustomers;
	Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	ProductRatings pr=new ProductRatings();
	public String execute(){
	    	
		//System.out.println("rating:"+rating);
		String mod="where productId='"+prodId+"'";
		
		System.out.println("Inside ratings execute...."+mod);
		
		pr=ProductRatings.findOne(mod);
		if(pr==null){
			//insert into database
			
		}
		pr.update(prodId,rating,pr.getNumberOfCustomers());
		
		return SUCCESS;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	public void setNumberOfCustomers(int numberOfCustomers) {
		this.numberOfCustomers = numberOfCustomers;
	}
	public ProductRatings getPr() {
		return pr;
	}
	public void setPr(ProductRatings pr) {
		this.pr = pr;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int ratings) {
		this.rating = ratings;
	}
	
}
