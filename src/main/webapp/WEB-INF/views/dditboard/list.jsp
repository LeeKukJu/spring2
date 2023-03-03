<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DDIT BOARD LIST</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	var btnRegister = $("#btnRegister");
	
	btnRegister.on("click", function() {
		location.href = "/ddit/register";
	});
});
</script>
<body>
	<button type="button" id="btnRegister">등록</button>
	
	<table border="1" width = "600">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="5">조회하신 게시글이 존재하지 않습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="board" varStatus="stat">
					<tr>
						<td style="text-align:center">${fn:length(list)-stat.index }</td>
						<td>
							<a href="/ddit/detail?boNo=${board.boNo }">
								${board.boTitle }
							</a>
						</td>
						<td>${board.boWriter }</td>
						<td style="text-align:center">
							<fmt:formatDate value="${board.boDate }" pattern="yyyy-MM-dd hh:mm"/> 
						</td>
						<td style="text-align:center">${board.boHit }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
	</table>
	<div>
		<form action="/ddit/search" method="post">
			<select name="searchType">
				<option value="title">제목</option>
				<option value="writer">작성자</option>
				<option value="titleWriter">제목+작성자</option>
			</select>
			<input type="text" name="searchWord">
			<input type="submit" value="검색">
		</form>
	</div>
</body>
</html>