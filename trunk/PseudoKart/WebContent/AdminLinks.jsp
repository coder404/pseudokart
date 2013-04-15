<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<br/><br/><br/>
<div class="alert alert-success" align="center">
<table class="table table-striped">
<tr>
<td><img src="./images/glyph1.png"/></td>
<td><a href="select_categ">Check Stock</a></td>
</tr>
<tr>
<td><img src="./images/glyph1.png"/></td>
<td><a href="report_out_stock">Report Out of Stock</a></td>
</tr>
<tr>
<td><img src="./images/glyph1.png"/></td>
<td><a href="">Add New category</a></td>
</tr>
<tr>
<td><img src="./images/glyph1.png"/></td>
<td><a href="">Add New Product</a></td>
</tr>
<s:property value="email"/>

<tr>
<td><img src="./images/glyph1.png"/></td>
<td><a href="update_link">Update Stock</a></td>
</tr>
</table>
</div>
</body>
</html>