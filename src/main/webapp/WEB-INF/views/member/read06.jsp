<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read05</title>
</head>
<body>
	<h3>6)</h3>
	
	아이디 : ${user.userId }<br>
	비밀번호 : ${user.password }<br>
	이름 : ${user.userName }<br>
	이메일 : ${user.email }<br>
	생일 : ${user.birthDay }<br>
	성별 : ${user.gender }<br>
	취미 : ${user.hobby }<br>
	<hr>
	취미(배열)<br>
	<c:forEach items="${user.hobbyArray }" var="hobby">
		${hobby }<br>
	</c:forEach>
	<hr>
	취미(리스트)<br>
	<c:forEach items="${user.hobbyList }" var="hobby">
		${hobby }<br>
	</c:forEach>
	<hr>
	외국인여부 : ${user.foreigner }<br>
	개발자여부 : ${user.developer }<br>
	국적 : ${user.nationality }<br>
	우편번호 : ${user.address.postCode }<br>
	주소 : ${user.address.location }<br>
	<hr>
	카드번호 / 유효년월<br>
	<c:forEach items="${user.cardList }" var="card">
		${card.no } / ${card.validMonth }
	</c:forEach>
	<hr>
	소유차량 : ${user.cars }<br>
	<hr>
	소유차량(배열)<br>
	<c:forEach items="${user.carArray }" var="car">
		${car }<br>
	</c:forEach>
	<hr>
	소유차량(리스트)<br>
	<c:forEach items="${user.carList }" var="car">
		${car }<br>
	</c:forEach>
	<hr>
	소개 : ${user.introduction }<br>
	:::::::::::::: END user.dateOfBirth : ${user.dateOfBirth }<br>
	
</body>
</html>