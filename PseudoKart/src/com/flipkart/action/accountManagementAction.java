package com.flipkart.action;

import java.util.Map;

import com.flipkart.model.Customer;
import com.flipkart.model.Login;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class accountManagementAction extends ActionSupport {
	// User Profile variable declaration
	private int id;
	private String firstName = "";
	private String lastName = "";
	private String mobileNumber = "";
	private String landlineNumber = "";
	private String gender = "";
	private String email = "";
	private String profileName = "";
	private String updatedProfileName = "";
	Customer customerAction = new Customer();

	Login login;

	
	Map session;

	// variables password
	private String oldPassword;
	private String newPassword;
	private String reNewPassword;

	public accountManagementAction() {
		login = new Login();
		login.setEmail("laxmi21888@gmail.com");
		login.setPassword("lax123456");
		session = ActionContext.getContext().getSession();
		email = "laxmi21888@gmail.com";/*
										 * (String)ActionContext.getContext().
										 * getSession().get("email");
										 */
		session.put("email", email);
	}

	public String execute() {
		/*
		 * String
		 * emailSession=(String)ActionContext.getContext().getSession().get
		 * ("email");
		 */
		String mod = "where email='" + email + "'";
		customerAction = Customer.findOne(mod);
		return SUCCESS;
	}

	public String personalInformation() {
		Customer cust = new Customer();
		cust.setFirstName(firstName);
		cust.setLastName(lastName);
		cust.setMobileNumber(mobileNumber);
		cust.setLandlineNumber(landlineNumber);
		cust.setGender(gender);
		cust.setEmail(email);
		cust.updatePersonalInformation();

		// String
		// emailSession=(String)ActionContext.getContext().getSession().get("email");
		String mod = "where email='" + email + "'";
		customerAction = Customer.findOne(mod);
		addActionError("Your Changes have been saved Successfully..");
		return SUCCESS;
	}

	public String orderStatus() {

		return SUCCESS;
	}

	public String changePasswordPage() { //for page navigation
		return SUCCESS;
	}

	public String changePassword() {
		// Find one object of login for the corresponding email
		String mod = "where email='" + email + "'";
		Login login = new Login();
		login = Login.findOne(mod);
		
		if (oldPassword.isEmpty() || newPassword.isEmpty()
				|| reNewPassword.isEmpty()) {
			addActionError("Password Cannot be left empty.");
			return "error";

		} else if (!newPassword.equals(reNewPassword)) {
			addActionError("Password change failed.New Passwords do not match.");
			return "error";

		} else if (!login.getPassword().equals(oldPassword)) {
			addActionError("Email/Password combination is wrong.");
			return "error";
		} else {
			Login login1=new Login();
			login1.setEmail(email);
			login1.setPassword(newPassword);
			login1.update();
			addActionMessage("Password Changed successfully.");
			return SUCCESS;
		}
	}

	// method just for address page
	public String addresses() {

		return SUCCESS;
	}

	public String updateEmail() {
		return SUCCESS;
	}

	public String profileSettings() {
		/*
		 * String
		 * emailSession=(String)ActionContext.getContext().getSession().get
		 * ("email");
		 */
		String mod = "where email='" + email + "'";
		System.out.println(mod);
		customerAction = Customer.findOne(mod);
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Customer getCustomerAction() {
		return customerAction;
	}

	public void setCustomerAction(Customer customerAction) {
		this.customerAction = customerAction;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getReNewPassword() {
		return reNewPassword;
	}

	public void setReNewPassword(String reNewPassword) {
		this.reNewPassword = reNewPassword;
	}
}
