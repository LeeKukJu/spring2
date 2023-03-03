<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crud Member Read</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var btnModify = $("#btnModify");
	var btnDelete = $("#btnDelete");
	var btnList = $("#btnList");
	var delForm = $("#delForm");
	
	btnModify.on("click", function() {
		delForm.attr("action", "/crud/member/modify");
		delForm.attr("method", "get");
		delForm.submit();
	});
	
	btnDelete.on("click", function() {
		if(confirm("정말로 삭제하시겠습니까?")){
			delForm.submit();
		}else {
			delForm.reset();
		}
	});
	
	btnList.on("click", function() {
		location.href = "/crud/member/list"
	});
	
});
</script>
<body>
	<h2>Read</h2>
	<hr><br>
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td>${member.userNo }</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${member.userId }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${member.userName }</td>
		</tr>
		<tr>
			<td>권한1</td>
			<td>${member.authList[0].auth }</td>
		</tr>
		<tr>
			<td>권한2</td>
			<td>${member.authList[1].auth }</td>
		</tr>
		<tr>
			<td>권환3</td>
			<td>${member.authList[2].auth }</td>
		</tr>
	</table>
	<div>
	<form action="/crud/member/remove" method="post" id="delForm">
		<input type="hidden" name="userNo" value="${member.userNo }">
	</form>
		<button type="button" id="btnModify">수정</button>
		<button type="button" id="btnDelete">삭제</button>
		<button type="button" id="btnList">목록</button>
	</div>
</body>
</html>