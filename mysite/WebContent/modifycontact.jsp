<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.html"%>

<html>
<head>
<title>View Contact Success page</title>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

<center>
<h2>View Contact</h2>
<%@include file="displayformerrors.jsp"%>
</center>
<!--Body: view contact information-->
<center>
<jsp:useBean id="emailVO" class="VO.EmailAddressVO" scope="session" >
</jsp:useBean>
<br>
<form method="post" action="/mysite/servlets/editemailaddress">
<input type="hidden" name="flag" value="fetch">

<c:forEach items="${sessionScope.lslist}" var="as">

<input type="text" name="id" value="${as.id}">
	<table  cellpadding="0" cellspacing="0" width="50%"">
	<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">E-mail id</td>
			<td><input type="text" name="emailid" value="${as.eMailID}"></input> </td>
		</tr>
		
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">First Name</td>
			<td><input type="text" name="fname" value="${as.fName}"> </td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Last Name</td>
			<td><input type="text" name="lname" value="${as.lName}"> </td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Middle Name</td>
			<td><input type="text" name="mname" value="${as.mName}"> </td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Home Phone</td>
			<td><input type="text" name="hphone" value="${as.hPhone}"> </td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Work Phone</td>
			<td><input type="text" name="wphone" value="${as.wPhone}"> </td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Mobile Phone</td>
			<td><input type="text" name="mphone" value="${as.mPhone}"> </td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Group ID</td>
			<td><select id="group" name="group" style=width:15em; >
<option>select one</option>
<c:forEach items="${sessionScope.lsGroup}" var="ls">
			<option>${ls.gName}</option>
			
</c:forEach>
		</select> </td>
		</tr>
		
	</table>
	<input type="submit" name="update" value="submit"/>
	
</c:forEach>
</form>
</center>




</body>

	

</html>
<%@include file="footer.html"%>