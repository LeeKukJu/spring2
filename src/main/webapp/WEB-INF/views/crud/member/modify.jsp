<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crud Member Modify</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	var btnModify = $("#btnModify");
	var btnList = $("#btnList");
	var member = $("#member");
	
	btnModify.on("click", function() {
		if($("#userName").val() == null || $("#userName").val() == ""){
			alert("이름을 입력해주세요.");
			return false;
		}
		member.submit();
	});
	
	btnList.on("click", function() {
		location.href = "/crud/member/list"
	});
	
});
</script>
<body>
	<h2>Modify</h2>
	<hr><br>
	
	<form action="/crud/member/modify" method="post" id="member">
		<input type="hidden" name="userNo" value="${member.userNo }">
		<table>
			<tr>
				<td>번호</td>
				<td>
					${member.userNo }
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="userId" value="${member.userId }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="userName" id="userName" value="${member.userName }">
				</td>
			</tr>
			<tr>
				<td>권한1</td>
				<td>
					<select name="authList[0].auth">
						<option>=====선택해주세요=====</option>
						<option value="ROLE_USER" <c:if test="${member.authList[0].auth eq 'ROLE_USER' }">selected</c:if>>사용자</option>
						<option value="ROLE_MEMBER" <c:if test="${member.authList[0].auth eq 'ROLE_MEMBER' }">selected</c:if>>회원</option>
						<option value="ROLE_ADMIN" <c:if test="${member.authList[0].auth eq 'ROLE_ADMIN' }">selected</c:if>>관리자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>권한2</td>
				<td>
					
					<select name="authList[1].auth">
						<option>=====선택해주세요=====</option>
						<option value="ROLE_USER" <c:if test="${member.authList[1].auth eq 'ROLE_USER' }">selected</c:if>>사용자</option>
						<option value="ROLE_MEMBER" <c:if test="${member.authList[1].auth eq 'ROLE_MEMBER' }">selected</c:if>>회원</option>
						<option value="ROLE_ADMIN" <c:if test="${member.authList[1].auth eq 'ROLE_ADMIN' }">selected</c:if>>관리자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>권한3</td>
				<td>
					<select name="authList[2].auth">
						<option>=====선택해주세요=====</option>
						<option value="ROLE_USER" <c:if test="${member.authList[2].auth eq 'ROLE_USER' }">selected</c:if>>사용자</option>
						<option value="ROLE_MEMBER" <c:if test="${member.authList[2].auth eq 'ROLE_MEMBER' }">selected</c:if>>회원</option>
						<option value="ROLE_ADMIN" <c:if test="${member.authList[3].auth eq 'ROLE_ADMIN' }">selected</c:if>>관리자</option>
					</select>
				</td>
			</tr>
		</table>
		<div>
			<button type="button" id="btnModify">수정</button>
			<button type="button" id="btnList">목록</button>
		</div>
	</form>
	
</body>
</html>