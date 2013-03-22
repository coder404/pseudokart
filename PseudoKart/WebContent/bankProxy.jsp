
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
	
	
	<s:form action="checkAccount" theme="simple"
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
	<s:form action="checkAccount" theme="simple"
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
	<s:select label="Expiry Date"
													list="{'1','2','3','4','5','6','7','8','9','10','11','12'}"
													name="month" emptyOption="false" headerKey="-1"
													headerValue="Month"/>
													
											<s:select
													list="{'13','14','15','16','17','18','19','20',
													'21','22','23','24','25','26','27','28','29','30',
													'31','32','33','34','35','36','37','38','39','40',
													'41','42','43','44','45','46','47','48','49','50',
													'51','52'}"
													name="year" emptyOption="false" headerKey="-1"
													headerValue="Year" />
<br>
	<br> IPIN for your Account :
	<input type="text" value="" name="ipin" class="keyboardInput">
	<br>
	<br>
	 <s:submit cssClass="btn"  align="center" cssStyle="background : #900 ;color : white" />
	</s:form>

</body>

</html>