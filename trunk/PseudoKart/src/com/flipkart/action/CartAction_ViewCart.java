package com.flipkart.action;

import java.util.ArrayList;
import java.util.Map;

import com.flipkart.model.Cart;
import com.opensymphony.xwork2.ActionContext;

public class CartAction_ViewCart {
	public  double amount=0;
	public  double getAmount() {
		amount=0;
		amount=Cart.getTotalAmount(CartItems_View);
		
		return amount;
	}
	public  void setAmount(double amount) {
		this.amount = amount;
	}
	//Cart cart_obj=new Cart();
	public String getAppendNo() {
		appendNo=Cart.getCurrentAppendNo(uemail);
		return appendNo;
	}
	public void setAppendNo(String appendNo) {
		this.appendNo = appendNo;
	}
	String appendNo;
	//Map session;
	//String productId="HTC001";
	int quantity;
	String uemail=(String)ActionContext.getContext().getSession().get("email");//Need to take it from login session
	public static ArrayList<Cart> CartItems_View=new ArrayList<Cart>();
	
	public ArrayList<Cart> getCartItems_View() {
		ArrayList<Cart> CartItems_View=new ArrayList<Cart>();
		CartItems_View=Cart.getCart(uemail, appendNo);    //get it from session
		return CartItems_View;
	}
	public void setCartItems_View(ArrayList<Cart> cartItems_View) {
		CartItems_View = cartItems_View;
	}
	boolean cart_status;
	public String execute()
	{
		return "success";
	}
	public String onClickCart()
	{
		appendNo=Cart.getCurrentAppendNo(uemail);
		ActionContext.getContext().getSession().put("cartAppendNo", appendNo);
		System.out.println("in cart add item --append num CHECK"+appendNo);
		cart_status=Cart.checkCurrentCart(uemail,appendNo);
		System.out.println("In cart add item -- cart_status check"+cart_status);
		if(cart_status==true)  /*previous cart exists with unpaid status.Need to add this item to that cart itself*/
		{
			quantity=1;
			//Cart.insertIntoCart(uemail,productId,appendNo,quantity);
			
			//Cart.insertToCart()
			CartItems_View=getCartItems_View();
			//getAmount();
			System.out.println("^^^^^^^"+CartItems_View.size());
			for(int i=0;i<CartItems_View.size();i++){
				
				amount+=CartItems_View.get(i).subtotal;
				System.out.println("******"+amount);}
			//double Payable_Amt;
			ActionContext.getContext().getSession().put("totalCartAmt", amount);
			System.out.println(amount);
			return "success";
			
		}
		else if(cart_status==false) /*previous cart is paid.So,need to create a new cart */{
			//quantity=1;
			//Cart.insertIntoCart(uemail,productId,appendNo,quantity);
			return "empty_cart";
		}
		else
			return "error";
		//getCartItems();
		//getAmount();
		//return "success";
	}

}
