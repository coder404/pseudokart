package com.flipkart.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.flipkart.model.Login;

public class loginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private String emailForgotPwd;
	private String newPassword;
	private String retypeNewPassword;

	Map session = ActionContext.getContext().getSession();

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRetypeNewPassword() {
		return retypeNewPassword;
	}

	public void setRetypeNewPassword(String retypeNewPassword) {
		this.retypeNewPassword = retypeNewPassword;
	}

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

	public String getEmailForgotPwd() {
		return emailForgotPwd;
	}

	public void setEmailForgotPwd(String emailForgotPwd) {
		this.emailForgotPwd = emailForgotPwd;
	}

	public void validate() {

		System.out.println(email);
		System.out.println(password);

		// validate email
		if (email.isEmpty()) {
			addFieldError("email", "Enter Email Address");
		}

		// validate password
		if (password.isEmpty()) {
			addFieldError("password", "Enter Password");
		}
	}

	public String execute() {
		return "success";
	}

	ArrayList<Login> list = new ArrayList<Login>();

	public String login() {

		int fl = 0;

		list = Login.find("");

		String tmpusr = "";
		String tmppass = "";
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			tmpusr = list.get(i).getEmail();
			tmppass = list.get(i).getPassword();
			System.out.println(tmpusr + ", " + tmppass);
			System.out.println(i);
			if (this.email.equals(tmpusr) && this.password.equals(tmppass)) {
				System.out.println("Inside IF....");
				fl = 1;
				session.put("email", email);
				break;
			}
		}

		if (fl == 1) {
			return "success";
		} else {
			addActionError(getText("Incorrect user id and / or password!"));
			return "error";
		}

	}

	public String changePassword() {
		return "success";
	}

	public String forgotPassword() {
		String mod = "";
		mod = "where email = '" + emailForgotPwd + "'";
		if (Login.findOne(mod) != null) {
			// addActionMessage("An email has been successfully sent to your email address");
			return "success";
		} else {
			// addActionError("Invalid Email address");
			return "error";
		}
	}

}