<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="./ViewResources/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<script type="text/javascript"
	src="./ViewResources/js/bootstrap-dropdown.js"></script>
<script type="text/javascript" src="./ViewResources/js/application.js"></script>
<script type="text/javascript" src="./ViewResources/js/jquery"></script>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="/struts-tags"%>
<%@ taglib prefix="r" uri="/struts-tags"%>
<SCRIPT LANGUAGE="JavaScript">
<!--

var pic1=new Image()
pic1.src="./images/image1.jpg"
var pic2=new Image()
pic2.src="./images/image2.jpg"
	var pic2=new Image()
pic2.src="./images/image3.jpg"

//-->
</script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="span3">
				<ul class="nav nav-tabs nav-stacked">
					<s:iterator value="categories_list" status="text" id="c">
						<li class="dropdown-submenu"><a href="#"> <s:property /></a>
							<s:set scope="request" var="cat" value="#c" />
							<ul class="dropdown-menu">


								<%@ page
									import="java.util.ArrayList,com.flipkart.action.Categories_List"%>
								<%
									String category = (String) request.getAttribute("cat");
									Categories_List c = new Categories_List();
									ArrayList<String> subcatg = c.getSubCategories(category);
									session.setAttribute("subcatg", subcatg);
								%>

								<p:iterator value="#session.subcatg" status="text" id="p">
									<li class="dropdown-submenu"><a href="#"> <p:property /></a>
										<p:set scope="request" var="subcat" value="#p" />
										<ul class="dropdown-menu">

											<%
												String subcategory = (String) request.getAttribute("subcat");
																																									
												ArrayList<String> products = c.getProducts(subcategory);

												session.setAttribute("products", products);
											%>

											<r:iterator value="#session.products" status="text" id="r">
												<s:set scope="request" var="prod" value="#r" />
												<%
													String product = (String) request.getAttribute("prod");
												%>
												<li><a href="displayProduct?productName=<%=product%>">
														<r:property />
												</a></li>
											</r:iterator>
										</ul></li>
								</p:iterator>
							</ul></li>
					</s:iterator>
				</ul>


			</div>
			<div class="row">
				<div class="span8">

					<div style="border: 1px solid skyblue">


						<img src="./images/image1.jpg" name="animation" />


					</div>
					<script type="text/javascript">

<!--
var counter=1
function animate(){
//does not animate if the browser does not support images
if (!document.images)
return
document.images.animation.src=eval("pic"+counter+".src")
if (counter<2)
counter++
else
counter=1
//controls the speed of the transition, in this case 100 means 100 milliseconds or 1/10 seconds
setTimeout("animate()",1000)
}
animate()
//-->
</script>
				</div>
				<div class="span8">
					<div class="row">
						<table border="1" align="right" BORDERCOLOR=skyblue>
							<tr>
								<td><img src="./images/camera1.png" name="animation"
									width="210" /></td>
								<td><img src="./images/bag1.png" name="animation"
									width="200" /></td>
								<td><img src="./images/watch1.png" name="animation"
									width="200" /></td>
							</tr>
						</table>
					</div>


					<div class="span8">
						<div class="row">
							<div class="span2">

								<img class="img-rounded" src="./images/nokia-lumia.jpeg" alt="Samsung Galaxy Grand Duos I9082: Mobile"  />
								
							</div>
							<div class="span2">


								<img class="img-rounded" src="./images/galaxy-tab.jpeg" alt="" />
								galaxy-tab
							</div>
							<div class="span2">


								<img class="img-rounded" src="./images/micromax-book.jpeg"
									alt="" /> micromax-book
							</div>
							<div class="span2">

								<img class="img-rounded" src="./images/samsung-galaxy.jpeg"
									alt="" /> samsung-galaxy
							</div>
						</div>
						<ul>


							<li class="divider"></li>
						</ul>
						<div class="row">
							<div class="span2">


								<img class="img-rounded" src="./images/d-link-dwm.jpeg" alt="" />
								d-link-dwm
							</div>
							<div class="span2">


								<img class="img-rounded"
									src="./images/iball-3-5g-wireless-modem.jpeg" alt="" />
								iball-3-5g-wireless-modem
							</div>
							<div class="span2">


								<img class="img-rounded"
									src="./images/iball-3-5g-wireless-modem2.jpeg" alt="" />
								iball-3-5g-wireless-modem2
							</div>
							<div class="span2">

								<img class="img-rounded" src="./images/d-link-dwm.jpeg" alt="" />
								d-link-dwm
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>