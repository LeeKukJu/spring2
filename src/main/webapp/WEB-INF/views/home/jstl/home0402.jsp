<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0402</title>
</head>
<body>
	<h3>home0402</h3>
	<hr><br>
	
	<%
		String[] hobbyArray = {"Music", "Movie"};
	%>
	
	<c:catch var="ex">
		<%=hobbyArray[3] %>
	</c:catch>
	
	<p>
		<c:if test="${ex != null }">
			${ex }
		</c:if>	
	</p>
</body>
</html>