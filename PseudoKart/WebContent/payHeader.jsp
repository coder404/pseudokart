<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">

#customdiv{
  
  background-color:#005575 ;
  height: 50;
}


</style>
</head>
<body>
<%@page import="com.opensymphony.xwork2.ActionContext"%>

<div id="customdiv" align="justify" >
 <img src="./images/logo.jpg" height="30" width="100" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="white"><strong>Secure Payment</strong></font>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="white"><strong>Hi,<%=(String)ActionContext.getContext().getSession().get("email") %></strong></font>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout"><font color="white"><strong>Logout</strong></font></a>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>

</body>

</html>
