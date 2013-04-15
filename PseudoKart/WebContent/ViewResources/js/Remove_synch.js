
window.i=0;
window.temp=null;
//window.str=null;
 function foo(qty,str) {
	
	
	var d=document.getElementById(str);
	temp=str.concat(qty);
	var temp2=qty.concat(str);
	window.str=str;
	
d.innerHTML="<td><input type='text' id='temp_div' maxlength='2' style="+"width:30px;height:"+"10px ><br /><a id='trial' href="+"#"+">Save</a></td>";
document.getElementById("temp_div").setAttribute('id',temp);
document.getElementById("trial").setAttribute('id',temp2);
document.getElementById(temp).value=qty;
document.getElementById(temp).setAttribute('maxlength',2);


document.getElementById(temp2).setAttribute("onclick","func()");

return true;
}


function func(){
	
	if(document.getElementById(temp).value!=0)
		i=document.getElementById(temp).value;
	
	xmlhttp=GetXmlHttpObject();
	var url="update_quantity.jsp";
	url=url+"?yourQuantity="+i;
	url=url+"&yourItem="+str;
	
	
	xmlhttp.onreadystatechange=stateChanged;
	xmlhttp.open("GET",url,true);
	xmlhttp.send(null);
	
}



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
	
	xmlhttp.onreadystatechange=stateChanged;
	xmlhttp.open("GET",url,true);
	xmlhttp.send(null);
	

}



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

