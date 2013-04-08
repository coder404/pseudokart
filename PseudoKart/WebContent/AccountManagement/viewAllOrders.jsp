<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="./ViewResources/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>

<title>Order Status</title>
<sb:head />
<style type="text/css">
table
{
border-collapse:collapse;
}


.example1 {
	border: 1px solid #ddd;
	text-align: justify;
	text-justify: inter-word;
	backgroung:#C0C0C0;
	
}

</style>

</head>
<body>
	<div class="span10" align="left">
			<br/>
			<br/>
			
			<%-- <table class="example1">
			<tr>
			<td>Order ID:</td><td><s:label value="%{order.orderNo}" /></td>
			</tr>
			</table>
			<br/>
			<br/>
			 --%><table class="example1">
			<tr style="border: 1px solid black">
			<th style="border: 1px solid black">Order ID</th>
			<th style="border: 1px solid black">Item Name</th>
			<th style="border: 1px solid black">Item Description</th>
			<th style="border: 1px solid black">Order Status</th>
			<th style="border: 1px solid black">Price</th>
			<th style="border: 1px solid black">Quantity</th>
			</tr>
			<tr style="border: 1px solid black">
			<s:iterator value="orders">
				<td style="border: 1px solid black"><s:property value="orderNo"/></td>
			<s:iterator value="carts">
				<s:iterator value="products">
					<td style="border: 1px solid black"><s:property value="name"/></td>
					<td style="border: 1px solid black"><s:property value="description"/></td>
					<td style="border: 1px solid black"><s:property value="%{order.orderstatus}"/></td>
					<td style="border: 1px solid black"><s:property value="price"/></td>
					<td style="border: 1px solid black"><s:property value="quantity"/></td>
				</s:iterator>
			</s:iterator>
			</s:iterator>
			</tr>
			
			</table>
			
		</div>
</body>
</html>