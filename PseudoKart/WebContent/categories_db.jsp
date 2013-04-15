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

</head>
<body>


	<div class="row">
		<div class="span3">
			<ul class="nav nav-tabs nav-stacked">
				<s:iterator value="categories_list.{name}" status="text" id="c">
					<li class="dropdown-submenu"><a href="filterProducts?categoryname=<s:property />"> <s:property /></a>
						<s:set scope="request" var="cat" value="#c" />
						<ul class="dropdown-menu">


							<%@ page
								import="java.util.ArrayList,com.flipkart.model.*,com.flipkart.action.Categories_List,com.opensymphony.xwork2.ActionContext,com.opensymphony.xwork2.ActionSupport"%>
							<%
								String category = (String) request.getAttribute("cat");
									Categories_List c = new Categories_List();
									ArrayList<Category> subcatg = c.getSubCategories(category);
									ActionContext.getContext().getSession().put("subcatg", subcatg);
							%>

							<p:iterator value="#session.subcatg.{name}" status="text" id="p">
								<li class="dropdown-submenu"><a href="#"> <p:property /></a>
									<p:set scope="request" var="subcat" value="#p" />
									<ul class="dropdown-menu">

										<%
											String subcategory = (String) request
															.getAttribute("subcat");

													ArrayList<Product> products = c.getProducts(subcategory);
													// Map sess = ActionContext.getContext().getSession();
													ActionContext.getContext().getSession()
															.put("products", products);

													//session.setAttribute("products", products);
										%>

										<r:iterator value="#session.products" status="text"
											id="r">

											<li><a href="displayProduct?productId=<r:property value="prodid" />">
													<r:property value="name" />
											</a></li>
										</r:iterator>
									</ul></li>
							</p:iterator>
						</ul></li>
				</s:iterator>
			</ul>


		</div>

	</div>

</body>
</html>