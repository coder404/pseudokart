
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="./ViewResources/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<script type="text/javascript" src="./js/keyboard.js" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="./css/keyboard.css">
<link rel="stylesheet" type="text/css" href="./css/button.css">

<title>::Bank Payment Gateway::</title>


</head>

<body>
<img src="./images/citi.jpg" width="100" />

<h4>Welcome to Citibank Payment Gateway
<br>
<div align="right" style="font-weight:bold"> Transaction Amount:<s:property value="name" /></div></h4>
	<s:actionerror theme="bootstrap" />
	<s:actionmessage theme="bootstrap" />
	<s:fielderror theme="bootstrap" />
	
	
	<s:form action="index" theme="simple"
		label="Please Enter the following details:"
		cssClass="well form-vertical">
	<table >
		<tr>
			<td>Choose your card : <s:radio label="Choose your card" labelposition="inline"
					list="{'Credit Card', 'Debit Card'}" name="cardChosen"
					cssClass="radio inline" tooltip="Select the card"
					cssErrorClass="foo" /></td>
		</tr>
	</table>
	</s:form>
	<s:form action="index" theme="simple"
		label="Please Enter the following details:"
		cssClass="well form-vertical">
	
<b>Please enter the following details :</b> 
<br> 
<br>
	
  Card number :            <s:textfield cssClass="input-small"
			name="cardNo1" />
-
               <s:textfield cssClass="input-small" name="cardNo2" />
-
                   <s:textfield cssClass="input-small" name="cardNo3" />
-
               <s:textfield cssClass="input-small" name="cardNo4" />
	
<br>
<br>
	Expiry Date :
	<s:select list="{'', '', ''}" name="expiryDate" headerKey="None" />
	<s:select list="{'', '', ''}" name="expiryDate" headerKey="None" />
<br>
	<br> IPIN for your Account :
	<input type="text" value="" class="keyboardInput">
	<br>
	<br>
	 <s:submit cssClass="btn" action="index" align="center" cssStyle="background : #900 ;color : white" />
	</s:form>

</body>

</html>