<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0103</title>
</head>
<body>
	<h3>HOME0103</h3>
	<table border="1">
		<tr>
			<td>\${member.userId }</td>
			<td>${memberMap["userId"] }</td>
		</tr>
		<tr>
			<td>\${member.password }</td>
			<td>${memberMap["password"] }</td>
		</tr>
		<tr>
			<td>\${member.userName }</td>
			<td>${memberMap["userName"] }</td>
		</tr>
		<tr>
			<td>\${member.email }</td>
			<td>${memberMap["email"] }</td>
		</tr>
		<tr>
			<td>\${member.dateOfBirth }</td>
			<td>${memberMap["dateOfBirth"] }</td>
		</tr>
		
	</table>
</body>
</html>