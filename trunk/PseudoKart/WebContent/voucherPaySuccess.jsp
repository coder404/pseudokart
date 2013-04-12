<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Voucher Success</title>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="./ViewResources/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<script>window.history.forward(1);</script>
</head>
<body onload="javascript:history.go(1)">
   <div class="alert alert-info" align="center">
  <center> <strong>Payment Successful!!!!</strong></center><br/>
     <table class="table table-striped" align="center">
     <tr>
     <td>Voucher Number : </td>
     <td><s:property value="%{vcardnum}"/></td>
     </tr>
     <tr>
     <td>Current Balance : </td>
     <td><s:property value="%{voucherbal}"/></td>
     </tr>
     <tr>
     <td>Purchase Amount : </td>
     <td><s:property value="%{purchaseAmt}"/></td>
     </tr>
     <tr>
     <td>Balance After Pay: </td>
     <td><s:property value="%{RemVoucherBal}"/></td>
     </tr>
     </table>
     <s:form><s:submit cssClass="btn btn-primary" value="Back"	action="finishPurchase" align="center"></s:submit></s:form>
    </div>
</body>
</html>