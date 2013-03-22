package com.flipkart.action;

import com.opensymphony.xwork2.ActionSupport;

public class bankAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cardChosen;
	private String cardNo1;
	private String cardNo2;
	private String cardNo3;
	private String cardNo4;
	private String month;
	private String year;
	private String ipin;
	public String getCardChosen() {
		return cardChosen;
	}
	public void setCardChosen(String cardChosen) {
		this.cardChosen = cardChosen;
	}
	public String getCardNo1() {
		return cardNo1;
	}
	public void setCardNo1(String cardNo1) {
		this.cardNo1 = cardNo1;
	}
	public String getCardNo2() {
		return cardNo2;
	}
	public void setCardNo2(String cardNo2) {
		this.cardNo2 = cardNo2;
	}
	public String getCardNo3() {
		return cardNo3;
	}
	public void setCardNo3(String cardNo3) {
		this.cardNo3 = cardNo3;
	}
	public String getCardNo4() {
		return cardNo4;
	}
	public void setCardNo4(String cardNo4) {
		this.cardNo4 = cardNo4;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getIpin() {
		return ipin;
	}
	public void setIpin(String ipin) {
		this.ipin = ipin;
	}
	public String execute()
	{
		
		System.out.println("bank");
		System.out.println(cardChosen + " " + cardNo1 + " " + cardNo2 + " " + cardNo1 + " " + cardNo1 + " " + month + " " + year + " "+ ipin);
		return "success";
	}

}
