<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<link rel="shortcut icon" href="/images/flipkart-mini-logo.ico"/>
<link rel="icon" type="image/ico" href="/images/flipkart-mini-logo.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
</head>
<body>

	<s:actionerror theme="bootstrap"/>
						<s:fielderror/>
						<s:actionmessage/>
	<s:form action="report_email_send" theme="bootstrap" cssClass="form-horizontal"
						label="Report Out of Stock" >

		<s:textfield name="to" label="To"></s:textfield>
		<s:textfield name="subject" label="Subject"></s:textfield>
		<s:textarea cols="15" rows="7" label="Message" name="msg"></s:textarea>
		<s:submit cssClass="btn btn-primary" value="send"  align="center"></s:submit>
	</s:form>
	
		
</body>
</html>