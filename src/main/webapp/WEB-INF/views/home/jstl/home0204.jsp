<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0201</title>
</head>
<body>
	<h3>home0201</h3>
	<hr><br>
	
	<c:set target="${member }" property="userId" value="hongkildong"/>
	<table border="1">
		<tr>
			<td>member.userId</td>
			<td>${member.userId }</td>
		</tr>
		
	</table>
</body>
</html>