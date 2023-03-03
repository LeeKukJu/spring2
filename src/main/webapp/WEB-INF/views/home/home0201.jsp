<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0201</title>
</head>
<body>
	<h3>HOME0201</h3>
	<table border="1">
		<tr>
			<td>\${coin }</td>
			<td>${coin }</td>
		</tr>
		<tr>
			<td>\${coin + 100}</td>
			<td>${coin + 100}</td>
		</tr>
		<tr>
			<td>\${coin - 100}</td>
			<td>${coin - 100}</td>
		</tr>
		<tr>
			<td>\${coin * 100}</td>
			<td>${coin * 100}</td>
		</tr>
		<tr>
			<td>\${coin / 100}</td>
			<td>${coin / 100}</td>
		</tr>
		<tr>
			<td>\${coin / 100}</td>
			<td>${coin div 100}</td>
		</tr>
		<tr>
			<td>\${coin % 100}</td>
			<td>${coin % 100}</td>
		</tr>
		<tr>
			<td>\${coin % 100}</td>
			<td>${coin mod 100}</td>
		</tr>
	</table>
</body>
</html>