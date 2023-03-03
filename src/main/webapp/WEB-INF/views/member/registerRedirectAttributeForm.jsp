<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register RedirectAttribute Form</title>
</head>
<body>
	<h3>registerRedirectAttributeForm</h3>
	<hr><br>
	
	<form action="/redirectattribute/register" method="post">
		userId : <input type="text" name="userId" value="hongkd">
		password : <input type="text" name="password" value="1234">
		<input type="submit" value="register">
	</form>
</body>
</html>