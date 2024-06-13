<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 한명 정보</h1>
	<!-- 표현식 -->
	<!--  EL (Expression Language 데이터 출력전용-->
	<%-- ${스코프영역명.속성명} --%>
	<!-- getter의 이름: get 제외한 첫글자를 소문자로 -->
	<!-- setter의 이름: set 제외한 첫글자를 소문자로 -->
	<h3>${requestScope.result.name}</h3>
	<h3>${requestScope.result.num}</h3>
	<h3>${requestScope.result.avg}</h3>
</body>
</html>