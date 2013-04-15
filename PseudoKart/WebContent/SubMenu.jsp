<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form theme = "simple" action="searchProduct" namespace="/" method="POST" name="formAction">
					<table ><tr>
					
			
			<td style="font-size: 17px; color: white;font-weight: bold; font-family: serif;margin-right: 300px">Search: &nbsp; &nbsp; &nbsp;
					<s:textfield name="sear" width="500px"></s:textfield>
					<s:select list="categories_list.{name}" name="categ" headerKey="all" headerValue="All Categories" cssStyle="font-size: 17px;font-family: serif"></s:select> 
					
					&nbsp; 
					<a href="searchProduct"><img src="./images/images.jpg" height="40" width="50" align="top"></a>
					
					
					</td></tr></table>
					</s:form>

</body>
</html>