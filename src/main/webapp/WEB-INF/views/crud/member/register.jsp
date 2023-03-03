<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crud Member Register</title>
</head>
<body>
	<h2>REGISTER</h2>
	<hr><br>
	
	<form:form action="/crud/member/register" method="post" modelAttribute="member">
		<table>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" id="userId" name="userId">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="text" id="userPw" name="userPw">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" id="userName" name="userName">
				</td>
			</tr>
		</table>
		<div>
			<button type="submit" id="">등록</button>
			<button type="button" id="">목록</button>
		</div>
	
	</form:form>
</body>
</html>