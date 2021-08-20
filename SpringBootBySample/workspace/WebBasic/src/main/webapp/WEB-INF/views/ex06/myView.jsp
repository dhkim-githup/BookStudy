<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("Model(2) : Hello World");
%>
<p>
ObjectTest : ${ObjectTest} 
<p>
list : ${lists}
<p>
name : ${name}

<p>

<c:forEach var="myList" items="${lists}">
	${myList}<br>
</c:forEach>

</body>
</html>