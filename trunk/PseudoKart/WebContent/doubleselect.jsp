<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Flipkart.com: Login</title>
<link rel="shortcut icon" href="/images/flipkart-mini-logo.ico"/>
<link rel="icon" type="image/ico" href="/images/flipkart-mini-logo.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>

</head>
<body>
<div class="alert">
<br/><br/><br/>
						<s:actionerror/>
						<s:fielderror/>
						<s:actionmessage/>
<s:form action="check_stock" theme="bootstrap" cssClass="form-horizontal"
						label="Select Category and SubCategory for Products to Be Viewed" id="form1" >


<s:doubleselect label="Categories " 
name="language1" list="languageMap.keySet()" 
doubleName="language2" doubleList="languageMap.get(top)" />

<s:submit cssClass="btn btn-primary" value="Find Products" align="center"></s:submit>
	
</s:form>
</div>

</body>
</html>