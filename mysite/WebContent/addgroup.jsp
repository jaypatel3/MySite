<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script language="javascript" type="text/javascript">


function ajaxFunction(){
	var ajaxRequest;  // The variable that makes Ajax possible!
	
	try{
		// Opera 8.0+, Firefox, Safari
		ajaxRequest = new XMLHttpRequest();
	} catch (e){
		// Internet Explorer Browsers
		try{
			ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try{
				ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e){
				// Something went wrong
				alert("Your browser broke!");
				return false;
			}
		}
	}
	// Create a function that will receive data sent from the server
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			var ajaxDisplay = document.getElementById('ajaxDiv');
			ajaxDisplay.style.color = "green";
			ajaxDisplay.innerHTML = ajaxRequest.responseText;
		}
	}
		//var formObject = document.forms['myForm'];
		//var field =  formObject.elements['emailaddress'];
		var field = document.getElementById("group");
		
		alert(escape(field.selectedIndex.value));
		
		
		
		
	var queryString = "?emailid=" + escape(field.value);
	var url = "/mysite/SelectGroup" + queryString;
	ajaxRequest.open("GET",  url , true);
	ajaxRequest.send(null); 
}


function xyz(){
			var ajaxDisplay = document.getElementById('ajaxDiv');
			ajaxDisplay.innerHTML = "<font color=red> you are out the context </font>";

}
</script>

<center>
<form name="myForm" method="post"  >


<select id="group" name="group" style=width:15em; onChange="ajaxFunction()">
<option>select one</option>
<c:forEach items="${sessionScope.lsGroup}" var="ls">
			<option>${ls.gName}</option>
			
</c:forEach>
		</select>


<input type="submit" value ="submit">


</form>
<div id='ajaxDiv'>Getting Value</div>
</center>

</body>
<%@include file="footer.html"%>
</html>