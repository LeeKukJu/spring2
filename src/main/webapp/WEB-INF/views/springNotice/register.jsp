<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Notice</title>
</head>
<body>
	<h3>NOTICE REGISTER : 로그인한 관리자만 접근 가능</h3>

	<form action="/logout" method="post">
		<input type="submit" value="로그아웃" />
		<sec:csrfInput/>
	</form>
</body>
</html>