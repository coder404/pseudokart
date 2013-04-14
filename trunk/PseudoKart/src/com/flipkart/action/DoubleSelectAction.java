package com.flipkart.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.flipkart.DAO.RetrieveCategories;
import com.flipkart.model.Category;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DoubleSelectAction extends ActionSupport{

	
	String err_msg;
	private String language1;
	private String language2;
	
	Map languageMap;

	public String getLanguage1() {
		return language1;
	}

	public void setLanguage1(String language1) {
		this.language1 = language1;
	}

	public String getLanguage2() {
		return language2;
	}

	public void setLanguage2(String language2) {
		this.language2 = language2;
	}

	public Map getLanguageMap() {
		return languageMap;
	}
	
	public Set getLanguageMapKeySet() {
		return languageMap.keySet();
	}

	public void setLanguageMap(Map languageMap) {
		this.languageMap = languageMap;
	}

	public DoubleSelectAction(){
		
		
		languageMap =new HashMap();	
		ArrayList<Category> categories_list = new ArrayList<Category>();
		categories_list = RetrieveCategories.getCategories();
		System.out.println(categories_list.size());
		for(int i=0;i<categories_list.size();i++)
		{
		languageMap.put(categories_list.get(i).getName(), RetrieveCategories.getSubCategorynames(categories_list.get(i).getName()));
		//languageMap.put(".Net", new ArrayList<String>(Arrays.asList("VB.Net", "C#")));
		//languageMap.put("JavaScript", new ArrayList<String>(Arrays.asList("jQuery")));
	
		}
	}

	public String execute() {
		err_msg=(String)ActionContext.getContext().getSession().get("error_msgs");
		if(err_msg!=null)
			addActionError(err_msg);
		err_msg="";
		ActionContext.getContext().getSession().put("error_msgs",err_msg );
		return SUCCESS;
	}
	
	public String display() {
		err_msg=(String)ActionContext.getContext().getSession().get("error_msgs");
		if(err_msg!=null)
			addActionError(err_msg);
		err_msg="";
		ActionContext.getContext().getSession().put("error_msgs",err_msg );
		return NONE;
	}
	
}