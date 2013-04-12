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
	String product_status;
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
	public ArrayList<Cart> onClickBuy(String uemail)
	{   
		productId=(String)ActionContext.getContext().getSession().get("pro_id");
		//System.out.println("!@#$%^&*()="+productId);
		appendNo=Cart.getCurrentAppendNo(uemail);
		ActionContext.getContext().getSession().put("cartAppendNo", appendNo);
		System.out.println("in cart add item --append num CHECK"+appendNo);
		cart_status=Cart.checkCurrentCart(uemail,appendNo);
		product_status=Cart.checkProduct(productId,uemail,appendNo);
		System.out.println("^^^^^^^^"+product_status);
		if(product_status=="notfound"){
			quantity=1;
		Cart.insertIntoCart(uemail,productId,appendNo,quantity);
			
		}
		else{}
		ActionContext.getContext().getSession().put("prod_status",product_status);
		
	
		
			
		
		CartItems=getCartItems();
		//getAmount();
		System.out.println("^^^^^^^"+CartItems.size());
		for(int i=0;i<CartItems.size();i++){
			
			amount+=CartItems.get(i).subtotal;
			System.out.println("******"+amount);}
		//double Payable_Amt;
		ActionContext.getContext().getSession().put("totalCartAmt", amount);
		System.out.println(amount);
		return CartItems;
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
