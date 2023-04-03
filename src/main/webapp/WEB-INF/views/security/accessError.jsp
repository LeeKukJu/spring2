<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Access Denied Page</title>
</head>
<body>
	<h3>Access Denied</h3>
	
	<h3><c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage() }"/> </h3>
	
	<h3><c:out value="${msg }"/> </h3>
	<p><img src="/resources/images/errorImage.jpg">
</body>
</html>