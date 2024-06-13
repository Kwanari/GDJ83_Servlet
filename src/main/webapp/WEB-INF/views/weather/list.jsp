<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<Link href="/resources/css/tables.css" rel="stylesheet"> <!-- rel : 타입 -->
</head>
<body>
	<h1>Weather List</h1>
	
	<table border="1" class="tbl">
	
		<thead>
			<th>번호</th>
			<th>도시</th>
			<th>온도</th>
			<th>상태</th>
			<th>습도</th>
		</thead>
		
		<tbody>
			<c:forEach items="${requestScope.wdto}" var="wdto">
				<tr>
					<td>${pageScope.wdto.num}</td>
					<td><a href="./detail?num=${pageScope.wdto.num}">${pageScope.wdto.city}</a></td>
					<td>${pageScope.wdto.gion}</td>
					<td>${pageScope.wdto.status}</td>
					<td>${pageScope.wdto.humidity}</td>
				<tr>
			</c:forEach>
		</tbody>

	
	</table>
	
	
	
	<div>
		<a href="./add">날씨 등록</a>
	</div>
</body>
</html>