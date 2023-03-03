<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0301</title>
</head>
<body>
	<p>now : ${now }</p>
	<p>time default : <fmt:formatDate value="${now }" type="time" timeStyle="default"/></p>
	<p>time short : <fmt:formatDate value="${now }" type="time" timeStyle="short"/></p>
	<p>time medium : <fmt:formatDate value="${now }" type="time" timeStyle="medium"/></p>
	<p>time long : <fmt:formatDate value="${now }" type="time" timeStyle="long"/></p>
	<p>time full : <fmt:formatDate value="${now }" type="time" timeStyle="full"/></p>
	<!-- 
		dateStyle에 대한 출력 형태를 보고, 원하는 출력 패턴으로 설정하면 된다.
	 -->
	
</body>
</html>