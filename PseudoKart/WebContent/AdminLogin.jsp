<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Flipkart.com: Login</title>
<link rel="shortcut icon" href="/images/flipkart-mini-logo.ico"/>
<link rel="icon" type="image/ico" href="/images/flipkart-mini-logo.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script>window.history.forward(1);</script>
</head>
<body onload="javascript:history.go(1)">

	<s:actionerror theme="bootstrap"/>
						<s:fielderror/>
						<s:actionmessage/>
	<s:form action="adminLogin" theme="bootstrap" cssClass="form-horizontal"
						label="Admin Login" >

		<s:textfield name="email" label="E-mail" size="15"></s:textfield>
		<s:password name="passwd" label="Password" size="15"/>
		<s:submit cssClass="btn btn-primary" value="Login" align="center"></s:submit>
	</s:form>
	
		
</body>
</html>