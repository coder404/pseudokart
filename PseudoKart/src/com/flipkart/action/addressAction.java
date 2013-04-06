package com.flipkart.action;

import java.util.ArrayList;
import java.util.Map;

import com.flipkart.model.Address;
import com.flipkart.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class addressAction extends ActionSupport {
	// variables declaration

	private int address_id;
	private String name = " ";
	private String streetAddress = " ";
	private String landmark = " ";
	private String city = " ";
	private String state = " ";
	private String country = "India";
	private String pin = " ";
	private String phone = " ";
	private int customer_id;

	Map session=ActionContext.getContext().getSession();
	ArrayList<Address> addressList=new ArrayList<Address>();
	ArrayList<Address> customerAddressList=new ArrayList<Address>();
	Address address= new Address();
	Customer customerAction = new Customer();
	public boolean containsOnlyNumbers(String str) {

		for (int i = 0; i < str.length(); i++) {

			//If we find a non-digit character we return false.
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}

		return true;
	}

	public String execute() {


		String email=(String)session.get("email");
		String mod = "where email='" + email + "'";
		customerAction = Customer.findOne(mod);
		name=customerAction.getFirstName()+ " "+customerAction.getLastName(); 
		if(name.isEmpty() || streetAddress.isEmpty() || landmark.isEmpty() || city.isEmpty() || state.isEmpty() || pin.isEmpty() || phone.isEmpty()){
			addActionError("Please provide all details.");
			return "error";
		}
		else if(containsOnlyNumbers(phone) == false || pin.length() !=6){
			addActionError("Please provide valid Pincode.");
			return "error";

		}
		else if(containsOnlyNumbers(phone) == false){
			addActionError("Please provide valid Phone number.");
			return "error";
		}
		else{
			Address address=new Address();
			//address.setAddress_id(address_id);
			address.setName(name);
			address.setStreetAddress(streetAddress);
			address.setLandmark(landmark);
			address.setCity(city);
			address.setState(state);
			address.setCountry(country);
			address.setPin(pin);
			address.setPhone(phone);
			address.setCustomer_id(customerAction.getId());
			System.out.println("Id"+ customerAction.getId());

			address.insert(customerAction.getId());
			reset();

			addressList=Address.findAll();

			for(int i=0;i<addressList.size();i++){
				if(addressList.get(i).getCustomer_id() == customerAction.getId())
					customerAddressList.add(addressList.get(i));

			}
			/*
			for(int i=0;i<customerAddressList.size();i++){
				System.out.println(customerAddressList.get(i).getName());


			}
			 */
			System.out.println("size of customer address list"+customerAddressList.size());
			addActionMessage("Address saved successfully");
			 return SUCCESS;
		}
	}



	private void reset() {
		// TODO Auto-generated method stub
		streetAddress="";
		landmark="";
		city="";
		state="";
		country="";
		pin="";
		phone="";

	}

	// method just for address page
	public String addresses() {
		String email="";
		email=(String)session.get("email");
		String mod = "where email='" + email + "'";
		customerAction = Customer.findOne(mod);
		name=customerAction.getFirstName()+ "  "+ customerAction.getLastName();

		addressList=Address.findAll();

		for(int i=0;i<addressList.size();i++){
			if(addressList.get(i).getCustomer_id() == customerAction.getId())
				customerAddressList.add(addressList.get(i));

		}
		System.out.println(customerAddressList.size());
		return SUCCESS;
	}
	
	public String deleteAddress(){
		String email="";
		email=(String)session.get("email");
		String mod = "where email='" + email + "'";
		customerAction = Customer.findOne(mod);
		name=customerAction.getFirstName()+ "  "+ customerAction.getLastName();

		
		//System.out.println("ID"+ address_id);
		String mod1 = "where address_id='" + address_id + "'";
		address=Address.findOne(mod1);
		address.delete();
		
		addressList=Address.findAll();

		for(int i=0;i<addressList.size();i++){
			if(addressList.get(i).getCustomer_id() == customerAction.getId())
				customerAddressList.add(addressList.get(i));

		}
		
		return SUCCESS;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Customer getCustomerAction() {
		return customerAction;
	}

	public void setCustomerAction(Customer customerAction) {
		this.customerAction = customerAction;
	}

	public ArrayList<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(ArrayList<Address> addressList) {
		this.addressList = addressList;
	}

	public ArrayList<Address> getCustomerAddressList() {
		return customerAddressList;
	}

	public void setCustomerAddressList(ArrayList<Address> customerAddressList) {
		this.customerAddressList = customerAddressList;
	}

}
