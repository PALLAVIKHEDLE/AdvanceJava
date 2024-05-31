<%@ page import="com.apex.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
 <%
 out.println(request.getAttribute("user"));
 User user = (User) request.getAttribute("user");
 out.println(user.getName());  
 %>
</h1>
</body>
</html>