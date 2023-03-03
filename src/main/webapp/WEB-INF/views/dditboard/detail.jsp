<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DDIT BOARD DETAIL</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	var btnModify = $("#btnModify");
	var btnDelete = $("#btnDelete");
	var btnList = $("#btnList");
	var delForm = $("#delForm");
	
	btnModify.on("click", function() {
		delForm.attr("action", "/ddit/modify");
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
		location.href = "/ddit/list";
	});
});	
</script>
<body>
	<table border="1">
		<tr>
			<td>제목</td>
			<td>${board.boTitle }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.boWriter }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${board.boContent }</td>
		</tr>
		<tr>
			<td>태그1</td>
			<td>${board.tagList[0].tagName }</td>
		</tr>
		<tr>
			<td>태그2</td>
			<td>${board.tagList[1].tagName }</td>
		</tr>
		<tr>
			<td>태그3</td>
			<td>${board.tagList[2].tagName }</td>
		</tr>
	</table>
	<form action="/ddit/remove" method="post" id="delForm">
		<input type="hidden" name="boNo" value="${board.boNo }">
	</form>
	<div>
		<button type="button" id="btnModify">수정</button>
		<button type="button" id="btnDelete">삭제</button>
		<button type="button" id="btnList">목록</button>
	</div>
</body>
</html>