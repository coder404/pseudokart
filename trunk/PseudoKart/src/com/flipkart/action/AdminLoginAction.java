package com.flipkart.action;

import java.util.ArrayList;

import com.flipkart.model.Login;
import com.flipkart.model.adminLogin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String email;
	String passwd;
	private boolean MainAdmin = true;
	
	



	public boolean isMainAdmin() {
		return MainAdmin;
	}
	public void setMainAdmin(boolean mainAdmin) {
		MainAdmin = mainAdmin;
	}

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
		int level=0;
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
					{
						flg=1;
						level = list.get(i).getLevel();
						System.out.println("LEVEL " + level);
					}
				}
				if(level == 1){
					MainAdmin = true;

					System.out.println("LEVEL IS OF MAIN ADMIN");
				}
				else
					MainAdmin = false;
				
				if(MainAdmin == true)
					System.out.println("PRINT OUT");
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
