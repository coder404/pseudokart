package com.flipkart.action;

import java.util.*;

import com.flipkart.model.Address;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class placeorderAction extends ActionSupport {
	
	String name="";
	String address="";
	String landmark="";
	String city="";
	String state="";
	String pincode="";
	String phone="";
	int tabno=0;
	static boolean hasMulAddr;
	Map session=ActionContext.getContext().getSession();
   ArrayList<Address> addr_list;
	
	public String initial()
	{
		System.out.println("in initial");
		session.put("email", "yams25@gmail.com"); //this shud be done at login time		
		session.put("tabno", 0);
		return "trial";
	}
	
	public String emailLogin()
	{
		this.setTabno(1);
		System.out.println("forwarding to shipping address");
		session.put("tabno", this.getTabno());
		
		//check if cust has multiple addresses;
		setHasMulAddr(Address.hasMultipleAddrress());
	    //retrieve multiple addresses	
		addr_list=Address.findAll();
		return "ok";
	}
	public String execute()
	{
		
		Address addr=new Address();
		addr.setCity(this.city);
		addr.setCountry("India");
		addr.setLandmark(this.landmark);
		addr.setPhone(this.phone);
		addr.setStreetAddress(this.address);
		addr.setPin(this.pincode);
		addr.setState(this.state);
        addr.setName(this.name);
		addr.insert();
		
        this.setTabno(2);
		System.out.println("forwarding to order summary");
		session.put("tabno", this.getTabno());
		return SUCCESS;
	}
	
	public String reviewOrder()
	{
		this.setTabno(3);
		System.out.println("forwarding to payment");
		session.put("tabno", this.getTabno());
		return "ok";
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getTabno() {
		return tabno;
	}
	public void setTabno(int tabno) {
		this.tabno = tabno;
	}

	public static boolean isHasMulAddr() {
		return hasMulAddr;
	}

	public static void setHasMulAddr(boolean hasMulAddr) {
		placeorderAction.hasMulAddr = hasMulAddr;
	}

	public ArrayList<Address> getAddr_list() {
		return addr_list;
	}

	public void setAddr_list(ArrayList<Address> addr_list) {
		this.addr_list = addr_list;
	}

	
}
