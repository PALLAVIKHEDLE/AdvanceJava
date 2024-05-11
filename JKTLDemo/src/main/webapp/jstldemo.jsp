<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
List<String> names= new ArrayList<String>();
names.add("Ram");
names.add("shayam");
%>
<% String variable=null;
%>
	<c:out value="${1+2}"></c:out>
	<c:set var="temp" value ="${50}"></c:set>
	<c:out value="${temp}"></c:out>
<%-- 	<c:remove var="temp"></c:remove>
	<c:out value="${temp}"></c:out> --%>
	<c:out value="${variable}"></c:out>
	<h1>IF</h1>
	<c:if test="${temp<100}">
		<h1>temp is less then 100</h1>
	</c:if>
	<h1>Choose</h1>
	<!-- Otherwise is default -->
	<c:choose>
		<c:when test="${temp>100}"><h1>Temp is greater then 100</h1></c:when>
		<c:when test="${temp<100}"><h1>Temp is less then 100</h1></c:when>
		<c:otherwise>Temp is 100</c:otherwise>
	</c:choose>
		<h1>Url</h1>
	 <a href='<c:url value="/temp.jsp"/>'>This is a link</a>
	 	h1>Loop</h1>
	 <c:forEach var='i' begin='1' end="10">
	 	i value<c:out value="${i}"></c:out><br>
	 </c:forEach>
	  	<h1>For Loop for list </h1>
	 <!-- Output names list size -->
<c:out value="Names list size: ${names.size()}"/><br/>

<!-- Output each name in the list -->
<c:forEach var="name" items="${names}">
    Name: <c:out value="${name}"/><br/>
</c:forEach>
</body>
</html>