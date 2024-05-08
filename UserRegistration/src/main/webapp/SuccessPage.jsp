<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Logged in</title>
</head>
<body>
<%
if(session.getAttribute("userName") == null){
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginPage.jsp");
	requestDispatcher.forward(request, response);
} 
%>
<h1> Welcome User <%= session.getAttribute("userName") %>!</h1>
</body>
</html>