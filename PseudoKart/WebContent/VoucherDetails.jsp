<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Gift Vouchers: Buy e-Gift Voucher Online in India | Flipkart.com</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<style type="text/css"> 
#voucherDetails
{
	background-color:#F2F2F2;
}
#field1,#field2,#field3,#field4
{
	border:none;
	text-align: left;
	font-size:large;
	font-style:bold;
	margin-left: 20px;
	background-color: #F2F2F2;
}
</style>
</head>
<body>
<div class="container" id="voucherDetails">
	<ul class="nav nav-tabs">
				<li>
					<a href="BuyVoucher.jsp">Buy a Flipkart e-Gift Voucher</a>
				</li>
				<li class="active">
					<a href="#">Check Balance</a>
				</li>
				<li>
					<a href="#">Frequently Asked Questions</a>
				</li>
			</ul>
			<div class="container-fluid">
			<div class="span 10">
			<h3>Voucher Details</h3>
			<table>
				<tr>
					<td>
						<s:textfield name="field1" value="%{voucherNumber}" label="Voucher Number" readonly="true"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="field2" value="%{balance}" label="Balance" readonly="true"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="field3" value="%{purchase_Date}" label="Purchased On" readonly="true"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="field4" value="%{purchaser_Email}" label="Purchased By (Email)" readonly="true"></s:textfield>
					</td>
				</tr>
			</table>	
			</div>
			<div class="span2">
			</div>
			<div class="span3">
				<img src="images/egv.png"/>
			</div>
		</div>
</div>
</body>
</html>