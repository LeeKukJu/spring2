<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0303</title>
</head>
<body>
	<p>now : ${now }</p>
	<p>both default : <fmt:formatDate value="${now }" type="both" dateStyle="default" timeStyle="default"/></p>
	<p>both short : <fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short"/></p>
	<p>both medium : <fmt:formatDate value="${now }" type="both" dateStyle="medium" timeStyle="medium"/></p>
	<p>both long : <fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="long"/></p>
	<p>both full : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/></p>
	<!-- 
		dateStyle에 대한 출력 형태를 보고, 원하는 출력 패턴으로 설정하면 된다.
	 -->
	
</body>
</html>