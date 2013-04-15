<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-modal.js"></script>
<!--<script type="text/javascript" src="./ViewResources/js/Remove_synch.js"></script>-->
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
window.i=0;
window.temp=null;
//window.str=null;
 function foo(qty,str) {
	
	
	var d=document.getElementById(str);
	temp=str.concat(qty);
	var temp2=qty.concat(str);
	window.str=str;
	
d.innerHTML="<td><input type='text' id='temp_div' maxlength='2'  style="+"width:30px;height:"+"10px ><br /><a id='trial' href="+"#"+">Save</a></td>";
document.getElementById("temp_div").setAttribute('id',temp);
document.getElementById("trial").setAttribute('id',temp2);
document.getElementById(temp).value=qty;
//document.getElementById(temp).setAttribute("onkeypress","return isNumberKey(event)");


document.getElementById(temp2).setAttribute("onclick","func()");

return true;
}
</script>
<script type="text/javascript">
function func(){
		if((document.getElementById(temp).value)!='0')
	
		i=document.getElementById(temp).value;
	
	
	
	xmlhttp=GetXmlHttpObject();
	var url="update_quantity.jsp";
	url=url+"?yourQuantity="+i;
	url=url+"&yourItem="+str;
	
	
	xmlhttp.onreadystatechange=stateChanged;
	xmlhttp.open("GET",url,true);
	xmlhttp.send(null);
	
}
</script>

<script type="text/javascript">
function removeItem(item_del)
{
	
  
xmlhttp=GetXmlHttpObject();
if (xmlhttp==null)
  {
  alert ("Your browser does not support XMLHTTP!");
  return true;
  }



	var url="CartAction_RemoveItem.jsp";
	url=url+"?ItemDesc="+item_del;
	//url=url+"&sid="+Math.random();
	xmlhttp.onreadystatechange=stateChanged;
	xmlhttp.open("GET",url,true);
	xmlhttp.send(null);
	

}
</script>

<script type="text/javascript">
function stateChanged()
{
if (xmlhttp.readyState==4)
  {
  document.getElementById("res").innerHTML=xmlhttp.responseText;
}
else
{
  document.getElementById("res").innerHTML="PROCESSING..<img src='images/ajax_loader.gif' />";
}
}
</script>
<script type="text/javascript">
function GetXmlHttpObject()
{
if (window.XMLHttpRequest)
  {
  // code for IE7+, Firefox, Chrome, Opera, Safari
  return new XMLHttpRequest();
  }
if (window.ActiveXObject)
  {
  // code for IE6, IE5
  return new ActiveXObject("Microsoft.XMLHTTP");
  }
return null;
}
</script>


</head>

<body>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<div align="justify">
<table bgcolor="#005575">
<tr height="30">

<td colspan="2"><a href="home_after_login"><img src="./images/logo.jpg" width="170"/></a></td>
<td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/>
<td/><td/><td/><td/><td/><td/><td/><td/><td/><td/><td/>
<!-- <td><a href="#"><font color="white" size="3px">24x7 Customer Support  -  </font></a></td>
<td><a href="#"><font color="white" size="3px">&nbsp;Contact Us</font></a></td>
 --><td><div style="width: 1px; height: 11px; background-color: white; float: left;"></div></td>

<td><a href="home_after_login"><font color="white" size="3px">&nbsp;&nbsp;Home</font></a></td>
<%-- <% if(ActionContext.getContext().getSession().get("email") == null){ %>
<td><a href="categories"><font color="white" size="3px">&nbsp;&nbsp;Home</font></a></td>
<%} %> --%>
<td><div style="width: 1px; height: 11px; background-color: white; float: left;"></div></td>
<td><a href="account"><font color="white" size="3px">&nbsp;&nbsp;Account</font></a></td>
<td><div style="width: 1px; height: 11px; background-color: white; float: left;"></div></td>
<td><a href="Wallet"><font color="white" size="3px">&nbsp;&nbsp;Wallet</font></a></td>
<td><a href="BuyVoucher.jsp"><font color="white" size="3px">&nbsp;&nbsp;e-Gift Voucher</font></a></td>
<!--  <td><a href="ViewCart"><font color="white" size="3px">&nbsp;&nbsp;Cart</font></a></td>-->
<td><a href="#Cart"  data-toggle="modal">Cart</a></td>
<td><div style="width: 1px; height: 11px; background-color: white; float: left;"></div></td>
<%@ page import="com.opensymphony.xwork2.ActionContext,com.flipkart.action.loginAction"%>
<td><a href="#"><font color="white" size="3px">&nbsp;&nbsp;<%=ActionContext.getContext().getSession().get("email") %></font></a></td>
<td><a href="logout"><font color="white" size="3px">&nbsp;&nbsp;Logout</font></a></td></tr></table></div>

 
<!-- Modal -->
<%@ page import="com.flipkart.action.CartAction_ViewCart"%>
<%@ page import="java.util.*" %>
<%@ page import="com.opensymphony.xwork2.ActionContext,com.flipkart.model.*"%>
<% ArrayList<Cart> Cart_View =new ArrayList<Cart>();
CartAction_ViewCart obj=new CartAction_ViewCart();
Cart_View=obj.onClickCart((String)ActionContext.getContext().getSession().get("email"));
System.out.println("IN HEADER..CHECKING CART SIZE"+Cart_View.size());
if(Cart_View.size()!=0){
ActionContext.getContext().getSession().put("CartView",Cart_View);
%>


<div id="Cart" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			 <div class="modal-header">		
  
			<ul class="nav nav-tabs" id="myTab">
			<li ><img src="./images/glyphicons_202_shopping_cart.png"/></li>
				<li class="active"><a data-toggle="tab" href="#ViewCart">Cart</a></li>
				
   <li> <button type="button" class="close" data-dismiss="modal" aria-hidden="true" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;x </button></li>
   </ul>
   
   </div>
  <!--    <h3 id="myModalLabel">Modal header</h3> -->
  
  
  <div class="modal-body" id="res">
 
   <table class="table table-striped"> 
   
<tr>
								
								<th>Item Description</th>
								<th>&nbsp;&nbsp;&nbsp;</th>
								<th>Delivery Time</th>
								<th>&nbsp;&nbsp;&nbsp;</th>
								<th>Price</th>
								<th>&nbsp;&nbsp;&nbsp;</th>
								<th>Quantity</th>
								<th>&nbsp;&nbsp;&nbsp;</th>
								<th>Subtotal</th>
								<th>&nbsp;&nbsp;&nbsp;</th>
								<th></th>
								
							</tr>
						
							<s:iterator value="#session.CartView">
						
					<tr>
					<td><s:property value="ItemDesc"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><s:property value="DeliveryTime"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><s:property value="price"/></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
				<td><div id="<s:property value="ItemDesc"/>"><s:property value="quantity" /><br /><a href="#" onclick="return foo('<s:property value="quantity" />','<s:property value="ItemDesc"/>');">Change</a></div></td>
				<!--  	<td><a href="Change_quantity">Change</a>-->
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><s:property value="subtotal"/></td>
					
					<td><a href="#" onclick="return removeItem('<s:property value="ItemDesc"/>');"> X </a></td>
					</tr>
					</s:iterator>
						</table>
					<table>
							<tr>

								<th>Amount Payable :  </th>
							 	<th><s:property value="#session.totalCartAmt"/></th>
							</tr>
							<tr>
							 <td><s:property value="%{amount}"/></td></tr>
							
							
						
						</table>
						<br/><br/>
  </div>
  <div class="modal-footer">
  
  <s:form theme="simple">
<table>
						<tr>
						<td><s:submit cssClass="btn  btn-primary" action="home_after_login" value="Continue Shopping"/>
						</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
					
						<td><s:submit cssClass="btn  btn-warning"  value="Place Order" action="orderEntry_PlaceOrder"/>
						</td></tr>
						</table>
						</s:form>
   
  </div>


 

</div>
<% }
else if(Cart_View.size()==0)
{%>
<div id="Cart" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			 <div class="modal-header">	
				
  
			<ul class="nav nav-tabs" id="myTab">
			<li ><img src="./images/glyphicons_202_shopping_cart.png"/></li>
				<li class="active"><a data-toggle="tab" href="#ViewCart">Cart</a></li>
				
   <li> <button type="button" class="close" data-dismiss="modal" aria-hidden="true" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;x </button></li>
   </ul>
   
   </div>
   <div class="modal-body">
   

	<s:form>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<s:submit cssClass="btn  btn-primary" align="center" action="home_after_login" value="Continue Shopping" /></s:form>
	</div><br /> <br />
<div class="modal-footer">
<s:form theme="simple">
<p align="left">Browse Categories</p>	
	
<p align="left"> <a href="#">Cameras</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="#"> Books</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="#"> Accessories</a><br />
  <a href="#"> Mobiles</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="#">  Games</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="#">  Laptops</a><br />
  <a href="#">Music CDs</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="#"> IPODs</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="#"> MobileAccessories</a><br /></p>
  
</s:form>



</div>	
   
   
   
   </div>

<%} %>
</body>

</html>