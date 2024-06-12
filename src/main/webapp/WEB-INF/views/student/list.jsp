<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/resources/css/tables.css" rel="stylesheet">

</head>
<body>

	<h1>학생 목록</h1>
	
	<div>
	<img src="/resources/images/KHK1.JPG" alt="">
	
	</div>
	
	<!-- table -->
	<!-- JSTL -->
	<table border="1" class="tbl">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>평균</th>
			</tr>
		</thead>
	
		<tbody>
			<!-- 향상된 for문 -->
			<c:forEach items="${requestScope.arStu}" var="student"> 
				<tr>
					<td>${pageScope.student.num}</td>
					<td>${pageScope.student.name}</td>
					<td>${pageScope.student.avg}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>