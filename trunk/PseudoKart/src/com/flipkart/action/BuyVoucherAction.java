package com.flipkart.action;

import com.flipkart.model.Cart;
import com.flipkart.model.voucher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BuyVoucherAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String email1;
	private String email2;
	private String toName;
	private String fromName;
	private String personalMessage;
	private String totalAmount;
	private String valueOfVoucher;
	private String numberOfVouchers;

	String uemail=(String)ActionContext.getContext().getSession().get("email");
	
	public String getValueOfVoucher() {
		return valueOfVoucher;
	}
	public void setValueOfVoucher(String valueOfVoucher) {
		this.valueOfVoucher = valueOfVoucher;
	}
	public String getNumberOfVouchers() {
		return numberOfVouchers;
	}
	public void setNumberOfVouchers(String numberOfVouchers) {
		this.numberOfVouchers = numberOfVouchers;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getPersonalMessage() {
		return personalMessage;
	}
	public void setPersonalMessage(String personalMessage) {
		this.personalMessage = personalMessage;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String execute() {
		System.out.println("Inside BVA");
		//Voucher.insert(totalAmount, "dd");
		
		Cart obj=new Cart();
		obj.setProductId("");
		obj.setDeliveryTime("");
		obj.setItemDesc("e-Gift Voucher Purchase");
		obj.setQuantity(Integer.parseInt(numberOfVouchers));
		obj.setSubtotal(Double.parseDouble(valueOfVoucher));
		ActionContext.getContext().getSession().put("vouchercart", obj);
		ActionContext.getContext().getSession().put("totalCartAmt", Double.parseDouble(totalAmount));
		ActionContext.getContext().getSession().put("cartAppendNo","-1");
		ActionContext.getContext().getSession().put("voucherqty", Integer.parseInt(numberOfVouchers));
		
		System.out.println("Done with BVA");
		return "success";
	}
}
