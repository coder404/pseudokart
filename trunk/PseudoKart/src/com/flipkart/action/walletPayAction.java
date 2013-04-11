package com.flipkart.action;

import com.flipkart.model.*;
import com.opensymphony.xwork2.ActionContext;

import java.util.*;

public class walletPayAction {

	ArrayList<Cart> cartItems = new ArrayList<Cart>();

	public ArrayList<Cart> getCartItems() {
		return cartItems;
	}

	public void setCartItems(ArrayList<Cart> cartItems) {
		this.cartItems = cartItems;
	}

	public String execute() throws Exception {
		double bal = Wallet.findBalance();
		
		double cart_amt = (Double) ActionContext.getContext().getSession()
				.get("totalCartAmt");
		Wallet.updateBalance(bal - cart_amt);
		Order.updatePaidStatus();
		Customer.cartAppendNoInc();
		cartItems = Cart.getCart((String) ActionContext.getContext()
				.getSession().get("email"), (String) ActionContext.getContext()
				.getSession().get("cartAppendNo"));
		Stock.reduceQunatity(cartItems);
		return "success";
		
				}

}
