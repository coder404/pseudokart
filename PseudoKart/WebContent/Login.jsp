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
<script>
$(document).ready(function(){
  $("#forgotPwd").click(function(){
    $("#forgotPwdForm").slideToggle();
  });
});
</script>
</head>
<body>
<div class="container">
	<table>
			<tr><td><h3>Login</h3></td></tr>
	</table>
	<s:form action="login" validate="true">
		<table>
			<s:actionerror/>
	        <tr><td><s:textfield name="email" size="20" label="Email Address"/></td></tr>
	        <tr><td><s:password name="password" size="20" label="Password"/></td></tr>
	        <tr><td><button class="btn-primary btn-large">LOGIN</button></td>
	        	<td><div id="forgotPwd"><a href="">Forgot your password?</a></div></td>
	        </tr>
		</table>
	</s:form>
	<div class="container" id="forgotPwdForm">
		<table>
			<tr><td><h3>Forgot your Password?</h3></td></tr>
		   	<tr><td>Enter your Email Address here to receive a link to change password.</td></tr>
		</table>
		<s:form action="forgotPassword">
				<table>
			      	<tr><td><s:textfield name="emailForgotPwd" size="20" label="Email Address"/></td></tr>
			      	<tr><td><button class="btn-primary btn-large">Send Email</button></td></tr>
			      	<tr><td>Don't have an account? <a href="Signup.jsp">Sign Up</a></td></tr>
				</table>
		</s:form>
	</div>
</div>
</body>
</html>