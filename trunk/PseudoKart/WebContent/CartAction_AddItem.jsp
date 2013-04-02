<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>

<title>Place Order</title>
<sb:head/>
</head>
<body>

<ul class="breadcrumb">
  <li><a href="#">Home</a> <span class="divider">/</span></li>
  <li><a href="#">My Account</a> <span class="divider">/</span></li>
  <li class="active">Shopping Cart</li>
</ul>

	<div class="tabbable">
		<div class="container-fluid">
		<ul class="breadcrumb">
			<ul class="nav nav-tabs" id="myTab">
			<li ><img src="./images/glyphicons_202_shopping_cart.png"/></li>
				<li class="active"><a data-toggle="tab" href="#Cart">Cart</a></li>
				<li><a href="#DigitalCart" data-toggle="tab">Digital Cart</a></li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				
				
			</ul>
</ul>
			<div id="Cart" class="tab-content">

				<div id="" class="tab-pane active in">
					<s:form id="tab1"></s:form>
				</div>

				<div id="DigitalCart" class="tab-pane">



					<s:actionerror theme="bootstrap" />
					<s:actionmessage theme="bootstrap" />
					<s:fielderror theme="bootstrap" />
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
					<s:iterator value="CartItems">
					<tr>
					<td><s:property value="ItemDesc"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><s:property value="DeliveryTime"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><s:property value="subtotal"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><s:property value="quantity"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><s:property value="subtotal"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					</tr>
					</s:iterator>
						</table>
					<table>
							<tr>

								<th>Amount Payable :  </th>
								<th><s:property value="#session.totalCartAmt"/></th>
							</tr>
							<%-- <s:iterator value="amount"> --%>
							<tr>
							<td><s:property value="#session.Payable_Amt"/></td></tr>
							<%-- </s:iterator> --%>
							
						</table>
						<br/><br/>
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
						<td><s:submit cssClass="btn  btn-warning"  value="Place Order" action="orderEntry_PlaceOrder"/>
						</td></tr>
						</table>
						</s:form>
						
					</div>
					</div>
					</div>
					</body>
					</html>