<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register ModelAttribute Form</title>
</head>
<body>
	<h3>3. @ModelAttribute 어노테이션</h3>
	<hr><br>
	
	<h3>1) 기본 자료형은 매개변수로 선언하더라도 기본적으로 전달되지 않는다.</h3>
	<form action="/modelattribute/register01" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="submit" value="register01">
	</form>
	<br>
	
	<h3>2) 기본 자료형인 매개변수에 @ModelAttribute 어노테이션을 지정하여 데이터를 전달한다.</h3>
	<form action="/modelattribute/register02" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="submit" value="register02">
	</form>
	<br>
	
	<h3>3) 기본 자료형인 매개변수에 @ModelAttribute 어노테이션을 지정하여 데이터를 전달한다.</h3>
	<form action="/modelattribute/register03" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="submit" value="register03">
	</form>
	<br>
	
	<h3>4) 자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 기본적으로 전달된다.</h3>
	<form action="/modelattribute/register04" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="submit" value="register04">
	</form>
	<br>
	
	<h3>5) 자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 기본적으로 전달된다.2</h3>
	<form action="/modelattribute/register04" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		postCode : <input type="text" name="address.postCode" value="080988"><br>
		location : <input type="text" name="address.location" value="대전시 중구 오류동"><br>
		<input type="submit" value="register04">
	</form>
	<br>
</body>
</html>