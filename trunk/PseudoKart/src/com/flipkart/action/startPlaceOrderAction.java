package com.flipkart.action;
import java.util.ArrayList;
import java.util.Map;

import com.flipkart.model.Address;
import com.flipkart.model.Order;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class startPlaceOrderAction extends ActionSupport {
	
	Map session=ActionContext.getContext().getSession();
	ArrayList<Address> addr_list;
	static boolean hasMulAddr;
	
	
	
	public String execute()
	{
		System.out.println("in initial");
		//session.put("email", "yams25@gmail.com"); //this shud be done at login time	-- remove and put get,name= sessnm
		session.put("orderID", Order.rtrnorderNum());  
		//System.out.println();
		session.put("tabno", 0);
		
		return "trial";
	}
	public String emailLogin()
	{
		
		System.out.println("forwarding to shipping address");
		session.put("tabno", 1);
		String errors=(String)ActionContext.getContext().getSession().get("errors");
		if(errors!=null)
		{
			System.out.println("errors="+errors);
			addActionError(errors);
		}
		errors="";
		//check if cust has multiple addresses;
	//	setHasMulAddr(Address.hasMultipleAddrress());
	    //retrieve multiple addresses	
		addr_list=Address.findAll();
		return "ok";
	}
	
	public ArrayList<Address> getAddr_list() {
		return addr_list;
	}

	public void setAddr_list(ArrayList<Address> addr_list) {
		this.addr_list = addr_list;
	}
	

	
	
		}
