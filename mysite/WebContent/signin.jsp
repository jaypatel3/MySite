<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<font color="red" size=20>Sign in </font>

<form method="post" action="/mysite/servlets/LoginController">

UserName<input type="text" name="username" />

<br>
PassWord<input type="password" name="password">
<input type="hidden" name="flag" value="login">
<input type="submit" name="submit" value="login"> 


</form>







</body>
</html>