<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Weather Update</h1>
	
	<form action="./update" method="post">
			<input type="hidden" name="num" value="${dto.num}">
	
		<div>
			<label>도시명</label>
			<input type="text" name="city" value="${dto.city}">
		</div>
		<div>
			<label>온도</label>
			<input type="text" name="gion" value="${dto.gion}">
		</div>
		<div>
			<label>상태</label>
			<input type="text" name="status" value="${dto.status}">
		</div>
		<div>
			<label>습도</label>
			<input type="text" name="humidity" value="${dto.humidity}">
		</div>
	
	
	<input type="submit" value="제출">
	<button type="submit" value="">등록</button> <!-- 같은 기능 -->
	
	</form>
</body>
</html>