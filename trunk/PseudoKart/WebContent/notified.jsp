<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-modal.js"></script>
<script type="text/javascript" src="./ViewResources/js/Remove_synch.js"></script>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<title>Insert title here</title>
<%@ page import="com.flipkart.action.*"%>
<%@ page import="com.flipkart.model.*"%>
<%@page import="java.util.*" %>
</head>
<body>
<% 
String emailid=request.getParameter("email");
String prodid=request.getParameter("product");
System.out.println("Inside notify Me");
String sql = "'" + emailid + "','" + prodid + "'";
Stock.insertNotifyMe(sql);
System.out.println(prodid + " " + emailid);
%>
<p>
Thank you for your interest in this Item.
You will be Notified by Email when it becomes available.
</p>
					
</body>
</html>