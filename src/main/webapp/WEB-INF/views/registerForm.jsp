<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER FORM</title>
</head>
<body>
	<h1>Register Form</h1>
	<hr>
	
	<h3>컨트롤러 요청 처리</h3>
	<hr><br>
	
	<h4>1) URL 경로 상의 쿼리 파라미터 정보로 부터 요청 데이터를 취득할 수 있다.</h4>
	<a href="/register?userId=hongkd&password=1234">registerByParameter()</a>
	<br>
	
	<h4>2) URL 경로 상의 경로 변수로 부터 요청 데이터를 취득할 수 있다.</h4>
	<a href="/register/hongkd">registerByPath</a>
	<br>
	
	<h4>3) HTML 폼 필드명과 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.</h4>
	<form action="/register01" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		coin : <input type="text" name="coin" value="100"><br>
		<input type="submit" value="register01"><br>
	</form>
	<br>
	
	<h4>4) HTML 폼 필드가 여러개일 경우에도 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.</h4>
	<form action="/register02" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		coin : <input type="text" name="coin" value="100"><br>
		<input type="submit" value="register02"><br>
	</form>
	<br>
	
	<h4>5) HTML 폼 필드가 여러개일 경우에 컨트롤러 매개변수의 위치는 상관없다.</h4>
	<form action="/register03" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		coin : <input type="text" name="coin" value="100"><br>
		<input type="submit" value="register03"><br>
	</form>
	<br>
	
	<h4>6) HTML 폼 필드값이 숫자일 경우에는 컨트롤러 매개변수 타입이 문자열이면 그대로 문자열 형태로 요청 데이터를 취득한다.</h4>
	<form action="/register04" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		coin : <input type="text" name="coin" value="100"><br>
		<input type="submit" value="register04"><br>
	</form>
	<br>
	
	<h4>7) HTML 폼 필드값이 숫자일 경우에는 컨트롤러 매개변수 타입이 숫자형이면 숫자로 타입변환하여 요청 데이터를 취득한다.</h4>
	<form action="/register05" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		coin : <input type="text" name="coin" value="100"><br>
		<input type="submit" value="register05"><br>
	</form>
	<br>
	
	
	
	<h3>요청 데이터 처리 어노테이션</h3>
	<hr><br>
	
	<h4>1) URL 경로 상의 경로 변수가 여러 개일 때, @PathVariable 어노테이션을 사용하여 특정한 경로 변수명을 지정해준다.</h4>
	<a href="/register/hongkd/100">registerByPath</a>
	<br>
	
	<h4>2) HTML 폼 필드명과 컨트롤러 매개변수명이 일치(대소문자 구분)하지 않으면 요청을 처리할 수 없다.</h4>
	<form action="/register0201" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		coin : <input type="text" name="coin" value="100"><br>
		<input type="submit" value="register0201"><br>
	</form>
	<br>
	
	<h4>3) @RequestParam 어노테이션을 사용하여 특정한 HTML 폼의 필드명을 지정하여 요청을 처리한다.</h4>
	<form action="/register0202" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		coin : <input type="text" name="coin" value="100"><br>
		<input type="submit" value="register0202"><br>
	</form>
	<br>
	
	
	
	
	<h3>4. 요청 처리 자바빈즈</h3>
	<hr><br>
	
	<h4>1) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.</h4>
	<form action="/beans/register01" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		coin : <input type="text" name="coin" value="100"><br>
		<input type="submit" value="registerJaveBeans01"><br>
	</form>
	<br>
	
	<h4>2) 폼 텍스트 필드 요소값을 자바빈즈 매개변수와 기본 데이터 타입인 정수 타입 매개변수로 처리한다.</h4>
	<form action="/beans/register02" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		coin : <input type="text" name="coin" value="100"><br>
		<input type="submit" value="registerJaveBeans02"><br>
	</form>
	<br>
	
	<h4>3) 여러개의 폼 텍스트 필드 요소값을 매개변수 순서와 상관없이 매개변수명을 기준으로 처리한다.</h4>
	<form action="/beans/register03" method="post">
		uid : <input type="text" name="uid" value="50"><br>
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		coin : <input type="text" name="coin" value="100"><br>
		<input type="submit" value="registerJaveBeans03"><br>
	</form>
	<br>
	
	
	
	
	<h3>5. Date 타입 처리</h3>
	<hr><br>
	
	
	<h4>
		1) 쿼리 파라미터(dateOfBirth=1234)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환에 실패한다. <br>
		<font style="color:red;">400 Bad Request 에러 발생</font>
	</h4>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=1234">registerByGet01</a>
	<br>
	
	<h4>
		2) 쿼리 파라미터(dateOfBirth=2023-02-21)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환에 실패한다. <br>
		<font style="color:red;">400 Bad Request 에러 발생</font>
	</h4>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=2023-02-21">registerByGet01(2023-02-21)</a>
	
	<h4>
		3) 쿼리 파라미터(dateOfBirth=20230221)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환에 실패한다. <br>
		<font style="color:red;">400 Bad Request 에러 발생</font>
	</h4>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=20230221">registerByGet01(20230221)</a>
	
	<h4>
		4) 쿼리 파라미터(dateOfBirth=2023/02/21)로 전달받은 값이 날짜 문자열 형식에 맞아 Date 타입으로 변환에 한다. <br>
		<font style="color:green;">SUCCESS</font>
	</h4>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=2023/02/21">registerByGet01(2023/02/21)</a>
	<br>
	
	<h4>
		5) Member 매개변수와 쿼리 파라미터(dateOfBirth=20230221)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환에 실패한다. <br>
		<font style="color:red;">400 Bad Request 에러 발생</font>
	</h4>
	<a href="/registerByGet02?userId=hongkd&dateOfBirth=20230221">registerByGet01(Member)</a>
	<br>
	
	<h4>
		6) Member 매개변수와 쿼리 파라미터(dateOfBirth=20230221)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환에 실패한다. <br>
		<font style="color"red;">400 Bad Request 에러 발생</font>
	</h4>
	<form action="/register" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		dateOfBirth : <input type="text" name="dateOfBirth" value="20230221"><br>
		<input type="submit" value="register"><br>
	</form>
	<br>
	
	<h4>
		7) @DateTimeFormat 어노테이션 <br>
		Member 클래스의 dateOfBirth 필드에 @DateTimeFormat 어노테이션을 추가 후 패턴(yyyyMMdd) 설정
		패턴으로 설정한 형식에 맞춰 컨트롤러 메소드에서 받는 경우 날짜 데이터를받을 수 있다.
		(6번을 이용하여 테스드)
		<font style="color:green;">SUCCESS</font>
	</h4>
	
	
	
	
	<h3>7. 폼 방식 요청 처리</h3>
	<hr><br>
	
	<h4>1) 폼 텍스트 필드 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</h4>
	<form action="/registerUserId" method="post">
		userId : <input type="text" name="userId"><br>
		<input type="submit" value="registerUserId">
	</form>
	<br>
	
	<h4>2) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.</h4>
	<form action="/registerMemberUserId" method="post">
		userId : <input type="text" name="userId"><br>
		<input type="submit" value="registerMemberUserId">
	</form>
	<br>
	
	<h4>3) 폼 비밀번호 필드 요소값을 자바빈즈 매개변수로 처리한다.</h4>
	<form action="/registerPassword" method="post">
		password : <input type="password" name="password"><br>
		<input type="submit" value="registerPassword">
	</form>
	<br>
	
	<h4>4) 폼 라디오버튼 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</h4>
	<form action="/registerRadio" method="post">
		<input type="radio" name="gender" value="male" checked="checked">Male<br>
		<input type="radio" name="gender" value="female" checked="checked">female<br>
		<input type="radio" name="gender" value="other" checked="checked">other<br>
		<input type="submit" value="registerRadio">
	</form>
	<br>
	
	<h4>5) 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</h4>
	<form action="/registerSelect" method="post">
		nationality : <br>
		<select name="nationality">
			<option value="korea">대한민국</option>
			<option value="germany">독일</option>
			<option value="austrailia">호주</option>
			<option value="canada">캐나다</option>
		</select><br>
		<input type="submit" value="registerSelect">
	</form>
	<br>
	
	<h4>6) 복수 선택이 가능한 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</h4>
	<form action="/registerMultipleSelect01" method="post">
		cars : <br>
		<select name="cars" multiple="multiple">
			<option value="volvo">Volvo</option>
			<option value="jeep">jeep</option>
			<option value="bmw">BmW</option>
			<option value="audi">Audi</option>
		</select><br>
		<input type="submit" value="registerMultipleSelect01">
	</form>
	<br>
	
	<h4>7) 복수 선택이 가능한 폼 셀렉트 박스 요소값을 문자열 배열 타입 매개변수로 처리한다.</h4>
	<form action="/registerMultipleSelect02" method="post">
		cars : <br>
		<select name="carArray" multiple="multiple">
			<option value="volvo">Volvo</option>
			<option value="jeep">jeep</option>
			<option value="bmw">BmW</option>
			<option value="audi">Audi</option>
		</select><br>
		<input type="submit" value="registerMultipleSelect02">
	</form>
	<br>
	
	<h4>8) 복수 선택이 가능한 폼 셀렉트 박스 요소값을 문자열 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.(리스트는 처리 못함)</h4>
	<form action="/registerMultipleSelect03" method="post">
		cars : <br>
		<select name="carList" multiple="multiple">
			<option value="volvo">Volvo</option>
			<option value="jeep">jeep</option>
			<option value="bmw">BmW</option>
			<option value="audi">Audi</option>
		</select><br>
		<input type="submit" value="registerMultipleSelect03">
	</form>
	<br>
	
	<h4>9) 폼 체크박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</h4>
	<form action="/registerCheckbox01" method="post">
		<input type="checkbox" name="hobby" value="Sports">Sports<br>
		<input type="checkbox" name="hobby" value="Music">Music<br>
		<input type="checkbox" name="hobby" value="Movie">Movie<br>
		<input type="submit" value="registerMultipleSelect01">
	</form>
	<br>
	<h4>10) 폼 체크박스 요소값을 문자열 배열 타입 매개변수로 처리한다.</h4>
	<form action="/registerCheckbox02" method="post">
		<input type="checkbox" name="hobbyArray" value="Sports">Sports<br>
		<input type="checkbox" name="hobbyArray" value="Music">Music<br>
		<input type="checkbox" name="hobbyArray" value="Movie">Movie<br>
		<input type="submit" value="registerMultipleSelect02">
	</form>
	<br>
	<h4>11) 폼 체크박스 요소값을 문자열 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.</h4>
	<form action="/registerCheckbox03" method="post">
		<input type="checkbox" name="hobbyList" value="Sports">Sports<br>
		<input type="checkbox" name="hobbyList" value="Music">Music<br>
		<input type="checkbox" name="hobbyList" value="Movie">Movie<br>
		<input type="submit" value="registerMultipleSelect03">
	</form>
	<br>
	
	<h4>12) 폼 체크박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</h4>
	<form action="/registerCheckbox04" method="post">
		developer : <br>
		<input type="checkbox" name="developer" value="Y"><br>
		<input type="submit" value="registerCheckbox4">
	</form>
	<br>
	
	<h4>13) 폼 체크박스 요소값을 기본 데이터 타입인 불리언 타입 매개변수로 처리한다.</h4>
	<form action="/registerCheckbox05" method="post">
		foreigner : <br>
		<input type="checkbox" name="foreigner" value="true"><br>
		<input type="submit" value="registerCheckbox5">
	</form>
	<br>
	
	<h4>14) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.</h4>
	<form action="/registerAddress" method="post">
		postCode : <input type="text" name="postCode"><br>
		location : <input type="text" name="location"><br>
		<input type="submit" value="registerAddress">
	</form>
	<br>
	
	<h4>15) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다.</h4>
	<form action="/registerUserAddress" method="post">
		address.postCode : <input type="text" name="address.postCode"><br>
		address.location : <input type="text" name="address.location"><br>
		<input type="submit" value="registerUserAddress">
	</form>
	<br>
	
	
	
	
	<h3>8. 파일 업로드 폼 방식 요청 처리</h3>
	<hr><br>
	
	<h4>1) 파일 업로드 폼 파일 요소값을 스프링 MVC가 지원하는 MultipartFile 매개변수로 처리한다.</h4>
	<form action="/registerFile01" method="post" enctype="multipart/form-data">
		<input type="file" name="picture">
		<input type="submit" value="업로드">
	</form>
	<br>
	
	<h4>2) 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 매개변수와 문자열 매개변수로 처리한다.</h4>
	<form action="/registerFile02" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="file" name="picture">
		<input type="submit" value="업로드">
	</form>
	<br>
	
	<h4>3) 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 매개변수와 자바빈즈 매개변수로 처리한다.</h4>
	<form action="/registerFile03" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="file" name="picture">
		<input type="submit" value="업로드">
	</form>
	<br>
	
	<h4>4) 파일 업로드 폼 파일 요소값과 텍스트 요소값을 FileMember 타입의 자바빈즈 매개변수로 처리한다.</h4>
	<form action="/registerFile04" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="file" name="picture">
		<input type="submit" value="업로드">
	</form>
	<br>
	
	<h4>5) 여러 개의 파일업로드를 폼 파일 요소값을 여러 개의 MultipartFile 매개변수로 처리한다.</h4>
	<form action="/registerFile05" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="file" name="picture"><br>
		<input type="file" name="picture2"><br>
		<input type="submit" value="업로드">
	</form>
	<br>
	
	<h4>6) 여러 개의 파일업로드를 폼 파일 요소값을 MultipartFile 타입의 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.</h4>
	<form action="/registerFile06" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="file" name="pictureList[0]"><br>
		<input type="file" name="pictureList[1]"><br>
		<input type="submit" value="업로드">
	</form>
	<br>
	
	<h4>7) 여러 개의 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultiFileMember 타입의 자바빈즈 클래스 매개변수로 처리한다.</h4>
	<form action="/registerFile07" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="file" name="pictureList[0]"><br>
		<input type="file" name="pictureList[1]"><br>
		<input type="submit" value="업로드">
	</form>
	<br>
	
	<h4>7-2) 파일 업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultiFileMember 타입의 자바빈즈 매개변수로 처리한다.</h4>
	<form action="/registerFile07" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="file" name="pictureList" multiple="multiple"><br>
		<input type="submit" value="업로드">
	</form>
	<br>
	
	<h4>8) 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 타입의 배열 매개변수로 처리한다.</h4>
	<form action="/registerFile08" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="file" name="pictureList" multiple="multiple"><br>
		<input type="submit" value="업로드">
	</form>
	<br>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>