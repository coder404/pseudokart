package com.flipkart.action;

import java.util.ArrayList;
import java.util.Map;

import com.flipkart.model.Address;
import com.flipkart.model.Cart;
import com.flipkart.model.Customer;
import com.flipkart.model.Order;
import com.flipkart.model.Stock;
import com.flipkart.model.voucher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class reviewPlaceOrderAction extends ActionSupport {
	Map session;
	
	String cardno;
	String name_card;
	String month;
	String year;
	String cvv;
	String error="";
	String vcardnum;
	String vpinno;
	double RemVoucherBal;
	double voucherbal=0.0;
	double purchaseAmt=(Double)ActionContext.getContext().getSession().get("totalCartAmt");
	int address_id;
	ArrayList<Cart> cartItems = new ArrayList<Cart>();
	
	public String finish()
	{
		System.out.println("Purchase over");
		return "ok";
	}
	public String MultiAddrSelect()
	{
		session=ActionContext.getContext().getSession();
		System.out.println("forwarding to order summary");
		session.put("tabno", 2);
	    System.out.println("address="+address_id);
		Address a=Address.findOne("where address_id="+address_id);  	
		session.put("shipaddr", a);
		cartItems=Cart.getCart((String)ActionContext.getContext().getSession().get("email"), (String)ActionContext.getContext().getSession().get("cartAppendNo"));
		System.out.println("in multi select **"+cartItems.size());
		return "move";
		
	}
	
	public String navigate()
	{

		session=ActionContext.getContext().getSession();
		System.out.println("forwarding to payment");
		session.put("tabno", 3);
		session.put("paytabno", 0);
		return "ok";
	}

	public String creditdebiterror()
	{
		session=ActionContext.getContext().getSession();
		session.put("tabno", 3);
		session.put("paytabno", 1);
		addActionError((String)session.get("creditmsg"));
		error="";
		return "ok";
	}
	
	public String execute()
	{
		
		error="";
		System.out.println("month="+month+" year="+year);
		if(cardno.isEmpty())
		{
			error+="Card Number is required.";
		}
		if(!(cardno.isEmpty()) && (cardno.length()!=16))
		{
			error+="Card Number is 16 digit.";
		}
		if(name_card.isEmpty())
		{
			error+="Name is required.";
		}
		if(cvv.isEmpty())
		{
			error+="CVV number is required.";
		}
		if( !(cvv.isEmpty()) && (cvv.length()!=3))
		{
			error+="CVV has to be three digits.";
		}
		if(month.equals("-1"))
		{
			error+="Expiry month is required.";
		}
		if(year.equals("-1"))
		{
			error+="Expiry year is required.";
		}
	  if(error.isEmpty())
		  return SUCCESS;
	  else
	  {
		  System.out.println("error="+error);
		  session=ActionContext.getContext().getSession();
		  session.put("creditmsg", error);
		  return "fail";
	  }
	

	}
	
	
	public String payVoucher()
	{
		error="";
		int flag=0;
		
		ArrayList<voucher> list;
		if(vcardnum.isEmpty())
		{
			error+="Voucher Card Number is required.";
		}
		if(vpinno.isEmpty())
		{
			error+="Voucher PIN number is necessary.";
		}
		if( !(vcardnum.isEmpty()) && (vcardnum.length()!=10))
		{
			error+="Voucher Card Number has to be 10 digits.";
		}
		
		if( !(vpinno.isEmpty()) && (vpinno.length()!=4))
		{
			error+="Voucher PIN has to be 4 digits.";
		}
		
		list=voucher.findAll();
		if(list!=null && !(vpinno.isEmpty()) && !(vcardnum.isEmpty()))
		{
			for(int i=0;i<list.size();i++)
			{
				
					if( list.get(i).getVoucher_number().equals(vcardnum) && list.get(i).getVoucher_pin().equals(vpinno) )
				      {flag=1; voucherbal=list.get(i).getBalance();break;}		
						
			}
		}
		if(flag==0)
			error+="Invalid Voucher Details";
		
		if(flag==1)
		{
			//check voucher balance with current purchase amount
			
			System.out.println("voucher bal="+voucherbal+" purchase amt="+purchaseAmt);
			if(purchaseAmt > voucherbal)
				error+="Insufficient Voucher Balance";
		}
		
		 if(error.isEmpty())
		 {    
			 RemVoucherBal = voucherbal - purchaseAmt;
			 //update voucher balance
			 voucher.update(vcardnum,RemVoucherBal); 
			 //change status of orderdetails tables and change cartAppendNo;
			 Order.updatePaidStatus();
			 Customer.cartAppendNoInc();
			 cartItems=Cart.getCart((String)ActionContext.getContext().getSession().get("email"), (String)ActionContext.getContext().getSession().get("cartAppendNo"));
			 
			 if(cartItems!=null)
			 System.out.println("cart size in voucher success="+cartItems.size());
			 //reduce stock amount
			 Stock.reduceQunatity(cartItems);
			  return SUCCESS;
		 }
		 else
		  {
			  System.out.println("error="+error);
			  session=ActionContext.getContext().getSession();
			  session.put("Vouchermsg", error);
			  return "fail";
		  }
	}
	
	public String vouchererror()
	{
		session=ActionContext.getContext().getSession();
		session.put("tabno", 3);
		session.put("paytabno", 2);
		addActionError((String)session.get("Vouchermsg"));
		error="";
		return "ok";
	}
	

	public String getCardno() {
		return cardno;
	}


	public void setCardno(String cardno) {
		this.cardno = cardno;
	}


	public String getName_card() {
		return name_card;
	}


	public void setName_card(String name_card) {
		this.name_card = name_card;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getVcardnum() {
		return vcardnum;
	}

	public void setVcardnum(String vcardnum) {
		this.vcardnum = vcardnum;
	}

	public String getVpinno() {
		return vpinno;
	}

	public void setVpinno(String vpinno) {
		this.vpinno = vpinno;
	}

	public double getRemVoucherBal() {
		return RemVoucherBal;
	}

	public void setRemVoucherBal(double remVoucherBal) {
		RemVoucherBal = remVoucherBal;
	}

	public double getVoucherbal() {
		return voucherbal;
	}

	public void setVoucherbal(double voucherbal) {
		this.voucherbal = voucherbal;
	}

	public double getPurchaseAmt() {
		return purchaseAmt;
	}

	public void setPurchaseAmt(double purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public ArrayList<Cart> getCartItems() {
		return cartItems;
	}
	public void setCartItems(ArrayList<Cart> cartItems) {
		this.cartItems = cartItems;
	}
	
}
