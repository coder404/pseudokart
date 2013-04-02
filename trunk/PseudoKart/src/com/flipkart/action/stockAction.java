package com.flipkart.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.flipkart.model.Product;
import com.flipkart.model.Stock;
import com.flipkart.model.stock_prod;

public class stockAction extends ActionSupport{

	ArrayList<Product> list;
	ArrayList<Product> selectedProds=new ArrayList<Product>();
	ArrayList<Stock> stock_list=new ArrayList<Stock>();
	ArrayList<stock_prod> fin=new ArrayList<stock_prod>(); 
	String[] productID;
	
	public String execute()
	{
		list=Product.findAll("");
		return SUCCESS;
	}
	
	public String back()
	{
		System.out.println("Retrurning....");
		return "back";
	}
	
	public String getProdStock()
	{
		for(int i=0;i<productID.length;i++)
		{
		         Stock s=Stock.findOne("where stockProductID='"+productID[i]+"'");
		         Product p=Product.findProduct("where productID='"+productID[i]+"'");
		         if(s!=null && p!=null)
		        	 {
		        	   stock_prod obj=new stock_prod();
		        	   obj.setProdID(p.getProdid());
		        	   obj.setQuantity(s.getQuantity());
		        	   obj.setProdName(p.getName());
		        	   fin.add(obj);
		        	 }
		}
		//System.out.println("*****Stock List*****"+stock_list.size());
		
		
		return "ok";
	}
	
	public ArrayList<Product> getList() {
		return list;
	}
	public void setList(ArrayList<Product> list) {
		this.list = list;
	}
	public String[] getProductID() {
		return productID;
	}
	public void setProductID(String[] productID) {
		this.productID = productID;
	}

	public ArrayList<Stock> getStock_list() {
		return stock_list;
	}

	public void setStock_list(ArrayList<Stock> stock_list) {
		this.stock_list = stock_list;
	}

	public ArrayList<Product> getSelectedProds() {
		return selectedProds;
	}

	public void setSelectedProds(ArrayList<Product> selectedProds) {
		this.selectedProds = selectedProds;
	}

	public ArrayList<stock_prod> getFin() {
		return fin;
	}

	public void setFin(ArrayList<stock_prod> fin) {
		this.fin = fin;
	}
	
}
