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
	<hr><br>
	
	<h2>4) 모델에 CodeLabelValue 타입의 요소를 가지는 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.</h2>
	<form:form action="/formtag/selectbox/result2" method="post" modelAttribute="member">
		<table>
			<tr>
				<td>소유 차량</td>
				<td>
					<form:select path="carList" multiple="false">
						<form:option value="" label="====선택해주세요===="/>
						<form:options items="${carCodeList }" itemLabel="label" itemValue="value" />
					</form:select>
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
	
</body>
</html>