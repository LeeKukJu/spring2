<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0401</title>
</head>
<body>
	<p>dateValue : ${dateValue }</p>
	
	<!-- 
		넘겨받은 날짜 데이터를 long타입의 날짜 데이터가 들어왔을때 변환하기 위한 dateStyle 포맷을 long으로 설정하고 변환하면
		우리가 알고 있는 날짜 형식의 데이터로 변환된다.
		
		long 스타일의 날짜 데이터 ---) [long 스타일 변환 공간] ---) 날짜 변환
		full 스타일의 날짜 데이터 ---) [full 스타일 변환 공간] ---) 날짜 변환
	 -->
	<c:set value="20. 2. 1" var="dateValue1"/>
	<c:set value="2019년  2월  1일 (금)" var="dateValue2"/>
	<c:set value="2019년  2월  1일 금요일" var="dateValue3"/>
	<p>dateValue1 : <fmt:parseDate value="${dateValue1 }" type="date" dateStyle="short" var="date1"/></p>
	<p>dateValue2 : <fmt:parseDate value="${dateValue2 }" type="date" dateStyle="long" var="date2"/></p>
	<p>dateValue3 : <fmt:parseDate value="${dateValue3 }" type="date" dateStyle="full" var="date3"/></p>
	<p>date1 : ${date1 }</p>
	<p>date2 : ${date2 }</p>
	<p>date3 : ${date3 }</p>
</body>
</html>