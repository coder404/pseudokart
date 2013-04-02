package com.flipkart.action;

import javax.mail.Session;

import com.flipkart.model.Order;
import com.opensymphony.xwork2.ActionContext;

public class CartAction_PlaceOrder {
	
	public String onClickPlaceOrder()
	{
		double amount=(Double) ActionContext.getContext().getSession().get("totalCartAmt");
		String append_num=(String) ActionContext.getContext().getSession().get("cartAppendNo");
		System.out.println("&&&&&&&&&&&&"+amount);
		System.out.println("*********"+append_num);
		String email=(String)ActionContext.getContext().getSession().get("email");/*need to take it from session*/
		Order.createOrder(email,append_num);
		return "success";
	}

}
