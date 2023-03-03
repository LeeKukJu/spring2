<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home1101</title>
</head>
<body>
	<h3>home1101</h3>
	<hr><br>
	
	<p>지정한 페이지로 리다이렉트 시킨다.</p>
	<c:redirect url="http://localhost/board/list"/>
	
	
	<h4>redirect 이후의 코드는 실행되지 않는다.</h4>
	
	
</body>
</html>