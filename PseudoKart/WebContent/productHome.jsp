<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="s" uri="/struts-tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/ratings.css">
<title>Insert title here</title>
<script>
function addRating()
{
var radioButtons = document.getElementsByName("rating");

for (var i = 0; i < radioButtons.length; i++) {
    if (radioButtons[i].checked) {
       alert("You gave a rating of " + radioButtons[i].value + " out of 5. Thank you!");
     
       
    break;
    }
    
    }
    
    document.getElementById("rating").submit();
     
};


/* function redirect(id){
	alert(id);
	document.getElementById("rating").value=id;
	document.forms["rating"].submit();
	} */
</script>



</head>
<body>

	<div>
		<img class="img-polaroid" src=<s:text name="product.prodImage"/>
			width="150" height="300" />
	</div>
	<strong>Have you used this product? </strong>
	<br>
	<strong>Please rate it.</strong>
	<br>
	<s:form action="rating" method="get">
	<div class="rating" id="rate" onclick="addRating()" >
		<s:hidden  name="prodId" id="prodId" value="%{prodId}"/>
	
		<input type="radio" id="star5" name="rating" value="5" /><label
			for="star5" title="Rate this 5 star out of 5">5 stars</label><input
			type="radio" id="star4" name="rating" value="4" /><label for="star4"
			title="Rate this 4 star out of 5">4 stars</label> <input type="radio"
			id="star3" name="rating" value="3" /><label for="star3"
			title="Rate this 3 star out of 5">3 stars</label> <input type="radio"
			id="star2" name="rating" value="2" /><label for="star2"
			title="Rate this 2 star out of 5">2 stars</label> <input type="radio"
			id="star1" name="rating" value="1" /><label for="star1"
			title="Rate this 1 star out of 5">1 star</label>
	</div>
</s:form>


	<!--  <div class="star-rating"><s><s><s><s><s></s></s></s></s></s></div>-->
	<!-- <div class="star-rating-rtl"><s><s><s><s><s></s></s></s></s></s></div> -->




</body>
</html>