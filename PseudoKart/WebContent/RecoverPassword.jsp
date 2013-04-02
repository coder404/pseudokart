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
<title>Flipkart.com: Password Recovery</title>
<link rel="shortcut icon" href="/images/flipkart-mini-logo.ico"/>
<link rel="icon" type="image/ico" href="/images/flipkart-mini-logo.ico">
</head>
<body>
<div class="container">
	<s:form action="changePassword" validate="true">
		<table>
		<s:actionerror/>
	        <tr><td><h3>Password Recovery</h3></td></tr>
	        <tr><td><s:textfield name="emailRecoverPwd" size="20" label="Email Address" disabled="true" key="%{email}"/></td></tr>
	        <tr><td><s:password name="newPassword" size="20" label="New Password"/></td></tr>
	        <tr><td><s:password name="retypeNewPassword" size="20" label="Retype New Password"/></td></tr>
	        <tr><td></td><td><button class="btn-primary">Change Password</button></td></tr>
		</table>
	</s:form>
</div>
</body>
</html>