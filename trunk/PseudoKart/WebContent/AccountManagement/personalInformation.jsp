<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Information</title>
<style>
</style>
</head>
<body>
	<!-- <div class="row-fluid"> -->

		<div class="span10">
		<div>
			<h3 style="margin-top: 50px">Personal Information</h3>
			<s:form action="personalInformation" method="post">
				<table theme="simple">

					<tr>
						<td>First Name</td>
						<td><s:textfield name="firstName" theme="simple"
								cssClass="input-large" value="%{customerAction.firstName}"/></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><s:textfield name="lastName" theme="simple"
								cssClass="input-large" value="%{customerAction.lastName}"/></td>
					</tr>
					<tr>
						<td>Mobile Number</td>
						<td><s:textfield name="mobileNumber" theme="simple"
								cssClass="input-large" value="%{customerAction.mobileNumber}"/></td>
					</tr>
					<tr>
						<td>Landline Number</td>
						<td><s:textfield name="landlineNumber" theme="simple"
								cssClass="input-large" value="%{customerAction.landlineNumber}"/></td>
					</tr>


					<tr>
						<td>Gender</td>
						<td><s:select name="gender" list="#{'Female':'Female','Male':'Male'}"
								 cssClass="input-small" theme="simple" value="%{customerAction.gender}"/></td>
					</tr>
					
						
				</table>
				<br/>
				<s:submit name="commandButton" id="mysubmit" 
								value="Save Changes" cssClass="btn btn-primary" theme="simple" style="margin-left:120px"/>
				<s:if test="hasActionErrors()">
				<div class="alert alert-success">
				<s:actionerror/>
				</div>
				</s:if>
			</s:form>
			</div>
		</div>
	<!-- </div> -->

</body>
</html>