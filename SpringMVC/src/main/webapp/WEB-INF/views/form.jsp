<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> <% out.println(request.getAttribute("message")); %></h1>
<form action="addStudent" method="post">
Name <input type="text" name="name"> <br>
College <input type="text" name="college"> <br>
Age <input type="text" name="age"> <br>
<input type="submit">
</form>
</body>
</html>