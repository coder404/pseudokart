<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<link type="text/css" rel="stylesheet"
	href="./ViewResources/css/bootstrap.css">
<script type="text/javascript" src="./ViewResources/js/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="./ViewResources/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="./ViewResources/js/bootstrap-tab.js"></script>

<title>Place Order</title>
<style type="text/css">

#addressBox{
	border: 2px solid #a5a296; 
	width: 150px; 
	height: 60px; 
	margin: 5px; 
	padding: 10px; 
	color: #333; 
	border-radius: 3px; 
	background-position: bottom right;
	 background-repeat: no-repeat; 
	 word-wrap: break-word;
}
.tickSign{
    width: 30px;
    height: 15px;
    float: right;
    position: relative; top: 25px;right: 1px;
    background-image: url('./images/tickk.png');
    background-repeat: no-repeat;
}
.tickSign:hover{
    background-image: url('./images/tickk.png');
}

</style>


<sb:head />
</head>
<body>


	<div class="tabbable">
		<div class="container-fluid">
			<ul class="nav nav-tabs" id="myTab">
				<li class="active"><a data-toggle="tab" href="#Emaillogin">Email
						Login</a></li>
				<li><a href="#shippingaddress" data-toggle="tab">Shipping
						Address</a></li>
				<li><a href="#ordersummary" data-toggle="tab">Order Summary</a></li>
				<li><a href="#paymentoptions" data-toggle="tab">Payment
						Options</a></li>
			</ul>



			<div class="tab-content">

				<div id="Emaillogin" class="tab-pane active in">
					<s:form id="tab1"></s:form>
				</div>

				<div id="shippingaddress" class="tab-pane">

					<div style="width: 40%; float: left">
						<center>
							<h5>Select Previous Address</h5>
						</center>
						<a id="refs" style="color: #004b91; text-decoration: none;">
							<div id="addressBox">
								
								<div class="tickSign" style="width: 120px; height: 20px; line-height: 20px; no-repeat; border: 1px solid #ccc; -moz-border-radius: 2px; border-radius: 2px; -moz-box-shadow: 1px 1px .3px #9d9d9d; -webkit-box-shadow: 1px 1px .3px #9d9d9d; box-shadow: 1px 1px .3px #9d9d9d; color: #555; font-size: 13px; padding: 1px 18px 1px 5px; background-color: #cecdcd;">	
								
								</div>
							</div>
						</a>
					</div>
					<script type="text/javascript">
					$(function() {
					    $('.tickSign').hide();
					    $('#refs').hover(
						    function() {
						        $('.tickSign').show().append("&nbsp;&nbsp;&nbsp;&nbsp; Click to select");
						    }, function() {
						        $('.tickSign').hide().empty();
						    }
						);
					});
					</script>	
		

					<div style="width: 60%; float: right">
						<div
							style="width: 1px; height: 450px; background-color: black; float: left;"></div>
						<center>
							<h5>Enter New Shipping Address</h5>
						</center>
						<br /> <br />

						<s:actionerror theme="bootstrap" />
						<s:actionmessage theme="bootstrap" />
						<s:fielderror theme="bootstrap" />


						<s:form action=" " theme="bootstrap" cssClass="form-horizontal">
							<s:textfield label="Name*" name="name" size="15" />

							<s:textarea label="Address*" name="address" cols="20" rows="3" />

							<s:textfield label="Landmark" name="landmark" />

							<s:textfield label="City*" name="city" />


							<s:select label="State*"
								list="{'Andaman and Nicobar Islands','Andhra Pradesh','Arunachal Pradesh',
			'Assam','Bihar','Chandigarh','Chhattisgarh','Dadra and Nagar Haveli',
			'Daman and Diu','Delhi','Goa','Gujarat','Haryana','Himachal Pradesh',
			'Jammu and Kashmir','Jharkhand','Karnataka','Kerala','Lakshadweep',
			'Madhya Pradesh','Maharashtra','Manipur','Meghalaya','Mizoram',
			'Nagaland','Orissa','Pondicherry','Punjab','Rajasthan','Sikkim',
			'Tamil Nadu','Tripura','Uttar Pradesh','Uttrakhand','West Bengal'}"
								name="state" emptyOption="false" headerKey="-1"
								headerValue="-----Select State---------" />

							<s:textfield label="Country" name="country" value="India"
								disabled="true" />

							<s:textfield label="Pincode*" name="pincode" />

							<s:textfield label="Phone*" name="phone" />

							<s:submit cssClass="btn btn-warning" value="Save and Continue"
								align="right" />


						</s:form>
					</div>
				</div>



				<div id="ordersummary" class="tab-pane">
					<s:form action=" " theme="bootstrap" cssClass="form-horizontal"
						label="Review Your Order">
						<table class="table table-striped">
							<tr>
								<th>Type</th>
								<th>Item Description</th>
								<th>Delivery Time</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Subtotal</th>
							</tr>
						</table>
						<table>
							<tr>

								<th>Amount Payable</th>
							</tr>
						</table>
						<br />
						<br />
						<s:submit cssClass="btn btn-warning" value="Continue" />
					</s:form>
				</div>

				<div id="paymentoptions" class="tab-pane">

					<div class="tabbable tabs-left">
						<ul class="nav nav-tabs" id="newTab">
							<li class="active"><a data-toggle="tab" href="#netbank">Net
									Banking</a></li>
							<li><a href="#card" data-toggle="tab">Credit/Debit Card</a></li>
							<li><a href="#gift" data-toggle="tab">e-Gift Voucher</a></li>
							<li><a href="#wallet" data-toggle="tab">e-Wallet</a></li>
						</ul>
						<div class="tab-content">

							<div id="netbank" class="tab-pane active in">
								<s:form theme="bootstrap" cssClass="form-horizontal"
									label="Pay With Net Banking" action="paymentGateway">
									<br />
									<br />
									<center></center>
									<s:submit cssClass="btn btn-warning" value="Payment Gateway" />
									</center>
								</s:form>
							</div>

							<div id="card" class="tab-pane">
								<s:actionerror theme="bootstrap" />
								<s:actionmessage theme="bootstrap" />
								<s:fielderror theme="bootstrap" />
								<s:form action=" " theme="bootstrap" cssClass="form-horizontal"
									label="Pay Using Credit/Debit Cards ">
									<pre>Enter your Card Details</pre>
									<br />
									<br />
									<s:textfield label="Card Number" name="cardno" />
									<s:textfield label="Name on Card" name="name_card" />
									<s:select label="Expiry Date"
										list="{'1','2','3','4','5','6','7','8','9','10','11','12'}"
										name="month" emptyOption="false" headerKey="-1"
										headerValue="Month" />

									<s:select
										list="{'13','14','15','16','17','18','19','20',
													'21','22','23','24','25','26','27','28','29','30',
													'31','32','33','34','35','36','37','38','39','40',
													'41','42','43','44','45','46','47','48','49','50',
													'51','52'}"
										name="month" emptyOption="false" headerKey="-1"
										headerValue="Year" />

									<s:textfield label="CVV No" name="cvv"
										tooltip="Enter three digits found at the back of card" />

									<s:submit cssClass="btn btn-warning" value="Pay" />
								</s:form>


							</div>

							<div id="gift" class="tab-pane">
								<s:actionerror theme="bootstrap" />
								<s:actionmessage theme="bootstrap" />
								<s:fielderror theme="bootstrap" />
								<s:form action=" " theme="bootstrap" cssClass="form-horizontal"
									label="Pay Using e-Gift Voucher ">
									<pre>Enter the Gift Voucher Details</pre>
									<br />
									<br />
									<s:textfield label="Card Number" name="cardno" />
									<s:textfield label="PIN Number" name="pinno" />

									<s:submit cssClass="btn btn-warning" value="Pay" />
								</s:form>
							</div>
							<div id="wallet" class="tab-pane"></div>
						</div>
					</div>
					<!-- End here -->
				</div>

			</div>
		</div>
		<!-- /.tab-content -->
	</div>
	<!-- /.tabbable -->
</body>
</html>