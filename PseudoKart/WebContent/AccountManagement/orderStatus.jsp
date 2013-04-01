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
</head>
<body>
	<div class="span10" align="left">
		<div>
			<h3 style="margin-top: 50px">Order Status</h3>
		</div>
		<div>
			<h4>Check Order Status</h4>
		</div>
		<br/>
		<div>Now you can track the progress of your order right here!</div>
	
		<div>Enter your Order ID below and click "GO" to view details of
			your order.</div>
		<br/>
		<s:form action="" method="post">
			<table theme="simple">
				
				<tr>
					<td><s:textfield name="orderId" size="15"
							placeholder="Enter Your Order Id" theme="simple"
							cssClass="input-large" /></td>
					<td><s:submit name="commandButton" id="mysubmit" value="Go"
							cssClass="btn btn-small btn-primary" theme="simple" /></td>
				</tr>
			</table>

		</s:form>
	</div>
</body>
</html>