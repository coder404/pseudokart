<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>

<title>Place Order</title>
<sb:head/>
</head>
<body>
<p align="left"><h3>Welcome to your Wallet!</h3>
The Wallet is a pre-paid credit instrument which is associated with your Flipkart.com account.<br />
You can now maintain a balance of money with Flipkart.com and redeem it as you choose.</p><br />
<h4>Flipkart Wallet</h4>
  <div class="alert alert-info"  >
  <%@page import="java.util.*" %>
  <%@page import="com.opensymphony.xwork2.ActionContext"%>
 <h4 align="justify">Top-Up</h4><br />
 <p>Balance : Rs. <%=ActionContext.getContext().getSession().get("wallet_bal")%></p>
 <p>Want to Top-Up?<br />
 Enter an Amount to Top-up</p>
  <s:form class="form-search">
  <p>Rs.<input type="text" class="input-medium search-query" name="topupamt">
  <s:submit cssClass="btn  btn-warning"  value="Top-up" action="orderEntry_PlaceOrder"/></p>

</s:form>

  <p>
       
  </p>
</div>
<h5 >How do I get Started?</h5>
<p><span class="badge badge-info">1</span> Fill your Wallet by any amount you desire by making a payment once.<br /><br />
<span class="badge badge-info">2</span> This amount will be added as pre-paid balance in the Wallet associated with your account.<br /><br />
<span class="badge badge-info">3</span> Use this Flyte balance to make multiple purchases of MP3s and eBooks</p></body>
</body>
</html>