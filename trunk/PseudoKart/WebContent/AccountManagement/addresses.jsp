<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Addresses</title>
<style>
</style>
</head>
<body>
	<!-- <div class="row-fluid"> -->
	<div class="span10">
		<div>
			<h3 style="margin-top: 50px; margin-left: 10px">Add a New
				Address</h3>
			<s:form action="address" theme="bootstrap" cssClass="form-horizontal">
				<s:if test="hasActionErrors()">
					<div class="alert alert-error">
						<s:actionerror />
					</div>
				</s:if>
				<s:else>
					<div class="alert alert-success">
					
						<s:actionmessage />
					</div>
				</s:else>
				<table theme="simple" style="margin-left: 10px">
					<tr>
						<td>Name</td>
						<td><s:textfield name="name" theme="simple" value="%{name}"></s:textfield></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>Street Address</td>
						<td><s:textarea name="streetAddress" cols="15" rows="3"
								theme="simple" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><s:label theme="simple"
								value="(Maximun limit:216 characters)" readonly="true" /></td>
					</tr>
					<tr>
						<td>Landmark</td>
						<td><s:textfield name="landmark" theme="simple"></s:textfield>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>City</td>
						<td><s:textfield name="city" theme="simple"></s:textfield></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>State</td>
						<td><s:select
								list="{'Andaman and Nicobar Islands','Andhra Pradesh','Arunachal Pradesh',
							'Assam','Bihar','Chandigarh','Chhattisgarh','Dadra and Nagar Haveli',
							'Daman and Diu','Delhi','Goa','Gujarat','Haryana','Himachal Pradesh',
							'Jammu and Kashmir','Jharkhand','Karnataka','Kerala','Lakshadweep',
							'Madhya Pradesh','Maharashtra','Manipur','Meghalaya','Mizoram',
							'Nagaland','Orissa','Pondicherry','Punjab','Rajasthan','Sikkim',
							'Tamil Nadu','Tripura','Uttar Pradesh','Uttrakhand','West Bengal'}"
								theme="simple" name="state" headerValue="select" headerKey="-1"
								emptyOption="false" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>Country</td>
						<td><s:label theme="simple" name="country"
								value="India(Service available only in India)" readonly="true" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>Pincode</td>
						<td><s:textfield name="pin" theme="simple"></s:textfield></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>Phone Number</td>
						<td><s:textfield name="phone" theme="simple"></s:textfield></td>
					</tr>
				</table>
				<br />
				<s:submit name="commandButton" id="mysubmit" value="Save Changes"
					cssClass="btn btn-primary" theme="simple" style="margin-left:120px" />
<%-- 
				<div class="address-box">
				<s:if test="customerAddressList.size() != 0">
					<s:iterator value="customerAddressList">
						<s:property value="name"/>
						<s:property value="streetAddress"/>
						<s:property value="landmark"/>
						<s:property value="city"/>
					</s:iterator>
				</s:if>
				</div>
 --%>			</s:form>
		</div>
	</div>
	<!-- </div> -->
</body>
</html>