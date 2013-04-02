package com.flipkart.action;

import java.util.ArrayList;
import java.util.Map;

import com.flipkart.model.Cart;
import com.opensymphony.xwork2.ActionContext;

public class CartAction_AddItem {

	public  double amount=0;
	String appendNo;
	Map session;
	String productId;
	int quantity;
	boolean cart_status;
	String uemail=(String)ActionContext.getContext().getSession().get("email");//Need to take it from login session
	

	public String getAppendNo() {
		appendNo=Cart.getCurrentAppendNo(uemail);
		return appendNo;
	}
	public void setAppendNo(String appendNo) {
		this.appendNo = appendNo;
	}
	
	
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
	
		
	public String execute()
	{
		return "success";
	}
	public String onClickBuy()
	{
		System.out.println("!@#$%^&*()="+productId);
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
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public boolean isCart_status() {
		return cart_status;
	}
	public void setCart_status(boolean cart_status) {
		this.cart_status = cart_status;
	}
}
