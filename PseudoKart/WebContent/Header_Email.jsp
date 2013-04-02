<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<div align="justify">
<table bgcolor="#005575">
<tr height="30">

<td colspan="2"><img src="./images/logo.jpg" width="170"/></td>
<td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/>
<td><a href="#"><font color="white" size="3px">24x7 Customer Support  -  </font></a></td>
<td><a href="#"><font color="white" size="3px">&nbsp;Contact Us</font></a></td>
<td><div style="width: 1px; height: 11px; background-color: white; float: left;"></div></td>
<td><a href="#"><font color="white" size="3px">&nbsp;&nbsp;Home</font></a></td>
<td><div style="width: 1px; height: 11px; background-color: white; float: left;"></div></td>
<td><a href="account"><font color="white" size="3px">&nbsp;&nbsp;Account</font></a></td>
<td><div style="width: 1px; height: 11px; background-color: white; float: left;"></div></td>
<td><a href="#"><font color="white" size="3px">&nbsp;&nbsp;Wishlist</font></a></td>
<td><div style="width: 1px; height: 11px; background-color: white; float: left;"></div></td>
<%@ page import="com.opensymphony.xwork2.ActionContext,com.flipkart.action.loginAction"%>
<td><a href="#"><font color="white" size="3px">&nbsp;&nbsp;<%=ActionContext.getContext().getSession().get("email") %></font></a></td>


</tr>
</table>
</div>
</body>

</html>