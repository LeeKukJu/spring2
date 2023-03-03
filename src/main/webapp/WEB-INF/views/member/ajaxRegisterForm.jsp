<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Register Form</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<body>
	<h1>9. Ajax 방식 요청 처리</h1>
	<hr><br>
	
	<h3>Ajax 방식 요청 처리</h3>
	
	<form>
		userId : <input type="text" name="userId" id="userId"><br> 
		password : <input type="text" name="password" id="password"><br> 
	</form>
	
	<h3>1) URL 경로 상의 경로 변수값을 @PathVariable 어노테이션을 지정하여 문자열 매개변수로 처리한다.</h3>
	<button id="registerBtn01">registerBtn01</button>
	<br>
	
	<h3>2) URL 경로 상의 여러개의 경로 변수값을 @PathVariable 어노테이션을 지정하여 문자열 매개변수로 처리한다.</h3>
	<button id="registerBtn02">registerBtn02</button>
	<br>
	
	<h3>3) 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 자바빈즈 매개변수로 처리한다.</h3>
	<button id="registerBtn03">registerBtn03</button>
	<br>
	
	<h3>4) 객체 타입의 JSON 요청 데이터는 문자열 매개변수로 처리할 수 없다.</h3>
	<button id="registerBtn04">registerBtn05</button>
	<br>
	
	<h3>5) 요청 URL에 쿼리파라미터를 붙여서 전달하면 문자열 매개변수로 처리한다.</h3>
	<button id="registerBtn05">registerBtn05</button>
	<br>
	
	<h3>6) 객체 타입의 JSON 요청 데이터를 @PathVariable 어노테이션을 지정한 문자열 매개변수와 <br>
		@RequestBody 어노테이션을 지정한 자바빈즈 매개변수로 처리한다.</h3>
	<button id="registerBtn06">registerBtn06</button>
	<br>
	
	<h3>7) 객체 배열 타입의 JSON 요청 데이터를 자바빈즈 요소를 가진 리스트 컬렉션 매개변수에 @RequestBody 어노테이션을 지정하여 처리한다.</h3>
	<button id="registerBtn07">registerBtn07</button>
	<br>
	
	<h3>8) 중첩된 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다.</h3>
	<button id="registerBtn08">registerBtn08</button>
	<br>
	
	<h3>9) 중첩된 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다.</h3>
	<button id="registerBtn09">registerBtn09</button>
	<br>
	
	
	
</body>
<script type="text/javascript">
$(function(){
	var registerBtn01 = $("#registerBtn01");
	var registerBtn02 = $("#registerBtn02");
	var registerBtn03 = $("#registerBtn03");
	var registerBtn04 = $("#registerBtn04");
	var registerBtn05 = $("#registerBtn05");
	var registerBtn06 = $("#registerBtn06");
	var registerBtn07 = $("#registerBtn07");
	var registerBtn08 = $("#registerBtn08");
	var registerBtn09 = $("#registerBtn09");
	
	// 1)
	registerBtn01.on("click", function(){
		$.get("/ajax/register/hongkd", function(result){
			console.log("result : " + result);
			if(result === "SUCCESS"){
				alert(result);
			}
		});
	});
	
	// 2)
	registerBtn02.on("click", function(){
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObj = {
				userId : userIdVal,
				password : passwordVal
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register/hongkd/pw01",
			data : JSON.stringify(userObj),
			contentType : "application/json; charset=utf-8",
			success: function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	// 3) 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 자바빈즈 매개변수로 처리한다.
	registerBtn03.on("click", function() {
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObj = {
				userId : userIdVal,
				password : passwordVal
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register03",
			data : JSON.stringify(userObj),
			contentType : "application/json; charset=utf-8",
			success: function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	// 4) 객체 타입의 JSON 요청 데이터는 문자열 매개변수로 처리할 수 없다.
	registerBtn04.on("click", function(){
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObj = {
				userId : userIdVal,
				password : passwordVal
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register04",
			data : JSON.stringify(userObj),
			contentType : "application/json; charset=utf-8",
			success: function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		})
	});
	
	// 5) 요청 URL에 쿼리파라미터를 붙여서 전달하면 문자열 매개변수로 처리한다.
	registerBtn05.on("click", function(){
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObj = {
				userId : userIdVal,
				password : passwordVal
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register05?userId=a001",
			data : JSON.stringify(userObj),
			contentType : "application/json; charset=utf-8",
			success: function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		})
	});
	
	// 6) 객체 타입의 JSON 요청 데이터를 @PathVariable 어노테이션을 지정한 문자열 매개변수와 
// 		@RequestBody 어노테이션을 지정한 자바빈즈 매개변수로 처리한다.
	registerBtn06.on("click", function(){
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObj = {
				userId : userIdVal,
				password : passwordVal
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register06/" + userIdVal,
			data : JSON.stringify(userObj),
			contentType : "application/json; charset=utf-8",
			success: function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		})
	});
	
	// 7) 객체 배열 타입의 JSON 요청 데이터를 자바빈즈 요소를 가진 리스트 컬렉션 매개변수에 @RequestBody 어노테이션을 지정하여 처리한다.
	registerBtn07.on("click", function(){
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userArray = [
			{userId : "name01", password : "pw01"},
			{userId : "name02", password : "pw02"}
		]
		
		$.ajax({
			type : "post",
			url : "/ajax/register07",
			data : JSON.stringify(userArray),
			contentType : "application/json; charset=utf-8",
			success: function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		})
	});
	
	// 8) 중첩된 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다.
	registerBtn08.on("click", function(){
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObj = {
				userId : userIdVal,
				password : passwordVal,
				address : {
					postCode : "123456",
					location : "Daejeon"
				}
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register08",
			data : JSON.stringify(userObj),
			contentType : "application/json; charset=utf-8",
			success: function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		})
	});
	
	// 9) 중첩된 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다.
	registerBtn09.on("click", function(){
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObj = {
				userId : userIdVal,
				password : passwordVal,
				cardList : [
					{no : "23456", validMonth : "20221018"},
					{no : "12345", validMonth : "20230222"},
				]
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register09",
			data : JSON.stringify(userObj),
			contentType : "application/json; charset=utf-8",
			success: function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		})
	});
	
	
	
	
	
});
</script>
</html>