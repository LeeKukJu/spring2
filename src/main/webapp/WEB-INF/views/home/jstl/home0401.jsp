<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0401</title>
</head>
<body>
	<h3>home0401</h3>
	<hr><br>
	
	<c:catch var="ex">
		${member.hobbyArray[3] }
	</c:catch>
	
	<p>
		<c:if test="${ex != null }">
			${ex }
		</c:if>	
	</p>
</body>
</html>