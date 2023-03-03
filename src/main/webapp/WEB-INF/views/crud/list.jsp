<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crud Board List</title>
</head>
<body>
	<h2>LIST</h2>
	<hr><br>
	
	<a href="/crud/board/register">등록</a>
	
	<form action="/crud/board/search" method="post">
		<input type="text" name="title" value="">
		<input type="submit" value="등록">
	</form>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4">조회하실 게시물이 존재하지 않습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="board">
					<tr>
						<td>${board.boardNo }</td>
						<td>
							<a href="/crud/board/read?boardNo=${board.boardNo }">
								${board.title }
							</a>
						</td>
						<td>${board.writer }</td>
						<td>
							<fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd hh:mm"/>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
	</table>
</body>
</html>