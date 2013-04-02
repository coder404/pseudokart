<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>

<title>Account Management</title>
<sb:head />
<style type="text/css">
.example1 {
	border: 1px solid #ddd;
	text-align: justify;
	text-justify: inter-word;
}

.example2 {
	color: black; /* text color is white */
	background: white; /* Content, padding will be blue */
	margin: 12px 12px 12px 12px;
	list-style: none /* no glyphs before a list item */  
                                       /* No borders set */
}
</style>
</head>
<body>

	<div class="span3">
		<div>
			<ul class="breadcrumb">
				<li><a href="home_after_login">Home</a><span class="divider">></span></li>
				<li class="active">My Account</li>
			</ul>
		</div>
		<div class="example1">
			<ul class="nav nav-tabs nav-stacked">
				<li 	
					style="font-size: 18px; font-weight: bold; background-color: #00224A; padding: 7px; color: white">My
					Account</li>
				<li class="example2"
					style="font-size: 16px; font-weight: bold; background-color:">Orders</li>
				<li><a href="order_status">Order Status </a></li>
				<li class="example2"
					style="font-size: 16px; font-weight: bold; background-color:">Payments</li>
				<li><a href="">E-Gift Voucher </a></li>
				<li><a href="">Wallet </a></li>
				<li class="example2"
					style="font-size: 16px; font-weight: bold; background-color:">Settings</li>
				<li><a href="account">Personal Information</a></li>
				<li><a href="change_password">Change Password </a></li>
				<li><a href="addresses">Addresses </a></li>
				<li><a href="profile_settings">Profile Settings </a></li>
				<li><a href="update_email">Update Email </a></li>
			</ul>
		</div>

	</div>

</body>
</html>