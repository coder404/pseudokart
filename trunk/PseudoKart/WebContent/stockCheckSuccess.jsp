<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
</head>
<body>
	<div class="alert alert-info">
     <s:form action="returnAdmin">
		<table class="table table-striped">
			<tr>
				
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Stock Quantity</th>
			</tr>
			<s:iterator value="fin">
				<tr>
					<td><s:property value="prodID" /></td>
					<td><s:property value="prodName" /></td>
					<td><s:property value="quantity" /></td>
				</tr>
			</s:iterator>
		</table>
		<s:submit cssClass="btn btn-primary" value="Back"	align="center"></s:submit>
		</s:form>
	</div>


</body>
</html>