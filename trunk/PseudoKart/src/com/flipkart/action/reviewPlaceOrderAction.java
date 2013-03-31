package com.flipkart.action;

import java.util.Map;

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
		 if(error.isEmpty())
			  return SUCCESS;
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
	
}
