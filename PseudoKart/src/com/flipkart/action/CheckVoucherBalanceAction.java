package com.flipkart.action;

import java.util.ArrayList;

import com.flipkart.model.voucher;
import com.opensymphony.xwork2.ActionSupport;

public class CheckVoucherBalanceAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String voucherNumber;
	private String voucherPin;
	private String purchase_Date;
	private String purchaser_Email;
	private double balance;
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPurchase_Date() {
		return purchase_Date;
	}
	public void setPurchase_Date(String purchase_Date) {
		this.purchase_Date = purchase_Date;
	}
	public String getPurchaser_Email() {
		return purchaser_Email;
	}
	public void setPurchaser_Email(String purchaser_Email) {
		this.purchaser_Email = purchaser_Email;
	}
	public String getVoucherNumber() {
		return voucherNumber;
	}
	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
	}
	public String getVoucherPin() {
		return voucherPin;
	}
	public void setVoucherPin(String voucherPin) {
		this.voucherPin = voucherPin;
	}
	
	ArrayList<voucher> list = new ArrayList<voucher>();
	
	public String execute() {
		
		int flag = 0;
		
		list = voucher.findAll();
		
		String tmpVoucherNumber = "";
		String tmpVoucherPin = "";
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			tmpVoucherNumber = list.get(i).getVoucher_number().toString();
			tmpVoucherPin = list.get(i).getVoucher_pin().toString();
			
			System.out.println(tmpVoucherNumber + ", " + tmpVoucherPin);
			
			if (this.voucherNumber.equals(tmpVoucherNumber) && this.voucherPin.equals(tmpVoucherPin)) {
				System.out.println("Match");
				this.purchase_Date = list.get(i).getPurchase_Date().toString();
				this.purchaser_Email = list.get(i).getPurchaser_Email();
				this.balance = list.get(i).getBalance();
				flag = 1;
				break;
			}
		}
			
		if (flag == 1) {
			return "success";
		} else {
			//addActionError(getText("Incorrect user Number/Pin!"));
			return "error";
		}
	}
	
}
