package com.flipkart.action;

import java.util.Map;

import com.flipkart.model.Product;
import com.flipkart.model.ProductRatings;
import com.flipkart.model.Stock;
import com.flipkart.model.userRatings;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class productRatingsAction extends ActionSupport{
	private String prodId;
	
	private int rating;
	private int numberOfCustomers;
	Product product;
	String productName;
	float product_rating;
	boolean inStock;
	private String email;
	Map session = ActionContext.getContext().getSession();
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	ProductRatings pr=new ProductRatings();
	userRatings ur=new userRatings();
	
	public String execute(){
		System.out.println("Rating"+rating);
		
		
		email=(String)session.get("email");
		if(email==null){
			return "error";
		}else{
			prodId=(String)session.get("pro_id");
			String mod="where productId='"+prodId+"'";
			
			
			System.out.println("Inside ratings execute...."+mod);
			pr=ProductRatings.findOne(mod);
			 
			String mod1=mod+"and email='"+email+"'";
			System.out.println("mod1"+mod1);
			
			ur=userRatings.findOne(mod1);
			
			if(ur!=null){
				addActionError("You have alreday rated this product...");
				String sql1 = "where productId = '" + prodId + "'";
				System.out.println("sql=" + sql1);

				product = Product.findProduct(sql1);


				String sql = "where name = '" + product.getName() + "'";
				System.out.println("sql=" + sql);

				product = Product.findProduct(sql);

				sql = "where productId = '" + product.getProdid() + "'";
				System.out.println("SQL :" + sql);
				product_rating = Product.ratingsProduct(sql);
				System.out.println("Average Product Ratings...."+product_rating);

				Stock s=Stock.findOne("where stockProductID='"+product.getProdid()+"'");


				if(s==null || s.getQuantity()==0)
					inStock = false;
				else
					inStock = true;


				
				
				
				return "invalid";
			}
			
			if(pr==null){
				//insert into database
				ProductRatings prRatings=new ProductRatings();
				prRatings.setProdId(prodId);
				prRatings.setRating(rating);
				prRatings.setNumberOfCustomers(1);
				userRatings urRatings=new userRatings();
				urRatings.setProductId(prodId);
				urRatings.setRatings(rating);
				urRatings.setEmail(email);
				urRatings.insert(prodId,rating,email);
				prRatings.insert(prodId,rating);

			}else{
				userRatings urRatings=new userRatings();
				urRatings.setProductId(prodId);
				urRatings.setRatings(rating);
				urRatings.setEmail(email);
				urRatings.insert(prodId,rating,email);
				pr.update(prodId,rating,pr.getNumberOfCustomers());
			}
			
			String sql1 = "where productId = '" + prodId + "'";
			System.out.println("sql=" + sql1);

			product = Product.findProduct(sql1);


			String sql = "where name = '" + product.getName() + "'";
			System.out.println("sql=" + sql);

			product = Product.findProduct(sql);

			sql = "where productId = '" + product.getProdid() + "'";
			System.out.println("SQL :" + sql);
			product_rating = Product.ratingsProduct(sql);
			
			System.out.println("Average Ratings...."+product_rating);

			Stock s=Stock.findOne("where stockProductID='"+product.getProdid()+"'");


			if(s==null || s.getQuantity()==0)
				inStock = false;
			else
				inStock = true;


			//session.put("productID", product_rating);
			


			return SUCCESS;
		}
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
	public String getProductName() {
		return productName;
	}
	public float getProduct_rating() {
		return product_rating;
	}
	public void setProduct_rating(float product_rating) {
		this.product_rating = product_rating;
	}
	public boolean isInStock() {
		return inStock;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
