<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item3 Modify</title>
</head>
<script src="${pageContext.request.contextPath }/resources/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	var itemId = ${item.itemId};
	
	$.getJSON("/item3/getAttach/" + itemId, function(list){
		
		$(list).each(function() {
			console.log("data : " + this);
			var data = this;
			var str = "";
			
			if(checkImageType(data)){	// 이미지면 이미지태그를 이용한 출력형태
				str += "<div>";
				str += "	<a href='/item3/displayFile?fileName=" + data + "'>";
				str += "		<img src='/item3/displayFile?fileName=" + getThumbnailName(data) + "'/>";
				str += "	</a>";
				str += "</div>";
			}else {						// 파일이면 파일명에 대한 링크로만 출력
				str += "<div>";
				str += "	<a href='/item3/displayFile?fileName=" + data + "'>" + getOriginalName(data) + "</a>";
				str += "</div>";
			}
			
			$(".uploadedList").append(str);
		});
	});
	
	function getOriginalName(fileName){
		if(checkImageType(fileName)){
			return;
		}
		var idx = fileName.indexOf("_") + 1;	// UUID_원본파일명
		return fileName.substr(idx);
	}
	
	function getThumbnailName(fileName){
		var front = fileName.substr(0, 12);
		var end = fileName.substr(12);
		
		console.log("front : " + front);
		console.log("end : " + end);
		
		return front + "s_" + end;
	}
	
	function checkImageType(fileName){
		var pattern = /jpg|gif|png|jpeg/i;
		return fileName.match(pattern); // 패턴과 일치하면 true(너 이미지구나?)
	}
});
</script>
<body>
	<h2>Remove</h2>
	<hr><br>
	<form action="/item3/remove" method="post" id="item">
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
				<td>파일</td>
				<td>
					<div class="uploadedList"></div>
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
			<button type="button" id="listBtn" onclick="javascript:location.href='/item3/list'">List</button>
		</div>
	</form>
</body>
</html>