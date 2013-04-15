package com.flipkart.action;

import java.util.ArrayList;



import com.flipkart.DAO.ProductSelection;
import com.flipkart.DAO.RetrieveCategories;
import com.flipkart.model.Category;
import com.flipkart.model.Product;
import com.flipkart.model.Range;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FilterProductsAction extends ActionSupport{
	
	private String categoryname;
	ArrayList<Category> categories_list = new ArrayList<Category>();
	ArrayList<Range> filterranges = new ArrayList<Range>();
	/**
	 * 
	 */
	/**
	 * 
	 */
	String ranges[];
	ArrayList<Product> products_filtered = new ArrayList<Product>();

	public ArrayList<Product> getProducts_filtered() {
		return products_filtered;
	}

	public void setProducts_filtered(ArrayList<Product> products_filtered) {
		this.products_filtered = products_filtered;
	}

	public String[] getRanges() {
		return ranges;
	}

	public void setRanges(String[] ranges) {
		this.ranges = ranges;
	}

	public ArrayList<Range> getFilterranges() {
		return filterranges;
	}

	public void setFilterranges(ArrayList<Range> filterranges) {
		this.filterranges = filterranges;
	}

	public ArrayList<Category> getCategories_list() {
		return categories_list;
	}

	public void setCategories_list(ArrayList<Category> categories_list) {
		this.categories_list = categories_list;
	}
	
	public String getCategoryname() {
		return categoryname;
	}


	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}


	public String execute()
	{
		
		categories_list = RetrieveCategories.getCategories();
		System.out.println("****************8"+categoryname);
		this.setCategories_list(categories_list);
		
		products_filtered=ProductSelection.getAllProducts(categoryname);
		ActionContext.getContext().getSession().put("Products_filtered", products_filtered);  
		this.setProducts_filtered(products_filtered);
		this.setFilterranges(Range.getRanges());
		
		return "success";
	}

	public String getFilterProducts()
	{
		System.out.println("****************8"+categoryname);
		String selection="where name='"+categoryname+"';";
		Category c=Category.findCategory(selection);
		String categoryID=c.getCategoryID();
		String selectionModifier="where categoryID IN (select categoryID from category where parentCatID='"+categoryID+"') and ("; 
		
		String selectionModifier1;
		
	for(int i=0;i<ranges.length;i++)
	{
		
		if(ranges[i].equals("1"))
			selectionModifier+="price <= 1000 or ";
	
		if(ranges[i].equals("2"))
			selectionModifier+="price between 1000 and 5000 or ";
		
		if(ranges[i].equals("3"))
			selectionModifier+="price between 5000 and 10000 or ";

		if(ranges[i].equals("4"))
			selectionModifier+="price >= 10000 or ";

	
	}
	selectionModifier.trim();
	selectionModifier1=selectionModifier.substring(0, selectionModifier.length()-4);
	System.out.println(selectionModifier);
	System.out.println(selectionModifier1);
	selectionModifier1+=")";
	System.out.println(selectionModifier1);
	products_filtered=Product.findAll(selectionModifier1);
	return "success";
	}
	
}
