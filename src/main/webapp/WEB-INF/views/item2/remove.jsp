<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item2 Modify</title>
</head>
<body>
	<h2>Remove</h2>
	<hr><br>
	<form action="/item2/remove" method="post">
		<input type="hidden" name="itemId" value="${item.itemId }">
		<table border="1">
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="itemName" id="itemName" value="${item.itemName }" disabled="disabled">
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type="text" name="price" id="price" value="${item.price }" disabled="disabled">
				</td>
			</tr>
			<tr>
				<td>파일1</td>
				<td>
					<img alt="" src="/item2/display?itemId=${item.itemId }" width="210" height="240">
<%-- 					<img alt="" src="/resources/upload/${item.pictureUrl }" width="210" height="240"> --%>
				</td>
			</tr>
			<tr>
				<td>파일2</td>
				<td>
					<img alt="" src="/item2/display2?itemId=${item.itemId }" width="210" height="240">
<%-- 					<img alt="" src="/resources/upload/${item.pictureUrl }" width="210" height="240"> --%>
				</td>
			</tr>
			<tr>
				<td>개요</td>
				<td>
					<textarea rows="10" cols="30" name="description" disabled="disabled">${item.description }</textarea>
				</td>
			</tr>
		</table>
		<div>
			<button type="submit" id="removeBtn">Remove</button>
			<button type="button" id="listBtn" onclick="javascript:location.href='/item2/list'">List</button>
		</div>
	</form>
</body>
</html>