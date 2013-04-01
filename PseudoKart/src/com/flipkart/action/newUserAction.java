package com.flipkart.action;

import com.flipkart.model.Login;
import com.opensymphony.xwork2.ActionSupport;

public class newUserAction extends ActionSupport{
	
	private String email;
	private String password;
	private String repeatPassword;
	
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

	public void validate() {

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
	
	public String execute() {
		int flag = 0;
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);
		flag = login.insert();
		
		if(flag == 1)
			return "success";
		else {
			//addActionMessage(ERROR);
			return "error";
		}
	}
}