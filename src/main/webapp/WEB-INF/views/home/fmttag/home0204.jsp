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
	<fmt:formatNumber value="${coin }" var="coinNum" pattern="0,000.00"/>
	<p>coinNum : ${coinNum }</p>
	<!-- 
		parseNumber로 인식이 잘 되지 않는다....
		하여 formatNumber로 설정한다.
		
		parseNumber로 pattern을 지정하는건 '#,#00.0#' 형태로 설정한 패턴이 먹히기는 하나
		이마저도 안돼!! 그러면 (formatNumber로 설정하세요)
	 -->	
</body>
</html>