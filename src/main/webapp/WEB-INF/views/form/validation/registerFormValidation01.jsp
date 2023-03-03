<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form</title>
</head>
<body>
	<h2>Spring Form</h2>
	<!-- 
		아이디 값을 비워놓고 등록을 눌렀을 때, 누락된 값이므로 누락이 되었다는 메세지가 출력되어야 하는데
		출력이 되지 않네요?? 그 이유는 validation을 하기 위한 설정이 form:error 만으로는 이뤄지지 않는다는 점입니다.
		그렇다면 그 형태는 어디서 찾는건가요? 
	 -->
	<form:form action="/formtag/validation/result" method="post" modelAttribute="member">
		<table>
			<tr>
				<td>E-Mail</td>
				<td>
					<form:input path="email"/>
					<font color="red">
						<form:errors path="email" />
					</font>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<form:input path="userName"/>
					<font color="red">
						<form:errors path="userName"/>
					</font>
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>		
	</form:form>
</body>
</html>