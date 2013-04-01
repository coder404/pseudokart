<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<title>Flipkart.com: Account Settings</title>
<link rel="shortcut icon" href="/images/flipkart-mini-logo.ico"/>
<link rel="icon" type="image/ico" href="/images/flipkart-mini-logo.ico">
</head>
<body>
<div class="container">
	<s:form action="newUserRegistration" validate="true">
		<table>
		<s:actionerror/>
	        <tr><td><h3>Sign up for FREE!</h3></td></tr>
	        <tr><td>All fields are mandatory.</td></tr>
	        <tr><td><s:textfield name="email" size="20" label="Email Address"/></td></tr>
	        <tr><td><s:password name="password" size="20" label="Password"/></td></tr>
	        <tr><td><s:password name="repeatPassword" size="20" label="Repeat Password"/></td></tr>
	        <tr><td><button class="btn-primary btn-success btn-large">SIGN UP NOW!</button></td></tr>
	        <tr><td>Already have an account? <a href="Login.jsp" id="" onclick="">Login Here</a>.</td></tr>
		</table>
	</s:form>
</div>
</body>
</html>