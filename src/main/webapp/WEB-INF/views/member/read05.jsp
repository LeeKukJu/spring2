<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read05</title>
</head>
<body>
	<h3>5)</h3>
	
	<h4>user.address : </h4>
	user.address.postCode : ${user.address.postCode }<br>
	user.address.location : ${user.address.location }<br>
	
	<h4>user.cardList : </h4>
	<c:forEach items="${user.cardList }" var="card">
		<c:out value="${card.no } ${card.validMonth }"/><br>
	</c:forEach>
	<br>
	<c:forEach items="${user.cardList }" var="card">
		<c:out value="${card.no }"/><br>
		<c:out value="${card.validMonth }"/><br>
	</c:forEach>
	<br>
	<c:forEach items="${user.cardList }" var="card">
		${card.no }	${card.validMonth }<br>
	</c:forEach>
	
	
	
	
	
</body>
</html>