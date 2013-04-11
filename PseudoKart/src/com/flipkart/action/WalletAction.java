package com.flipkart.action;

import com.flipkart.model.Customer;
import com.flipkart.model.Wallet;
import com.opensymphony.xwork2.ActionContext;

public class WalletAction {
	double balance=0;
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String onClickWallet()
	{
		String uemail;
		uemail=(String)ActionContext.getContext().getSession().get("email");
		int cust=Customer.getCustId(uemail);
	
	
			balance=Wallet.getWalletBalance(cust);
			//this.setBalance(balance);
			
		
		ActionContext.getContext().getSession().put("wallet_bal", balance);
		return "success";
		
	}

}
