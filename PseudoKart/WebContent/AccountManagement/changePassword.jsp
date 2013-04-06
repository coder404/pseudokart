<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>

	<div class="span10" align="left">


		<div>

			<h3 style="margin-top: 50px">Change Password</h3>

			<s:form action="changePassword" method="post">
				<s:if test="hasActionErrors()">
					<div class="alert alert-error">
						<s:actionerror />
					</div>
				</s:if>
				<s:elseif test="hasActionMessages()">
					<div class="alert alert-success">
						<s:actionmessage />
					</div>
				</s:elseif>
				<table theme="simple">
					<tr>
						<td align="left">Email Address</td>
						<td><s:label name="email" value="%{email}" theme="simple"></s:label></td>
					</tr>
					<tr>
						<td align="left">Old Password</td>
						<td><s:password name="oldPassword" theme="simple"></s:password>
						</td>
					</tr>
					<tr>
						<td align="left">New Password</td>
						<td><s:password name="newPassword" theme="simple"></s:password>
						</td>
					</tr>
					<tr>
						<td align="left">Retype New Password</td>
						<td><s:password name="reNewPassword" theme="simple"></s:password>
						</td>
					</tr>

				</table>
				<br />
				<s:submit name="commandButton" id="mysubmit" value="Save Changes"
					cssClass="btn btn-primary" theme="simple" style="margin-left:120px" />
			</s:form>

		</div>
	</div>




</body>
</html>