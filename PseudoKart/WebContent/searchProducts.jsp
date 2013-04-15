<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>


<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<sx:head />
<script type="text/javascript">  
      var xmlHttp  
      var xmlHttp
      function showProducts(str){
      xmlHttp=GetXmlHttpObject();
      if (xmlHttp==null)
		 {
		 alert ("Browser does not support HTTP Request")
		 return
		 }
      var url="products.jsp";
      url +="?selected=" +str;
      xmlHttp.onreadystatechange = productChange;
      xmlHttp.open("GET", url, true);
      xmlHttp.send(null);
      }

      function productChange(){   
      if (xmlHttp.readyState==4){  
    	alert(xmlHttp.responseText);
	document.getElementById("products").innerHTML=xmlHttp.responseText ;  
      }   
      }

function GetXmlHttpObject()
{
var xmlHttp=null;
try
 {
 // Firefox, Opera 8.0+, Safari
 xmlHttp=new XMLHttpRequest();
 }
catch (e)
 {
 //Internet Explorer
 try
  {
  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
  }
 catch (e)
  {
  xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
 }
return xmlHttp;
}
      </script>

</head>

<body >
<%@ page import="com.opensymphony.xwork2.ActionSupport"%>



<s:form action="searchProduct" namespace="/" method="POST" name="formAction">

<td>
<div id="products">

<sx:autocompleter autoComplete="true" 
list="products_list" name="searchedProduct" showDownArrow="false" /></div>

<s:select label=""
			list="categories_list" name="category"
		 headerKey="None" headerValue="In All Categories"  onchange="showProducts(this.value)" />
    
<input type="image" name="search" src="./images/images.jpg" >
</td>


 </s:form>









</body>
</html>