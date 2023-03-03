<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0101</title>
</head>
<body>
	<h3>home0101</h3>
	
	<p>number : ${coin }</p>
	<p>currency : <fmt:formatNumber value="${coin }" type="currency"/>
	<p>percent : <fmt:formatNumber value="${coin }" type="percent"/>
	<p>pattern : <fmt:formatNumber value="${coin }" pattern="000000.00"/>
	<p>pattern : <fmt:formatNumber value="123456789" pattern="000,000,000"/>
	
</body>
</html>