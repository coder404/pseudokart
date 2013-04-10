<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="alert alert-info">
     <s:form action="update_stock">
		<table class="table table-striped">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Stock Quantity</th>
				<th></th>
			</tr>
			<s:iterator value="list">
				<tr>
					<td><s:property value="prodid" /></td>
					<td><s:property value="name" /></td>
					<td><input type="text" name="stock_quantity" 
					size="11" /></td>
					
				</tr>
			</s:iterator>
			<tr><td><s:submit cssClass="btn" value="Update Stock" cssStyle="background : #900 ;color : white" /></td></tr>
		</table>
		</s:form>
	</div>
</body>
</html>