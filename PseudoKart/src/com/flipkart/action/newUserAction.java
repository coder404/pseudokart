package com.flipkart.action;

import com.flipkart.model.Customer;
import com.flipkart.model.Login;
import com.opensymphony.xwork2.ActionSupport;

public class newUserAction extends ActionSupport{
	
	private String email;
	private String password;
	private String repeatPassword;
	
	private String firstName="";
	private String lastName="";
	private String mobileNumber="";
	private String landlineNumber="";
	private String gender="";
	private String profileName="";
	private String updatedProfileName="";
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	/*public void validate() {

		// validate email
		if (email.isEmpty()) {
			addFieldError("email", "Email Address field cannot be left blank");
		}

		// validate password
		if (password.isEmpty()) {
			addFieldError("password", "Password field cannot be left black");
		}
		
		//validate repeat password
		if (repeatPassword.isEmpty()) {
			addFieldError("repeatPassword", "Please enter the password again");
		}
		
		//check if passwords match
		if(!password.equals(repeatPassword)) {
			addFieldError("repeatPassword", "Passwords do not match!");
		}
	}
	
*/	
	public String newUser()
	{
		return "success";
	}
	
	public String execute() {
		int flag = 0;
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);
		flag = login.insert();
		int minimum=400;
		int maximum=2000;
		String random,subemail;
		random=minimum + (int)(Math.random()*maximum)+"";
		subemail=email.substring(0,5);
		profileName=subemail+random;
		Customer newCustomer=new Customer();
		newCustomer.setFirstName("");
		newCustomer.setLastName("");
		newCustomer.setGender("");
		newCustomer.setMobileNumber("");
		newCustomer.setLandlineNumber("");
		newCustomer.setUpdatedProfileName("");
		newCustomer.setEmail(email);
		newCustomer.setProfileName(profileName);
		
		newCustomer.insert();
		if(flag == 1)
			return "success";
		else {
			//addActionMessage(ERROR);
			return "error";
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLandlineNumber() {
		return landlineNumber;
	}

	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getUpdatedProfileName() {
		return updatedProfileName;
	}

	public void setUpdatedProfileName(String updatedProfileName) {
		this.updatedProfileName = updatedProfileName;
	}
}