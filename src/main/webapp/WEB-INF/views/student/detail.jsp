<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<Link href="/resources/css/tables.css" rel="stylesheet">
</head>
<body>
	<h1>학생 한명 정보</h1>
	<!-- 표현식 -->
	<!--  EL (Expression Language 데이터 출력전용-->
	<%-- ${스코프영역명.속성명} --%>
	<!-- getter의 이름: get 제외한 첫글자를 소문자로 -->
	<!-- setter의 이름: set 제외한 첫글자를 소문자로 -->
	
	<table border="1" class="tbl">
		<thead>
			<th>번호</th>
			<th>이름</th>
			<th>평균</th>
		</thead>
		<tbody>
			<th>${requestScope.result.num}</th>
			<th>${requestScope.result.name}</th>
			<th>${requestScope.result.avg}</th>
		</tbody>
	</table>
</body>
</html>