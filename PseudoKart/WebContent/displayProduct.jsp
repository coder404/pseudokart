<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="s" uri="/struts-tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-modal.js"></script>
<script type="text/javascript" src="./ViewResources/js/Remove_synch.js"></script>
<title>Insert title here</title>
<%@page
	import="java.sql.*,java.util.ArrayList,com.flipkart.model.*,com.flipkart.action.*,com.opensymphony.xwork2.*"%>
<script>
	function showRating() {
		System.out.println("In show rating");
		var radioButtons = document.getElementsByName("rating");
		float Prodrating = (Float)ActionContext.getContext().getSession().get("productID");

		System.out.println("rating :" + Prodrating);
		radioButtons[Prodrating].checked = true;

	};
</script>


</head>
<body onload="showRating()">
	<s:form action="addToCart.action">
	<s:hidden name="productId" value="%{product.prodid}"/>
	

		<table>
			<tr>
				<td><b><s:property value="product.name" /></b></td>
			</tr>
			<tr>
				<td>Ratings : <s:property value="%{product_rating}" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
		</table>
		<hr>
		<table>
			<!-- <tr>
<td><div class="rating" id="rate">

		<input type="radio" id="star5" name="rating" value="5" /><label
			for="star5" title="Rate this 5 star out of 5">5 stars</label> <input
			type="radio" id="star4" name="rating" value="4" /><label for="star4"
			title="Rate this 4 star out of 5">4 stars</label> <input type="radio"
			id="star3" name="rating" value="3" /><label for="star3"
			title="Rate this 3 star out of 5">3 stars</label> <input type="radio"
			id="star2" name="rating" value="2" /><label for="star2"
			title="Rate this 2 star out of 5">2 stars</label> <input type="radio"
			id="star1" name="rating" value="1" /><label for="star1"
			title="Rate this 1 star out of 5">1 star</label>
	</div></td>

</tr> -->
			<br>

			<tr>
				<td><s:property value="product.description" /></td>
			</tr>
		</table>
		<hr>
		<br>
		<s:if test="inStock">
		<table>
			<tr>
				<td><b style="color: red">Rs.<s:property
							value="product.price" /></b></td>
				<td style="color: green">In Stock</td>
			</tr>

			<tr>
				<td>Inclusive of taxes</td>
			</tr>
			<tr>
				<td>(Free Home Delivery)</td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			
			<tr>
				<!--  <td><button type="submit"
						style="font-size: 20px; width: 200px; background-color: #FFA500; color: white">Buy
						This Now</button></td>-->
						
	<td><a href="#buyProduct" role="button" class="btn btn-warning" data-toggle="modal">Buy This Now</a></td> 

			</tr>
			<tr>
				<td>30 DAY REPLACEMENT GUARANTEE</td>
			</tr>
		</table>
		</s:if>
		<s:else>
		<table>
		<tr>
		<td><b style="color: red">Rs.<s:property
							value="product.price" /></b></td>
		<td style="color: black">Out of Stock</td>
			</tr>

			<tr>
				<td>Inclusive of taxes</td>
			</tr>
			<tr>
				<td>(Free Home Delivery)</td>
			</tr>
			
			<tr>
						<td>Notify me when this product is in stock:</td>
					</tr>
					<tr></tr>

					<tr>
						<td><s:textfield key="emailid" name="emailid" size="20"
								label="Email Id">
							</s:textfield></td>
						<td><s:submit type="button" value="notifyMe"
								action="notifyMe" name="buttonName" label="Notify Me" cssStyle="border-radius:0; border:1px solid #1A356E ;background : #5B74A8 ;color : white"/></td>
					</tr>
		
		</table>
		</s:else>
	</s:form>
	<%@ page import="com.flipkart.action.CartAction_AddItem"%>
<%@ page import="java.util.*" %>
<%@ page import="com.opensymphony.xwork2.ActionContext,com.flipkart.model.*"%>
<% System.out.println("***********"+(String)ActionContext.getContext().getSession().get("email"));
if((String)ActionContext.getContext().getSession().get("email")==null){ %>
<div id="buyProduct" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel"></h3>
  </div>
  <div class="modal-body">
    <p>Please login to your Flipkart account to add this item to your cart.</p>
  </div>
  <div class="modal-footer">
 <s:form>   <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
 <s:submit cssClass="btn  btn-primary" align="center" action="loginPage" value="Login" /></s:form>
  </div>
</div>
<%} %>

<% ArrayList<Cart> CartList=new ArrayList<Cart>();
CartAction_AddItem obj=new CartAction_AddItem();
CartList=obj.onClickBuy((String)ActionContext.getContext().getSession().get("email"));
ActionContext.getContext().getSession().put("Cart_List",CartList);
if((String)ActionContext.getContext().getSession().get("prod_status")=="found"){ %>
<div id="buyProduct" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			 <div class="modal-header">		
  
			<ul class="nav nav-tabs" id="myTab">
			<li ><img src="./images/glyphicons_202_shopping_cart.png"/></li>
				<li class="active"><a data-toggle="tab" href="#ViewCart">Cart</a></li>
				
   <li> <button type="button" class="close" data-dismiss="modal" aria-hidden="true" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;x </button></li>
   </ul>
   
  
  <!--    <h3 id="myModalLabel">Modal header</h3> -->
 
   </div>
  <div class="modal-body" id="res">
  <div class="alert">
 
  <p align="center"><strong> This Item is already in your Cart !</strong></p>
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
							
							<s:iterator value="#session.Cart_List">
					<tr>
					<td><s:property value="ItemDesc"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><s:property value="DeliveryTime"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><s:property value="price"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><div id="<s:property value="ItemDesc"/>"><s:property value="quantity" /><br /><a href="#" onclick="return foo('<s:property value="quantity" />','<s:property value="ItemDesc"/>');">Change</a></div></td>
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
  </div>
  <div class="modal-footer">
  
  <s:form theme="simple">
<table>
						<tr>
						<td><s:submit cssClass="btn  btn-primary" action="home_after_login" value="Continue Shopping"/>
						</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						
						<td><s:submit cssClass="btn  btn-warning"  value="Place Order" action="orderEntry_PlaceOrder"/>
						</td></tr>
						</table>
						</s:form>
   
  </div>


 

</div>
<%} %>


<%if((String)ActionContext.getContext().getSession().get("prod_status")=="notfound"){ %>
<div id="buyProduct" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-header">		

<ul class="nav nav-tabs" id="myTab">
<li ><img src="./images/glyphicons_202_shopping_cart.png"/></li>
	<li class="active"><a data-toggle="tab" href="#ViewCart">Cart</a></li>
	
<li> <button type="button" class="close" data-dismiss="modal" aria-hidden="true" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;x </button></li>
</ul>


<!--    <h3 id="myModalLabel">Modal header</h3> -->

</div>


<div class="modal-body" id="res" >
<div class="alert">

<p align="center"><strong> This Item has been successfully added to your Cart !</strong></p>
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
				
				<s:iterator value="#session.Cart_List">
		<tr>
		<td><s:property value="ItemDesc"/></td>
		<td>&nbsp;&nbsp;&nbsp;</td>
		<td><s:property value="DeliveryTime"/></td>
		<td>&nbsp;&nbsp;&nbsp;</td>
		<td><s:property value="price"/></td>
		<td>&nbsp;&nbsp;&nbsp;</td>
		<td><div id="<s:property value="ItemDesc"/>"><s:property value="quantity" /><br /><a href="#" onclick="return foo('<s:property value="quantity" />','<s:property value="ItemDesc"/>');">Change</a></div></td>
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
</div>
<div class="modal-footer">

<s:form theme="simple">
<table>
			<tr>
			<td><s:submit cssClass="btn  btn-primary" action="home_after_login" value="Continue Shopping"/>
			</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			
			<td><s:submit cssClass="btn  btn-warning"  value="Place Order" action="orderEntry_PlaceOrder"/>
			</td></tr>
			</table>
			</s:form>

</div>




</div>
<%} %>
 









</body>
</html>