package com.flipkart.model;

import java.util.ArrayList;

public class Range {
	
	private int id;
	private String filter;
	
	
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	public static Range putFilter(int id,String val)
	{
		Range r=new Range();
		r.setId(id);
		r.setFilter(val);
		return r;
	}
  public static ArrayList<Range> getRanges()
  {
	  ArrayList<Range> list = new ArrayList<Range>();
	  list.add(putFilter(1,"below 1000"));
	  list.add(putFilter(2,"1000-5000"));
	  list.add(putFilter(3,"5000-10000"));
	  list.add(putFilter(4,"above 10000"));
	  
	  return list;  
  }
}
