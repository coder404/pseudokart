package com.flipkart.action;

import java.util.ArrayList;
import java.util.Map;

import com.flipkart.model.Cart;
import com.flipkart.model.Order;
import com.flipkart.model.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class orderStatusAction extends ActionSupport{
	//orderdetails table
	private int orderId;
	private String orderNo;
	private String cartNo;//same as cart append number
	private String email;
	private String orderstatus;
	private String paidstatus;
	
	//cart table
	private int cartId;
	private String productId;
	private int quantity;
	private String cartAppendNo;
	
	//product table
	private String name;
	private Double price;
	private String description;
	
	Order order=new Order();
	ArrayList<Cart> cart=new ArrayList<Cart>();
	Product product =new Product();
	ArrayList<Product> products=new ArrayList<Product>();
	ArrayList<Order> orders=new ArrayList<Order>();
	ArrayList<Cart> carts=new ArrayList<Cart>();
	
	Map session=ActionContext.getContext().getSession();
	
	public String execute(){
		email=(String)session.get("email");
		String mod = "where orderNo='" + orderNo + "'" + "and email='" + email + "'" + "and paidstatus='Y'";
		order=Order.findOne(mod);
		if(order==null){
			return "error";
		}
		
		String mod1="where cartId='" + order.getCartNo() + "'" + "and email='" + email + "'";
		cart=Cart.findAll(mod1);
		
		for(int i=0;i<cart.size();i++){
			String mod2="where productId='" + cart.get(i).getProductId() + "'";
			Product product1=new Product();
			product1=Product.findProduct(mod2);
			products.add(product1);
		}
		
	/*	for(int i=0;i<products.size();i++){
			System.out.println(products.get(i).getName());
			System.out.println(products.get(i).getPrice());
			System.out.println(products.get(i).getDescription());
		}
	*/	return SUCCESS;
	}
	
	public String viewAllOrders(){
		email=(String)session.get("email");
		String mod = "where email='" + email +"'" ;
		orders=Order.findAll(mod);
		if(orders==null){
			return "error";
		}
		
		for(int i=0;i<orders.size();i++){
			String mod1="where cartId='" + orders.get(i).getCartNo() + "'" + "and email='" + email + "'";
			cart=Cart.findAll(mod1);
			for(int j=0;j<cart.size();j++){
				carts.add(cart.get(j));
			}
		}
		
		for(int i=0;i<carts.size();i++){
			String mod2="where productId='" + carts.get(i).getProductId() + "'";
			Product product1=new Product();
			product1=Product.findProduct(mod2);
			products.add(product1);
		}
	
		
		return SUCCESS;
		
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCartNo() {
		return cartNo;
	}

	public void setCartNo(String cartNo) {
		this.cartNo = cartNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getPaidstatus() {
		return paidstatus;
	}

	public void setPaidstatus(String paidstatus) {
		this.paidstatus = paidstatus;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCartAppendNo() {
		return cartAppendNo;
	}

	public void setCartAppendNo(String cartAppendNo) {
		this.cartAppendNo = cartAppendNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ArrayList<Cart> getCarts() {
		return carts;
	}

	public void setCarts(ArrayList<Cart> carts) {
		this.carts = carts;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ArrayList<Cart> getCart() {
		return cart;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void setCart(ArrayList<Cart> cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
