<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form Result</title>
</head>
<body>
	<h2>Result</h2>
	<table>
		<tr>
			<td>유저 ID</td>
			<td>${member.userId }</td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td>${member.password }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${member.userName }</td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td>${member.email }</td>
		</tr>
		<tr>
			<td>소개</td>
			<td>${member.introduction }</td>
		</tr>
		<tr>
			<td>취미 목록</td>
			<td>
				<c:forEach items="${member.hobbyList }" var="hobby">
					<c:out value="${hobby }"/>
				</c:forEach>
			</td>
		</tr>
	</table>
</body>
</html>