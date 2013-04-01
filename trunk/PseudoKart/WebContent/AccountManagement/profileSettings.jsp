<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Settings</title>
</head>
<body>

	<div class="span10" align="left">


		<div>

			<h3 style="margin-top: 50px">Profile Settings</h3>
			<div class="alert">
				<font style="font-weight: bold">Please Note:</font> Your Profile
				name can be changed <font style="font-weight: bold">only once</font>
				after registration
			</div>
		
			<s:form action="#" method="post">
				<table theme="simple">
					<tr>
						<td align="left">Profile Name</td>
						<td><s:textfield name="profileName"
								value="%{customerAction.profileName}" theme="simple" /></td>
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