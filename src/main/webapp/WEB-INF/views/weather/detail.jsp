<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<Link href="/resources/css/tables.css" rel="stylesheet">
</head>
<body>
	<h1>Weather Detail</h1>

	<table border="1" class="tbl">
		<thead>
			<th>번호</th>
			<th>도시</th>
			<th>기온</th>
			<th>상태</th>
			<th>습도</th>
		</thead>
		<tbody>
				<td>${requestScope.wdto.num}</td>
				<td>${requestScope.wdto.city}</td>
				<td>${requestScope.wdto.gion}</td>
				<td>${requestScope.wdto.status}</td>
				<td>${requestScope.wdto.humidity}</td>
		</tbody>
	</table>
</body>
</html>