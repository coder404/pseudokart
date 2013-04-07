package com.flipkart.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.flipkart.model.Address;
import com.flipkart.model.Cart;
import com.flipkart.model.Customer;
import com.flipkart.model.Login;
import com.flipkart.model.Order;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeMultipart;

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
	private String updated_email="";
	Customer customerAction = new Customer();

	Login login;


	Map session=ActionContext.getContext().getSession();

	// variables password
	private String oldPassword;
	private String newPassword;
	private String reNewPassword;

	public String execute() {

		email=(String)session.get("email");
		if(email==null){
			System.out.println("email in execute...ifff"+email);
			return "error";
		}else{
			System.out.println("email in execute...else"+email);
			String mod = "where email='" + email + "'";
			customerAction = Customer.findOne(mod);
			return SUCCESS;
		}
	}

	public String personalInformation() {
		email=(String)session.get("email");
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

	public String changePasswordPage() {//for page navigation
		email=(String)session.get("email");
		String mod = "where email='" + email + "'";
		customerAction = Customer.findOne(mod);

		return SUCCESS;
	}

	public String changePassword() {
		email=(String)session.get("email");
		String mod = "where email='" + email + "'";
		customerAction = Customer.findOne(mod);

		// Find one object of login for the corresponding email

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




	public String profileSettings() {
		/*
		 * String
		 * emailSession=(String)ActionContext.getContext().getSession().get
		 * ("email");
		 */
		email=(String)session.get("email");
		String mod = "where email='" + email + "'";
		//System.out.println(mod);
		customerAction = Customer.findOne(mod);
		if(! customerAction.getUpdatedProfileName().equals("")){
			return "error";
		}
		return SUCCESS;
	}

	public String updateProfileName(){
		email=(String)session.get("email");
		String mod = "where email='" + email + "'";
		System.out.println(mod);
		customerAction = Customer.findOne(mod);
		//System.out.println(profileName);
		//System.out.println(customerAction.getProfileName());
		if(! profileName.equals(customerAction.getProfileName()) && customerAction.getUpdatedProfileName().equals("")){
			customerAction.update_profile(profileName,email);
			customerAction = Customer.findOne(mod);
			return SUCCESS;

		}


		return "error";
	}


	public String updateEmailPage() {
		email=(String)session.get("email");
		String mod = "where email='" + email + "'";
		customerAction = Customer.findOne(mod);

		return SUCCESS;
	}

	public String updateEmail(){
		int flag=0;
		email=(String)session.get("email");
		String mod = "where email='" + email + "'";
		customerAction = Customer.findOne(mod);
		//customerAction.setUpdated_email(updated_email);
		customerAction.update_email(updated_email,email);
		try {

			String host = "smtp.gmail.com";
			String from = "com.iiitb.pseudokart@gmail.com";
			String pass = "kart@123";
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true"); // added this line
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", pass);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");

			String to = this.updated_email; // added this line
			System.out.println("to :" + to);
			Session session = Session.getDefaultInstance(props, null);

			//String param1 = email;
			String baseURL= "http://localhost:8080/PseudoKart/";
			String actionName= "updateNewEmail;//?";
			String URL = baseURL+actionName;//+"&email="+updated_email;

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			InternetAddress toAddress = new InternetAddress(to);

			System.out.println(Message.RecipientType.TO);

			message.addRecipient(Message.RecipientType.TO, toAddress);
			System.out.println(toAddress);

			message.setSubject("Update Email");

			message.setText("click here : " + URL);




			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			flag = 1;

		} catch (Exception e) {
			System.out.println(e);
		}


		if(flag==1){
			return SUCCESS;
		}
		else
			return "error";
	}
	public String updateNewEmail(){
		System.out.println("email beginnnig"+email);
		String mod = "where email='" + email + "'";
		int customerId=customerAction.getId();
		String mod1 = "where customer_id='" + customerId + "'";
		
		Login login=new Login();

		ArrayList<Cart> carts=new ArrayList<Cart>();
		ArrayList<Order> orders=new ArrayList<Order>();
		ArrayList<Address> address=new ArrayList<Address>();
		
		address=Address.findAll(mod1);
		
		login=Login.findOne(mod);
		customerAction=Customer.findOne(mod);
		carts=Cart.findAll(mod);
		orders=Order.findAll(mod);

		String mod2 = "where email='" + customerAction.getUpdated_email() + "'";
		
		Login newLogin=new Login();
		ArrayList<Cart> newCarts=new ArrayList<Cart>();
		ArrayList<Order> newOrders=new ArrayList<Order>();
		ArrayList<Address> newAddress=new ArrayList<Address>();
		Customer newCustomer=new Customer();

		
		newAddress=Address.findAll(mod1);
		newLogin=Login.findOne(mod);
		newCustomer=Customer.findOne(mod);
		newCarts=Cart.findAll(mod);
		newOrders=Order.findAll(mod);

		newLogin.setEmail(customerAction.getUpdated_email());
			
		newCustomer.setEmail(customerAction.getUpdated_email());
		newCustomer.setUpdated_email("");
		for(int i=0;i<newAddress.size();i++){
			newAddress.get(i).setCustomer_id(newCustomer.getId());
		}

		
		for(int i=0;i<newCarts.size();i++){
			newCarts.get(i).setEmail(customerAction.getUpdated_email());
		}

		for(int i=0;i<newOrders.size();i++){
			newOrders.get(i).setEmail(customerAction.getUpdated_email());
		}

		//delete from child tables first then delete from parent table
		for(int i=0;i<address.size();i++){
			address.get(i).delete();
			
		}
		customerAction.delete(email);
		for(int i=0;i<carts.size();i++){
			carts.get(i).delete(email);

		}
		for(int i=0;i<orders.size();i++){
			orders.get(i).delete(email);

		}
		login.delete(email);


		//insert into parent table first then to child tables
		newLogin.insert();
		newCustomer.insert();
		
		for(int i=0;i<newAddress.size();i++){
			newAddress.get(i).insert(newCustomer.getId());		
		}
		for(int i=0;i<newCarts.size();i++){
			newCarts.get(i).insert();

		}
		for(int i=0;i<newOrders.size();i++){
			newOrders.get(i).insert();

		}

		//System.out.println("UPDATED EMAIL.."+customerAction.getUpdated_email());
		//login.update_email(customerAction.getUpdated_email(),email);
		//customerAction.update_newemail(customerAction.getUpdated_email(), email);

		
		System.out.println("email endddddd"+mod2);
		customerAction=Customer.findOne(mod2);
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

	public String getUpdated_email() {
		return updated_email;
	}

	public void setUpdated_email(String updated_email) {
		this.updated_email = updated_email;
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
