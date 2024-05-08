<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>

<% 
    String error = (String) session.getAttribute("error");
    String existingUsername = (String) session.getAttribute("existingUsername");
    if (error != null && !error.isEmpty()) {
%>
    <p style="color: red;"> <%= existingUsername %> <%= error %> </p>
<%
        session.setAttribute("error", null);
    } 
%>

<h1>Welcome To user Registration!</h1>
<form action='registrationServlet' method='post'>
FirstName:<input type='text' name='firstName'><br>
LastName:<input type='text' name='lastName'><br>
UserName:<input type='text' name='userName'><br>
Password:<input type='text' name='password'><br>
<input type='submit'>
</form>
</body>
</html>