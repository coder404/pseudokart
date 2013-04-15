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
<!--						<td class="main-head" colspan="2">Featured Products</td>-->
					</tr>
					<!-- ITERATE -->
					<tr><td>
					<br></br>
					</td></tr>
					<tr>
					
					<td>
					
					<table bordercolor="black" >
					<tr>
					<td  colspan="2">
					<h4>
					<b>Mobiles and Tablets></b>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="allmobiles" style="color: Black;"> View More>></a>
					</h4>
					</td>
					
					
					</tr>
					<s:iterator value = "mobiles" status="stat">
					<s:if test = "#stat.odd">
					</tr>
					<tr>
					
					</s:if>
					<td>
<!--						 PRODUCTS ROW 1,1-->
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td valign="top">
<!--										 PRODUCT 1 -->
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="200" height="170" align="center">
										<a href="displayProduct?productId=<s:property value = "prodid" />">	<img src="<s:property value="ProdImage"/>" alt="Mobile Phone" width="70" height="70"/></a></td>
										<td>
<!--												 PRODUCT DETAILS 			-->
										
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td class="offer"><s:property value = "name"/> </td>
											</tr>
											<tr>
												<td class="small-txt"> <s:property value = "description"/> </td>
											</tr>
						
											<tr>
												<td><strong>Rs <s:property value = "price"/>/-</strong></td>
											</tr>
											<tr>
												<td class="smal-txt">&nbsp;</td>
											</tr>
											
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
						
						
						
					</s:iterator>
					
					
					<!-- END ITERATE -->
					
					<!-- Mobiles -->
										<tr><td>
					<br></br>
					</td></tr>
					<tr>
					
					<td>
					
					<table bordercolor="black" >
					<tr>
					<td class="main-head" colspan="2">
					<h4>
					<b>Computers</b>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="allcomputers" style="color: black;"> View More>></a>

					</h4>
					</td>
					
				 <td colspan="2" height="10" bgcolor="#F66D05"></td>
	</tr>
					<s:iterator value = "computers" status="stat">
					<s:if test = "#stat.odd">
					</tr>
					<tr>
					
					</s:if>
					<td>
<!--						 PRODUCTS ROW 1,1-->
				
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td valign="top">
<!--										 PRODUCT 1 -->
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="200" height="170" align="center">
											<img src="<s:property value="ProdImage"/>"  width="120" height="120"/></td>
										<td>
<!--												 PRODUCT DETAILS 			-->
										
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td class="offer"><s:property value = "name"/> </td>
											</tr>
											<tr>
												<td class="small-txt"> <s:property value = "description"/> </td>
											</tr>
						
											<tr>
												<td><strong>Rs <s:property value = "price"/>/-</strong></td>
											</tr>
											<tr>
												<td class="smal-txt">&nbsp;</td>
											</tr>
											
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
						
						
						
					</s:iterator>
					</table></td></tr>
				</table>
</body>
</html>