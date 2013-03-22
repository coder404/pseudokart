package com.flipkart.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class gatewayAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> yearList = new ArrayList<Integer>();
	public ArrayList<Integer> getYearList() {
		return yearList;
	}
	public void setYearList(ArrayList<Integer> yearList) {
		this.yearList = yearList;
	}
	public String execute()
	
	{
		System.out.println("In action");
		Calendar cal = Calendar.getInstance();
	
	
		for(int i=2013; i< 2040;i++ )
		{
			yearList.add(i);
		}
		   
		   
		
		return "success";
	}
}