<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr >
					<td></td>
					</tr>
					<!-- ITERATE -->
					<tr><td>
					<br></br>
					</td></tr>
					<tr>
					
					<td>
					
					<table bordercolor="black" >
					<s:iterator value = "allcomputers" status="stat">
					<tr>
					<td>
<!--						 PRODUCTS ROW 1,1-->
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td valign="top">
<!--										 PRODUCT 1 -->
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="200" height="170" align="center">
											<a href="displayProduct?productId=<s:property value = "prodid" />">
											<img src="<s:property value="ProdImage"/>"  width="141" height="163"/></a>
											</td>
										<td>
<!--												 PRODUCT DETAILS 			-->
										
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td class="offer"><s:property value = "name"/> </td>
												<td class="small-txt"> <s:property value = "description"/> </td>
											</tr>
						
											<tr>
												<td><b>Price:</b><strong>Rs <s:property value = "price"/>/-</strong></td>
											</tr>
											<tr>
												<td>
														<s:set var = "qty" value = "quantity"/>
														<s:if test = "%{#qty > 5}">
															<h6 style="color: green;"><b>In Stock</b></h6>
														</s:if>
														<s:else>														
															<h6 style="color: red;"><b>Out of Stock</b></h6>
 														</s:else>
														
												</td>
											</tr>
															
											<tr>
												<td class="smal-txt">&nbsp;</td>
											</tr>
						<tr><td><a href ="displayProduct?productId=<s:property value = 'prodid'/>" style="color: #F66D05">Buy Now</a></td></tr> 					
										</table>
									</td>
									</tr>
<!--									 PRODUCT 1 ENDS-->
								</table>		
								</td>
							</tr>
							<tr>
								<td height="1" colspan="3" bgcolor="#E0E0E0"></td>
							</tr>
						</table>
						</td>	
						
						</tr>
						
					</s:iterator>
					</table></td></tr>
					
					
					<!-- END ITERATE -->
									
				</table>
</body>
</html>