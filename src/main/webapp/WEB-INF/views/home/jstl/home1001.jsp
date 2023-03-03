<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home1001</title>
</head>
<body>
	<h3>home1001</h3>
	<hr><br>
	
	<p>절대 URL</p>
	
	<c:url value="http://localhost/board/list"/>
	
	<br>
	
	<p>상대 URL - 절대경로</p>
	<c:url value="/board/list"/>
	
	<p>상대 URL - 상대경로</p>
	<c:url value="../../board/list.jsp"/>
	<br>
</body>
</html>