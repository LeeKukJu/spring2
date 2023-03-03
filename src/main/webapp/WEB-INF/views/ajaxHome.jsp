<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AjaxHome</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<body>
	<h1>AjaxHome</h1>
	<hr />
	<br />

	<h5>Common Input Area</h5>
	<form action="">
		boardNo : <input type="text" name="boardNo" id="boardNo" /><br />
		title : <input type="text" name="title" id="title" /><br /> content
		:
		<textarea rows="10" cols="30" name="content" id="content"></textarea>
		<br /> writer : <input type="text" name="writer" id="writer" /><br />
		<input type="button" id="btnSubmit" value="전송" /><br />
	</form>
	<hr />
	<br />

	<!-- 5. Headers 매핑 -->
	<h3>Headers 매핑</h3>
	<div>
		<button id="putBtn">MODIFY(PUT)</button>
		<button id="putHeaderBtn">MODIFY(PUT With Header)</button>
	</div>

	<!-- 6. Content Type 매핑 -->
	<h3>Content-Type 매핑</h3>
	<div>
		<button id="postBtn">MODIFY(POST)</button>
		<button id="putContentTypeJsonBtn">MODIFY(PUT With ContentType json)</button>
		<button id="putContentTypeXmlBtn">MODIFY(PUT With ContentTypexml)</button>
	</div>
	
	<!-- 7. Accept 매핑 -->
	<h3>Accept 매핑</h3>
	<div>
		<button id="getBtn">READ</button>
		<button id="getJsonBtn">READ(JSON)</button>
		<button id="getXmlBtn">READ(XML)</button>
	</div>
</body>
<script type="text/javascript">
$(function(){
	// 5. Headers 매핑
	// - 요청 헤더값을 지정하지 않고 전송
	$("#putBtn").on("click", function(){
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var boardObject = {
			boardNo : boardNoVal,
			title : titleVal,
			content : contentVal,
			writer : writerVal
		}
		
		// JSON.stringify()
		// - JSON 타입의 문자열로 만들어준다.
		// - jackson-databind 의존성이 정의되어 있지 않으면 에러가 발생한다.
		
		// jackson을 설정하지 않고, 그냥 호출을 하게 되면 415 Error가 발생한다.
		// 데이터 및 요청이 정확하게 넘어가지 않는다.
		// 브라우저에서 서버로 넘기는 길과 문이 일치하지 않기 때문이다.
		$.ajax({
			type: "put",
			url : "/board/" + boardNoVal,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);	// 넘어온 결과가 "SUCCESS"가 담겨 있다.
				}
			}
		});
	});
	
	$("#putHeaderBtn").on("click", function(){
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var boardObject = {
			boardNo : boardNoVal,
			title : titleVal,
			content : contentVal,
			writer : writerVal
		}
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNoVal,
			herders : {
				"X-HTTP-Method-Override" : "PUT"
			},
			data : JSON.stringify(boardObject),
			contentType : "application/json;charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);	// 넘어온 결과가 "SUCCESS"가 담겨 있다.
				}
			}
		});
	});
	
	// 6. Content Type 매핑
	$("#postBtn").on("click", function(){
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var boardObject = {
			boardNo : boardNoVal,
			title : titleVal,
			content : contentVal,
			writer : writerVal
		}
		
		$.ajax({
			type : "post",
			url : "/board/" + boardNoVal,
			data : JSON.stringify(boardObject),
			contentType : "application/json;charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		})
	});
	
	$("#putContentTypeJsonBtn").on("click", function(){
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var boardObject = {
			boardNo : boardNoVal,
			title : titleVal,
			content : contentVal,
			writer : writerVal
		}
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNoVal,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	$("#putContentTypeXmlBtn").on("click", function(){
        var boardNoVal = $("#boardNo").val();
        var titleVal = $("#title").val();
        var contentVal = $("#content").val();
        var writerVal = $("#writer").val();
        
        var xmlData = "";
        xmlData += "<Board>";
        xmlData += "<boardNo>" + boardNoVal + "</boardNo>";
        xmlData += "<title>" + titleVal + "</title>";
        xmlData += "<content>" + contentVal + "</content>";
        xmlData += "<writer>" + writerVal + "</writer>";
        xmlData += "<regDate>2022-10-12</regDate>";
        xmlData += "</Board>";
        
        $.ajax({
           type : "put",
           url : "/board/" + boardNoVal,
           data : xmlData,
           contentType : "application/xml; charset=utf-8",
           success : function(result){
              console.log("result : " + result);
              if(result === "SUCCESS"){
                 alert(result);
              }
           }
        });
     });
	
	// 7. Accept 매핑
	$("#getBtn").on("click", function(){
		var boardNoVal = $("#boardNo").val();
		
		console.log(boardNoVal);
		
		$.get("/board/" + boardNoVal, function(data){
			console.log(data);
			alert(JSON.stringify(data));
		});
	});
	
	$("#getJsonBtn").on("click", function(){
		var boardNoVal = $("#boardNo").val();
		
		console.log(boardNoVal);
		
		$.ajax({
			type : "get",
			url : "/board/" + boardNoVal,
			headers : {
				"Accept" : "application/json"
			},
			success : function(result){
				console.log("result : " + result);
				alert(JSON.stringify(result));
			}
		});
	});
	
	$("#getXmlBtn").on("click", function(){
		var boardNoVal = $("#boardNo").val();
		
		console.log(boardNoVal);
		
		$.ajax({
			type : "get",
			url : "/board/" + boardNoVal,
			headers : {
				"Accept" : "application/xml"
			},
			success : function(result){
				console.log("result : " + result);
				alert(xmlToString(result));
			}
		});
	});
	
});

function xmlToString(xmlData){
	var xmlString;
	
	// window.ActiveObject는 ActiveObject를 지원하는 브라우저면
	// Object를 리턴하고, 그렇지 않다면 null을 리턴합니다.
	// 비동기 통신을 지원하는 XMLHttpRequest객체를 사용할 수 있는지 없는지를 판단하기 위함
	if(window.ActiveObject){
		xmlString = xmlData.xml;
	}else {
		// 파싱된 XML 데이터를 String으로 변환
		xmlString = (new XMLSerializer()).serializeToString(xmlData);
	}
	return xmlString;
}
</script>
</html>
















