package com.flipkart.action;

import javax.mail.Session;

import com.flipkart.model.Cart;
import com.flipkart.model.Order;
import com.opensymphony.xwork2.ActionContext;

public class CartAction_PlaceOrder {
	
	String topupamt;
	
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
	
	public String walletredirect()
	{
		System.out.println("on way to struts..");
		System.out.println("top up amount = "+topupamt);
		ActionContext.getContext().getSession().put("topupamt", this.topupamt);
		Cart obj=new Cart();
		obj.setProductId("");
		obj.setDeliveryTime("");
		obj.setItemDesc("Wallet Recharge");
		obj.setQuantity(0);
		obj.setSubtotal(Double.parseDouble(topupamt));
		ActionContext.getContext().getSession().put("walletcart", obj);
		ActionContext.getContext().getSession().put("totalCartAmt", Double.parseDouble(topupamt));
		ActionContext.getContext().getSession().put("cartAppendNo","0");
		return "ok";
	}

	public String getTopupamt() {
		return topupamt;
	}
	public void setTopupamt(String topupamt) {
		this.topupamt = topupamt;
	}
	
}
