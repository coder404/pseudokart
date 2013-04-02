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



	<div class="tabbable">
		<div class="container-fluid">
		<ul class="breadcrumb">
			<ul class="nav nav-tabs" id="myTab">
			<li ><img src="./images/glyphicons_202_shopping_cart.png"/></li>
				<li class="active"><a data-toggle="tab" href="#Cart">Cart</a></li>
			<!--  	<li><a href="#DigitalCart" data-toggle="tab">Digital Cart</a></li> -->
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li><img src="./images/glyphicons_192_circle_remove.png" /></li>
				
			</ul>
</ul>
			<div id="Cart" class="tab-content">

				<div id="" class="tab-pane active in">
					<s:form id="tab1"></s:form>
				</div>

			<!--  	<div id="DigitalCart" class="tab-pane"> -->



					<s:actionerror theme="bootstrap" />
					<s:actionmessage theme="bootstrap" />
					<s:fielderror theme="bootstrap" />
					<p>
 <!--   <button class="btn btn-primary" type="button">Continue Shopping</button>-->
 <!--   <button class="btn" type="button">Continue Shopping</button>-->
</p>

<ul class="breadcrumb">
	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;There are no items in this cart </li>
	
	
 <!--  <li><button class="btn btn-primary" type="button">Continue Shopping</button></li>-->
 <!--   <li><a href="#">Library</a> <span class="divider">/</span></li>-->
 <!--   <li class="active">Data</li>-->
</ul>

	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<s:form><s:submit cssClass="btn  btn-primary" action="home_after_login" value="Continue Shopping"/></s:form>
	<br /><br /><p>Browse Categories</p>	
	
  <a href="#">Cameras</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="#"> Books</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="#"> Accessories</a><br />
  <a href="#"> Mobiles</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="#">  Games</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="#">  Laptops</a><br />
  <a href="#">Music CDs</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="#"> IPODs</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="#"> MobileAccessories</a><br />
  
		
</div>
</div>
</div>
</div>

</body>
</html>
