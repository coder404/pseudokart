package com.flipkart.action;

import java.util.Map;

import com.mast.util.MyLog;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class logoutAction extends ActionSupport {
public String execute()  {
		
		
		Map session = ActionContext.getContext().getSession();
		if (session instanceof org.apache.struts2.dispatcher.SessionMap) {
			try {
				((org.apache.struts2.dispatcher.SessionMap) session)
						.invalidate();
			} catch (IllegalStateException e) {
				MyLog.log(e.toString());
			}
		}
		return "success";
	}
	
}
