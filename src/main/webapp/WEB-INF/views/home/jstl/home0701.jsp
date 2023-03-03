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
	<h3>home0701</h3>
	<hr><br>
	
	<c:forEach items="${member.hobbyArray }" var="hobby">
		${hobby }<br>
	</c:forEach>
</body>
</html>