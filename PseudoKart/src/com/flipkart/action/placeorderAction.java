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
	Map session;
	ArrayList<Address> addr_list;
    String error="";
	
	
	public void validate() {

		// valdiate name
		error="";
		if (name.isEmpty()) {
			addFieldError("name", "Name is required.");
		    error+="Name is required."+"\n";
		}

		
		if (address.isEmpty()) {
			addFieldError("address", "Address is required.");
			error+="Address is required.";
		}
		
		if (city.isEmpty()) {
			addFieldError("city", "City is required.");
		     error+="City is required.";
		    
		}
		
		if (state.isEmpty()) {
			addFieldError("state", "State is required.");
			error+="State is required.";
		}
		// valdiate mobile
		if (phone.isEmpty() || phone.length()!=10) {
			addFieldError("phone", "Mobile is required and should be of length 10.");
			error+="Mobile is required and should be of length 10.";
		}
		
		if (pincode.isEmpty() || pincode.length()!=6) {
			addFieldError("pincode", "Pin is required and should be of length 6.");
			error+="Pin is required and should be of length 6.";

		}
		session=ActionContext.getContext().getSession();
		System.out.println("putting error");
		session.put("errors", error);
		error="";
	}

	
	
	
	public String execute()
	{		
		session=ActionContext.getContext().getSession();
		System.out.println("forwarding to order summary");
		session.put("tabno", 2);
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
		return SUCCESS;
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
	

	

	
	
}
