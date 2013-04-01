<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Email</title>
</head>
<body>

	<div class="span10" align="left">


		<div>

			<h3 style="margin-top: 50px">Update Email</h3>
			<h5>Enter the new Email ID that you wish to associate with your Flipkart account.</h5>
			<s:form action="#" method="post">
				<table theme="simple">
					<tr>
						<td align="left">Email Address&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><s:label name="email" value="%{email}" theme="simple"></s:label></td>
					</tr>
					<tr>
						<td align="left">New Email ID&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><s:password name="newEmail" theme="simple"></s:password>
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