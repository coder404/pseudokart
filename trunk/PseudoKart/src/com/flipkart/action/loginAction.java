package com.flipkart.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.flipkart.model.Login;

public class loginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	private String emailForgotPwd;
	
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

		// validate email
		if (email.isEmpty()) {
			addFieldError("email", "Enter Email Address");
		}

		// validate password
		if (password.isEmpty()) {
			addFieldError("password", "Enter Password");
		}
	}
	
	public String login() {
		Map session = ActionContext.getContext().getSession();
		int fl = 0;
		ArrayList<Login> list = new ArrayList<Login>();
		list = Login.find("");
		System.out.println(list.size());
		String tmpusr = "";
		String tmppass = "";
		for(int i = 0;i < list.size();i++)
		{
			tmpusr=list.get(i).getEmail();
			tmppass=list.get(i).getPassword();
			if(this.email.equals(tmpusr) && this.password.equals(tmppass))
			{
				fl = 1;
				session.put("email",email);
				break;
			}
		}
			
		if(fl == 1) {
			return "success";
		}
		else {
			addActionError(getText("Incorrect user id and / or password!"));
			return "error";
		}
}
	
	public String retrievePassword() {
		return "success";
	}
	
}