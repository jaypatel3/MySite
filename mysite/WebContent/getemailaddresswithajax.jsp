<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="header.html"%>
<html>
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
		var field = document.getElementById("emailaddress");
		
		alert(escape(field.selectedIndex.value));
		
		
		
		
	var queryString = "?emailid=" + escape(field.value) ;
	var url = "/mysite/getemailaddresswithAjax" + queryString;
	ajaxRequest.open("GET",  url , true);
	ajaxRequest.send(null); 
}


function xyz(){
			var ajaxDisplay = document.getElementById('ajaxDiv');
			ajaxDisplay.innerHTML = "<font color=red> you are out the context </font>";

}
</script>



<form name="myForm">
 First name <input type="text" name="firstname" id="fname"/>
Email addresslist 
<select id="emailaddress" name="emailaddress" onChange="ajaxFunction()">
<option>Choose One</option>
<c:forEach items="${sessionScope.lslist }" var="as">
	<option>${as.eMailID }</option>
	
	</c:forEach>
</select>
</form>

<div id='ajaxDiv'>Initial text</div>
</body>
<%@include file="footer.html"%>

</html>
