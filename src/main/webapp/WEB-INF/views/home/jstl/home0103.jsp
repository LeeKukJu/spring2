<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0101</title>
</head>
<body>
	<h3>home0101</h3>
	<hr><br>
	
	<table border="1">
		<tr>
			<td>member.userId</td>
			<td>${member.userId }</td>
		</tr>
		
		<tr>
			<!-- escapeXml은 태그가 태그의 역할을 하도록 false설정 -->
			<td>member.userId</td>
			<td> <c:out value="${member.userId }" escapeXml="false"/> </td>
		</tr>
	</table>
</body>
</html>