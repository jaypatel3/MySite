<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
    <body>
    <form method="post" action="/mysite/GetGroupDtlsServlet">
    
    <c:forEach items="${sessionScope.lsGroup}" var="as">
	
			Group Name <input type="text" name="groupname" value="${as.gName}"/> 
			<br> 
			
			<br>
			  <input type="hidden" name="id" value="${as.gid}"/> 
		
		
			
		
</c:forEach>
   
	
		<input type="submit" value="submit">
</form>
    </body>
</html>