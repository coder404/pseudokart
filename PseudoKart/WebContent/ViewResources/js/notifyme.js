function notify(prodid){
var emailid =  document.getElementById('emailid').value;
	alert("Email " + emailid);
	alert("Product id" + prodid);
	xmlhttp=GetXmlHttpObject();
	var url="notified.jsp";
	url=url+"?email="+emailid;
	url=url+"&product="+prodid;
	
	
	xmlhttp.onreadystatechange=stateChanged;
	xmlhttp.open("GET",url,true);
	xmlhttp.send(null);
}

function stateChanged()
{
if (xmlhttp.readyState==4)
  {
  document.getElementById("notifyme").innerHTML=xmlhttp.responseText;
}


}
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

