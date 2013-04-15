<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<SCRIPT LANGUAGE="JavaScript">
<!--

var pic1=new Image()
pic1.src="./images/image1.jpg";

	
var pic2=new Image()

pic2.src="./images/image2.jpg"
	var pic3=new Image()
pic3.src="./images/image3.jpg"
	
	
	var pic4=new Image()
pic4.src="./images/image4.jpg"
	

//-->
</script>
</head>
<body>
	<div class="row">
		<div class="span9">

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
// -->
</script>
		</div>
		<div class="span9">
			<div class="row">
				<table border="1" align="right" BORDERCOLOR=skyblue>
					<tr>
						<td><img src="./images/camera1.png" name="animation"
							width="210" /></td>
						<td><img src="./images/bag1.png" name="animation" width="250" /></td>
						<td><img src="./images/watch1.png" name="animation"
							width="230" /></td>
					</tr>
				</table>
			</div>

		</div>

	</div>

</body>
</html>