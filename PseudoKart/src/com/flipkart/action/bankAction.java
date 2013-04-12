package com.flipkart.action;

import java.util.ArrayList;

import com.flipkart.model.Cart;
import com.flipkart.model.Customer;
import com.flipkart.model.Order;
import com.flipkart.model.Stock;
import com.flipkart.model.Wallet;
import com.flipkart.model.bankAccount;
import com.flipkart.model.voucher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class bankAction extends ActionSupport{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
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
	private bankAccount account;
	
	public bankAccount getAccount() {
		return account;
	}
	public void setAccount(bankAccount account) {
		this.account = account;
	}

	String topupamt=(String)ActionContext.getContext().getSession().get("topupamt");
	
	Cart voucher_obj=(Cart)ActionContext.getContext().getSession().get("vouchercart");
	
	double amt = (Double)ActionContext.getContext().getSession().get("totalCartAmt");
	
ArrayList<Cart> cartitems = (ArrayList<Cart>)ActionContext.getContext().getSession().get("finalcartitems");
	
	
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
		
		account = bankAccount.findAccount(sql);
/*validate : 
		- password
		- expiry date
		- 
	*/	
		
		
		
		//double amt = 5000 ;
		
		boolean isBal = bankAccount.checkBalance(amt,account.getBalance());
		
		if(isBal)
		{
			amt = account.getBalance() - amt;
			sql = amt + "where accountNo =  " + account.getAccountNo();
			bankAccount.updateBank(sql);
			
			if(topupamt==null && voucher_obj == null ){
			Order.updatePaidStatus();
			Customer.cartAppendNoInc();
			
			Stock.reduceQunatity(cartitems);

			}
			
			else if(topupamt != null)
			{
				 double bals;
				try {
					bals = Wallet.findCustExists();
					 if(bals<0)
						 Wallet.insert((String)ActionContext.getContext().getSession().get("email"), Double.parseDouble(topupamt));
					 else
						 Wallet.update((String)ActionContext.getContext().getSession().get("email"), Double.parseDouble(topupamt));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			else if(voucher_obj != null){
				
				 
				try {
					for(int i= 0 ; i< ((Integer)ActionContext.getContext().getSession().get("voucherqty")); i++)
					{
					     double bal=voucher_obj.getSubtotal();
						 voucher.insert(bal, (String)ActionContext.getContext().getSession().get("email") );
						 
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			account = bankAccount.findAccount(sql);
			return "success";
		}

		
		 return "error";
		
		
	}

}
