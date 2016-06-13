<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
    <body>
    
    
	<c:forEach items="${sessionScope.emailobject}" var="as">
	
			
			${as.eMailID} <br>
		
			${as.fName}   <br> 
		
			${as.lName}  <br> 
		
			${as.mName} <br> 
	
			${as.hPhone} <br> 
	 
			${as.wPhone}  <br> 
		
			${as.mPhone}  <br> 
			
			${as.groupID}  <br> 
		
</c:forEach>
    </body>
</html>