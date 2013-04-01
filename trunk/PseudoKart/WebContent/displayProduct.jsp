<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="s" uri="/struts-tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@page
	import="java.sql.*,java.util.ArrayList,com.flipkart.model.*,com.flipkart.action.*,com.opensymphony.xwork2.*"%>
<script>
	function showRating() {
		System.out.println("In show rating");
		var radioButtons = document.getElementsByName("rating");
		float
		Prodrating = (Float)ActionContext.getContext().getSession().get("productID");

		System.out.println("rating :" + Prodrating);
		radioButtons[Prodrating].checked = true;

	};
</script>

</head>
<body onload="showRating()">
	<s:form action="addToCart.action">
	<s:hidden name="productId" value="product.prodid"/>
		<table>
			<tr>
				<td><b><s:property value="product.name" /></b></td>
			</tr>
			<tr>
				<td>Ratings : <s:property value="%{product_rating}" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
		</table>
		<hr>
		<table>
			<!-- <tr>
<td><div class="rating" id="rate">

		<input type="radio" id="star5" name="rating" value="5" /><label
			for="star5" title="Rate this 5 star out of 5">5 stars</label> <input
			type="radio" id="star4" name="rating" value="4" /><label for="star4"
			title="Rate this 4 star out of 5">4 stars</label> <input type="radio"
			id="star3" name="rating" value="3" /><label for="star3"
			title="Rate this 3 star out of 5">3 stars</label> <input type="radio"
			id="star2" name="rating" value="2" /><label for="star2"
			title="Rate this 2 star out of 5">2 stars</label> <input type="radio"
			id="star1" name="rating" value="1" /><label for="star1"
			title="Rate this 1 star out of 5">1 star</label>
	</div></td>

</tr> -->
			<br>
			<tr>
				<td><s:property value="product.description" /></td>
			</tr>
		</table>
		<hr>
		<br>
		<table>
			<tr>
				<td><b style="color: red">Rs.<s:property
							value="product.price" /></b></td>
				<td style="color: green">In Stock</td>
			</tr>

			<tr>
				<td>Inclusive of taxes</td>
			</tr>
			<tr>
				<td>(Free Home Delivery)</td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
				<td><button type="submit"
						style="font-size: 20px; width: 200px; background-color: #FFA500; color: white">Buy
						This Now</button></td>

			</tr>
			<tr>
				<td>30 DAY REPLACEMENT GUARANTEE</td>
			</tr>
		</table>
	</s:form>
</body>
</html>