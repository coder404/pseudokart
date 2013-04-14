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
<br/><br/>
	<div class="alert alert-error">
     <s:form action="getstock" theme="bootstrap" cssClass="form-horizontal"
						label="Products List" >
		<table class="table table-striped">
			<tr>
				<th></th>
				<th>Product ID</th>
				<th>Product Name</th>
			</tr>
			<s:iterator value="list">
				<tr>
					<td><s:checkbox name="productID" fieldValue="%{prodid}"
							value="%{prodid in productID}" theme="simple" /></td>
					<td><s:property value="prodid" /></td>
					<td><s:property value="name" /></td>
				</tr>
			</s:iterator>
		</table>
		<s:submit cssClass="btn btn-primary" value="Check Stock"	align="center"></s:submit>
		
		</s:form>
	</div>


</body>
</html>