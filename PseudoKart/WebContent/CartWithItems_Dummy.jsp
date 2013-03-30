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



	<div class="tabbable">
		<div class="container-fluid">
		<ul class="breadcrumb">
			<ul class="nav nav-tabs" id="myTab">
			<li ><img src="glyphicons_202_shopping_cart.png"/></li>
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
				<li><img src="glyphicons_192_circle_remove.png" /></li>
				
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
						</table>
					<table>
							<tr>

								<th>Amount Payable</th>
							</tr>
						</table>
						<br/><br/>
						<button class="btn  btn-primary" type="button" >Close and Continue Shopping</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="btn  btn-warning" type="button" >Place Order</button>
					</div>
					</div>
					</div>
					</body>
					</html>