<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0203</title>
</head>
<body>
	<h3>home0203</h3>
	
	<p>coin : ${coin }</p>
	<fmt:parseNumber value="${coin }" var="coinNum" type="percent"/>
	<p>coinNum : ${coinNum }</p>
	
</body>
</html>