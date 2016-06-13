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
<c:forEach items="${sessionScope.lslist}" var="as">
	<table  cellpadding="0" cellspacing="0" width="50%"">
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">E-mail id</td>
			<td>${as.eMailID} </td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">First Name</td>
			<td>${as.fName} </td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Last Name</td>
			<td>${as.lName} </td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Middle Name</td>
			<td>${as.mName} </td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Home Phone</td>
			<td>${as.hPhone} </td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Work Phone</td>
			<td>${as.wPhone} </td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Mobile Phone</td>
			<td>${as.mPhone} </td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Group ID</td>
			<td>${as.groupID} </td>
		</tr>
		<br>
	</table>
</c:forEach>
</center>




</body>

	

</html>
<%@include file="footer.html"%>