<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-modal.js"></script>
<script type="text/javascript" src="./ViewResources/js/Remove_synch.js"></script>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<title>Insert title here</title>
<%@ page import="com.flipkart.action.*"%>
<%@ page import="com.flipkart.model.*"%>
<%@page import="java.util.*" %>
</head>
<body>
<% String Qty=request.getParameter("yourQuantity");
System.out.println("Quantity check"+Qty);
int yourQty=Integer.parseInt(Qty);
System.out.println("hgdsjhgkdhg"+yourQty);
String yourItem=request.getParameter("yourItem");
String proId=Product.getProductID(yourItem);
String appendNo=(String)ActionContext.getContext().getSession().get("cartAppendNo");
String mail=(String)ActionContext.getContext().getSession().get("email");
Cart.updateQuantity(mail, appendNo, proId, yourQty);
ArrayList<Cart> Cart_View =new ArrayList<Cart>();
CartAction_ViewCart obj=new CartAction_ViewCart();
Cart_View=obj.onClickCart((String)ActionContext.getContext().getSession().get("email"));

ActionContext.getContext().getSession().put("CartView_Update",Cart_View);
%>
 
  
  
  
   <div class="alert">
 
  <p align="center"><strong> The Quantity of the Item is updated Successfully</strong></p>
</div>
 
   <table class="table table-striped"> 
   
<tr>
								
								<th>Item Description</th>
								<th>&nbsp;&nbsp;&nbsp;</th>
								<th>Delivery Time</th>
								<th>&nbsp;&nbsp;&nbsp;</th>
								<th>Price</th>
								<th>&nbsp;&nbsp;&nbsp;</th>
								<th>Quantity</th>
								<th>&nbsp;&nbsp;&nbsp;</th>
								<th>Subtotal</th>
								<th>&nbsp;&nbsp;&nbsp;</th>
								<th></th>
								
							</tr>
						
							<s:iterator value="#session.CartView_Update">
						
					<tr>
					<td><s:property value="ItemDesc"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><s:property value="DeliveryTime"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><s:property value="price"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
				<td><div id="<s:property value="ItemDesc"/>"><s:property value="quantity" /><br /><a href="#" onclick="return foo('<s:property value="quantity" />','<s:property value="ItemDesc"/>');">Change</a></div></td>
				<!--  	<td><a href="Change_quantity">Change</a>-->
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><s:property value="subtotal"/></td>
					
					<td><a href="#" onclick="return removeItem('<s:property value="ItemDesc"/>');"> X </a></td>
					</tr>
					</s:iterator>
						</table>
					<table>
							<tr>

								<th>Amount Payable :  </th>
							 	<th><s:property value="#session.totalCartAmt"/></th>
							</tr>
							<tr>
							 <td><s:property value="%{amount}"/></td></tr>
							
							
						
						</table>
						<br/><br/>
						
						
 
  
 


</body>
</html>