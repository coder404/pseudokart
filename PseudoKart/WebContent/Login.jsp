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
<script language="javascript">
	function hide(){
		if(document.forms[1].disabled==false)
			document.forms[1].disabled==true;
		else
			document.forms[1].disabled==false;
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<s:form>
		<table>
	        <tr><td><h2>Login</h2></td></tr>
	        <tr><td><s:textfield name="Username" key="Username" size="20"
					label="Email Address" /></td></tr>
	        <tr><td><s:password name="Password" key="Password" size="20"
						label="Password" /></td></tr>
	        <tr><td><s:submit class="btn-primary btn-large" method="execute" value="LOGIN"/></td>
	        	<td><s:a href="" class="forgotPwd" onclick="hide()">Forgot your password?</s:a></td>
	        </tr>
		</table>
	</s:form>
	<s:form>
		<table>
	      	<tr><td><h3>Forgot your Password?</h3></td></tr>
	      	<tr><td>Enter your Email Address here to receive a link to change password.</td></tr>
	      	<tr><td><s:textfield name="Username" key="Username" label="Email Address"/></td></tr>
	      	<tr><td><s:submit class="btn-primary btn-large" method="execute" value="Send Email"/></td></tr>
	      	<tr><td>Don't have an account? <s:a href="">Sign Up</s:a></td></tr>
		</table>
	</s:form>
</body>
</html>