<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<title>LoginForm</title>
</head>
<body>
	<h3>loginForm</h3>
	<h2>${error }</h2>
	<h2>${logout }</h2>
	
	<!-- 스프링 시큐리티에서 name 속성에 username 과 password 명칭은 고정 -->
	<form action="/login" method="post">
		<p>User ID : <input type="text" name="username" value="" 
			placeholder="아이디를 입력해주세요"> </p>
		<p>Password :<input type="text" name="password" value="" 
			placeholder="비밀번호를 입력해주세요."> </p>
		<p><input type="submit" value="로그인"> </p>
		
		<!-- 로그인 상태 유지 체크박스 / name명 remember-me로 꼭 서야함-->
		<p><input type="checkbox" name="remember-me"/>Remember Me</p>
		<sec:csrfInput/>
	</form>
	
</body>
</html>