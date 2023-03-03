<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register All Form</title>
</head>
<body>
	<h1>Register All Form</h1>
	<hr>
	<form action="/registerUser" method="post">
		<table border="1">
			<tr>
				<th>유저ID</th>
				<td>
					<input type="text" name="userId">
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" name="password">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="userName">
				</td>
			</tr>
			<tr>
				<th>E-Mail</th>
				<td>
					<input type="text" name="email">
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
					<input type="text" name="dateOfBirth">
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="gender" value="male" checked="checked">Male&nbsp;
					<input type="radio" name="gender" value="female">female&nbsp;
					<input type="radio" name="gender" value="other">other&nbsp;
				</td>
			</tr>
			<tr>
				<th>개발자 여부</th>
				<td>
					<input type="checkbox" name="developer" value="Y">
				</td>
			</tr>
			<tr>
				<th>외국인 여부</th>
				<td>
					<input type="checkbox" name="foreigner" value="true">
				</td>
			</tr>
			<tr>
				<th>국적</th>
				<td>
					<select name="nationality">
						<option value="korea">대한민국</option>
						<option value="germany">독일</option>
						<option value="austrailia">호주</option>
						<option value="canada">캐나다</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>소유차량</th>
				<td>
					<select name="cars" multiple="multiple">
						<option value="volvo">Volvo</option>
						<option value="jeep">Jeep</option>
						<option value="bmw">Bmw</option>
						<option value="audi">Audi</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>취미</th>
				<td>
					<input type="checkbox" name="hobby" value="sports">Sports<br>
					<input type="checkbox" name="hobby" value="music">Music<br>
					<input type="checkbox" name="hobby" value="movie">Movie<br>
				</td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td>
					<input type="text" name="address.postCode">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="address.location">
				</td>
			</tr>
			<tr>
				<th>소개</th>
				<td>
					<textarea rows="10" cols="50" name="introduction"></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" name="btnSubmit" value="등록">
					<input type="reset" name="btnReset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>