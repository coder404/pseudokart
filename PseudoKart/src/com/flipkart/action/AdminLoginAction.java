package com.flipkart.action;

import java.util.ArrayList;

import com.flipkart.model.Login;
import com.flipkart.model.adminLogin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport{

	String email;
	String passwd;
	ArrayList<adminLogin> list=new ArrayList<adminLogin>();
	
	public ArrayList<adminLogin> getList() {
		return list;
	}
	public void setList(ArrayList<adminLogin> list) {
		this.list = list;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String execute()
	{
		int flg=0;
		if(this.email==null && this.passwd==null)
		{
			
			return "initial";
		}
		else
		{
				list=adminLogin.find("");
				for(int i=0;i<list.size();i++)
				{
					if((list.get(i).getEmail().equals(this.email)) && (list.get(i).getPasswd().equals(this.passwd)))
						flg=1;					
							
				}
				
				if(flg == 1)
					return "success";
				else
				{
					addActionError("Incorrect email/password");
					return "error";
				}
		}
	}


}
