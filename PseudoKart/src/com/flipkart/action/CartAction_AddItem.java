package com.flipkart.action;

import java.util.ArrayList;
import java.util.Map;

import com.flipkart.model.Cart;
import com.opensymphony.xwork2.ActionContext;

public class CartAction_AddItem {
	public  double amount=0;
	/*public static double amt=0;
	public double getAmount()
	{
		this.amount=getPayableAmount();
		return this.amount;
	}
	public  static double getPayableAmount() {
		amt=0;
		CartAction_AddItem.amt=Cart.getTotalAmount(CartItems);
		for(int i=0;i<CartItems.size();i++){
		
			amount+=CartItems.get(i).subtotal;
			System.out.println("^^^^^"+amount);
			}
		System.out.println("Amount==**"+amt);
		return amt;
	}
	
	public   void setAmount(double amount) {
		this.amount = amount;
	}*/
	//Cart cart_obj=new Cart();
	public String getAppendNo() {
		appendNo=Cart.getCurrentAppendNo(uemail);
		return appendNo;
	}
	public void setAppendNo(String appendNo) {
		this.appendNo = appendNo;
	}
	String appendNo;
	Map session;
	String productId="prod1";
	int quantity;
	String uemail="yams25@gmail.com";//Need to take it from login session
	public static ArrayList<Cart> CartItems=new ArrayList<Cart>();
	public ArrayList<Cart> getCartItems() {
		ArrayList<Cart> CartItems=new ArrayList<Cart>();
		CartItems=Cart.getCart(uemail, appendNo);
		
		return CartItems;
	}
	public void setCartItems(ArrayList<Cart> cartItems) {
		CartItems = cartItems;
		//getAmount();
	}
	boolean cart_status;
	public String execute()
	{
		return "success";
	}
	public String onClickBuy()
	{
		appendNo=Cart.getCurrentAppendNo(uemail);
		ActionContext.getContext().getSession().put("cartAppendNo", appendNo);
		System.out.println("in cart add item --append num CHECK"+appendNo);
		cart_status=Cart.checkCurrentCart(uemail,appendNo);
		System.out.println("In cart add item -- cart_status check"+cart_status);
		if(cart_status==true)  /*previous cart exists with unpaid status.Need to add this item to that cart itself*/
		{
			quantity=1;
			Cart.insertIntoCart(uemail,productId,appendNo,quantity);
			
			//Cart.insertToCart()
		}
		if(cart_status==false) /*previous cart is paid.So,need to create a new cart */{
			quantity=1;
			Cart.insertIntoCart(uemail,productId,appendNo,quantity);
			
		}
		CartItems=getCartItems();
		//getAmount();
		System.out.println("^^^^^^^"+CartItems.size());
		for(int i=0;i<CartItems.size();i++){
			
			amount+=CartItems.get(i).subtotal;
			System.out.println("******"+amount);}
		//double Payable_Amt;
		ActionContext.getContext().getSession().put("totalCartAmt", amount);
		System.out.println(amount);
		return "success";
	}
	

}
