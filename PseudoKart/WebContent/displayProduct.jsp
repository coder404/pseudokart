<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="s" uri="/struts-tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@page import="java.sql.*,java.util.ArrayList,com.flipkart.model.*,com.flipkart.action.*,com.opensymphony.xwork2.*"%>
<script type="text/javascript">
﻿  function showRating() {
﻿  ﻿  System.out.println("In show rating");
﻿  ﻿  var radioButtons = document.getElementsByName("rating");
﻿  ﻿  float
﻿  ﻿  Prodrating = (Float)ActionContext.getContext().getSession().get("productID");

﻿  ﻿  System.out.println("rating :" + Prodrating);
﻿  ﻿  radioButtons[Prodrating].checked = true;

﻿  };
﻿  
﻿  $.fn.stars = function() {
﻿      return $(this).each(function() {
﻿          // Get the value
﻿          var val = parseFloat($(this).html());
﻿          // Make sure that the value is in 0 - 5 range, multiply to get width
﻿          var size = Math.max(0, (Math.min(5, val))) * 16;
﻿          // Create stars holder
﻿          var $span = $('<span />').width(size);
﻿          // Replace the numerical value with stars
﻿          $(this).html($span);
﻿      });
﻿  }
﻿  
﻿  
</script>
<style type="text/css">
span.stars,span.stars span {
	display: block;
	background: url(/image/stars.jpg) 0 -16px repeat-x;
	width: 80px;
	height: 16px;
}

span.stars span {
	background-position: 0 0;
}
</style>

</head>
<body onload="showRating()">
	﻿
	<s:form action="addToCart.action">
﻿  <s:hidden name="productId" value="%{product.prodid}" />
﻿  
﻿<table>

<tr>

<td><b><s:property value="product.name" /></b></td>
</tr>

<tr>
				
				<td>Ratings : <span class="stars"><s:property
							value="%{product_rating}" /></span></td>
</tr>

<tr></tr>

<tr></tr>

<tr></tr>

		</table>
﻿  ﻿  <hr>
﻿  ﻿  <table>

<!-- <tr>
<td><div class="rating" id="rate">

﻿  ﻿  <input type="radio" id="star5" name="rating" value="5" /><label
﻿  ﻿  ﻿  for="star5" title="Rate this 5 star out of 5">5 stars</label> <input
﻿  ﻿  ﻿  type="radio" id="star4" name="rating" value="4" /><label for="star4"
﻿  ﻿  ﻿  title="Rate this 4 star out of 5">4 stars</label> <input type="radio"
﻿  ﻿  ﻿  id="star3" name="rating" value="3" /><label for="star3"
﻿  ﻿  ﻿  title="Rate this 3 star out of 5">3 stars</label> <input type="radio"
﻿  ﻿  ﻿  id="star2" name="rating" value="2" /><label for="star2"
﻿  ﻿  ﻿  title="Rate this 2 star out of 5">2 stars</label> <input type="radio"
﻿  ﻿  ﻿  id="star1" name="rating" value="1" /><label for="star1"
﻿  ﻿  ﻿  title="Rate this 1 star out of 5">1 star</label>
﻿  </div></td>

</tr> -->

<tr>

<td><s:property value="product.description" /></td>
</tr>
﻿
</table>
﻿  ﻿  <br />
﻿  ﻿  <hr>
﻿  ﻿  <br>
﻿		<table>
			<tr>
				<td><b style="color: red">Rs.<s:property
							value="product.price" /></b></td>
			</tr>
			<tr>
				<td>Inclusive of taxes</td>
			</tr>
			<tr>
				<td>(Free Home Delivery)</td>
				
				<s:if test="inStock">
					<td style="color: green">In Stock</td>
					<tr>
				<td><button type="submit"
						style="font-size: 20px; width: 200px; background-color: #FFA500; color: white">Buy
						This Now</button></td>

			</tr>
					<tr>
				<td>30 DAY REPLACEMENT GUARANTEE</td>
			</tr>
				</s:if>
				
				<s:else>
				
					<td style="color: black">Out of Stock</td>


					<tr>
						<td>Notify me when this product is in stock:</td>
					</tr>
					<tr></tr>

					<tr>
						<td><s:textfield key="emailid" name="emailid" size="20"
								label="Email Id">
							</s:textfield></td>
						<td><s:submit type="button" value="notifyMe"
								action="notifyMe" name="buttonName" label="Notify Me" cssStyle="border-radius:0; border:1px solid #1A356E ;background : #5B74A8 ;color : white"/></td>
					</tr>


				</s:else>




	
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
						
		</table>
		  </s:form>
</body>
</html>