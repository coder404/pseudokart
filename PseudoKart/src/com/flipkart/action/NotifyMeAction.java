package com.flipkart.action;

import com.flipkart.model.Stock;
import com.opensymphony.xwork2.ActionSupport;

public class NotifyMeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String emailid;
	private String productId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String execute()
	{
		System.out.println("Inside notify Me");
		String sql = "'" + emailid + "','" + productId + "'";
Stock.insertNotifyMe(sql);
		System.out.println(productId + " " + emailid);
		
		return "success";
	}
	
	
}


