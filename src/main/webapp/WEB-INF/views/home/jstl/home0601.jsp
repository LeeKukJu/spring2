<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0601</title>
</head>
<body>
	<h3>home0601</h3>
	<hr><br>
	
	<c:choose>
		<c:when test="${member.gender == 'M' }">
			<p>Male</p>
		</c:when>
		<c:when test="${member.gender == 'F' }">
			<p>Female</p>
		</c:when>
		<c:otherwise>
			<p>Others</p>
		</c:otherwise>
		
	</c:choose>
</body>
</html>