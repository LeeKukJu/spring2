<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESULT</title>
</head>
<body>
	<h3>Result</h3>
	<hr><br>
	
	userId : ${userId }<br>
	password : ${password }<br>
	<hr>
	
	member.userId : ${member.userId }<br>
	member.password : ${member.password }<br>
	
	<c:if test="${not empty member.address.postCode }">
		member.address.postCode : ${member.address.postCode }<br>
	</c:if>
	
	<c:if test="${not empty member.address.location }">
		member.address.location : ${member.address.location }<br>
	</c:if>
	
	msg: ${msg }
</body>
</html>