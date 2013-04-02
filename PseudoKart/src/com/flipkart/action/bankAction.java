package com.flipkart.action;

import com.flipkart.model.Customer;
import com.flipkart.model.Order;
import com.flipkart.model.bankAccount;
import com.opensymphony.xwork2.ActionContext;
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
	private String cardNo;
	private double totalAmount;
	
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
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
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
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
	
	
public void validate(){
		
	String cardNumber = cardNo1 + cardNo2 + cardNo3 + cardNo4;
	
	if(cardNo1.length()!=4 || cardNo2.length()!=4 || cardNo3.length()!=4 || cardNo4.length()!=4)
		addFieldError( "cardNo", "Enter valid card details" );
	
	String sql = "where cardNo = " + cardNumber;
	bankAccount account = bankAccount.findAccount(sql);
	
	if(account==null)
		addFieldError( "cardNo", "Enter valid card details" );
	
	else if (!(account.getPin().equals(ipin))){
		addFieldError( "cardNo", "Check the password entered" );
	}
	
	if(	month==null || year==null){
		addFieldError( "cardNo", "Check the expiry Date" );
	}
	
		
	}

	public String execute()
	{
		
		String cardNumber = cardNo1 + cardNo2 + cardNo3 + cardNo4;
		
		
		String sql = "where cardNo = " + cardNumber;
		
		bankAccount account = bankAccount.findAccount(sql);
/*validate : 
		- password
		- expiry date
		- 
	*/	
		//double amt = (Double)ActionContext.getContext().getSession().get("totalCartAmt");
		
		double amt = 5000 ;
		
		boolean isBal = bankAccount.checkBalance(amt,account.getBalance());
		
		if(isBal)
		{
			amt = account.getBalance() - amt;
			sql = amt + "where accountNo =  " + account.getAccountNo();
			bankAccount.updateBank(sql);
			Order.updatePaidStatus();
			Customer.cartAppendNoInc();
			return "success";
		}
		
		
		 return "error";
		
			
		
		
	}

}
