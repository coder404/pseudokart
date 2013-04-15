<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="./ViewResources/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<script>window.history.forward(1);</script>
</head>
<body onload="javascript:history.go(1)">

<h4>Payment successful!!!</h4>
<br>
<h4>
Bank Account Details
</h4>
<table>

<tr>
<td>
Card no : 
</td>
<td>
<s:property value="account.cardNo"/>

</td>
</tr>
<tr>
<td>

Balance:
</td>
<td>
<s:property value="account.balance"/>
</td>
</tr>


</table>





</body>
</html>