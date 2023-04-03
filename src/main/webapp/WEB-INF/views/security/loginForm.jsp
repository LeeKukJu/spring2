<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<title>LoginForm</title>
</head>
<body>
	<h3>${error }</h3>
	<h3>${logout }</h3>

	<!-- 로그인 폼 페이지 -->
	<div class="login-box" style="text-align: center; margin: auto;">
		<div class="login-logo">
			<a href="../../index2.html">
				<b>Admin</b>LTE
			</a>
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body login-card-body">
				<p class="login-box-msg">Sign in to start your session</p>
				
				<!-- 
					요청 URI : /login
					요청 방식 : post
					요청 파라미터 : username=2?password=1234&remember-me=on
				 -->
				<form action="/login" method="post">
					<div class="input-group mb-3">
						<input type="text" name="username" class="form-control" placeholder="아이디를 입력해주세요." required/>
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" name="password" class="form-control" placeholder="비밀번호를 입력해주세요." required>
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-8">
							<div class="icheck-primary">
								<input type="checkbox" name="remember-me" id="remember">
								<label for="remember"> Remember Me </label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-4">
							<button type="submit" class="btn btn-primary btn-block">로그인</button>
						</div>
						<!-- /.col -->
					</div>
					<sec:csrfInput />
				</form>
			</div>
			<!-- /.login-card-body -->
		</div>
	</div>
	<!-- 로그인 폼 페이지 끝 -->

</body>
</html>