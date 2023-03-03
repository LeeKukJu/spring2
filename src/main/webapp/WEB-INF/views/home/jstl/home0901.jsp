<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0901</title>
</head>
<body>
	<h3>home0901</h3>
	<hr><br>
	
	<p>절대 URL</p>
	
	<c:import url="http://localhost/board/list"/>
	
	<c:import url="http://localhost/board/search">
		<c:param name="keyword" value="orange"/>
	</c:import>
	
	<br>
	
	<p>상대 URL - 절대경로</p>
	<c:import url="http://localhost/board/list"/>
	
	<p>상대 URL - 상대경로</p>
	<c:import url="../../board/list.jsp"/>
	<br>
</body>
</html>