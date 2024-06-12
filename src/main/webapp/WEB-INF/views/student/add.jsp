<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생정보입력 페이지</h1>
	
	<form action="/student/add" method="post">
	
		<div>
			<label for="num">번호</label>
			<!--  setter이름과 동일하게 -->
			<input type="text" id="num" name="num" value="">
		</div>
		
		<div>
			<label for="name">이름</label >
			<input type="text" id="name" name="name">
		</div>
		
		<div>
			<label for="avg">평균</label>
			<input type="text" id="avg" name = "avg">
		</div>
		
		<div>
			<label></label>
			<input type="radio" name="ch" value="female">
			<input type="radio" name="ch" value="male">
		</div>
		
		<div>
			<select name="mobile">
				<option value="kt">KT</option>	
				<option value="skt">SKT</option>	
				<option value="lg">LG</option>	
			</select>
		</div>
		
		<div>
			<input type="checkbox" name="ch2" value="v1">
			<input type="checkbox" name="ch2" value="v2">
			<input type="checkbox" name="ch2" value="v3">
		</div>
		
		<div>
		<!-- 길이가 긴것들은 POST로 보낸다. (GET으로 보내면 주소가 길어짐) -->
		<textarea rows="" cols="" name="con"></textarea>
		</div>
		
		<div>
			<input type="submit" value="등록">
			<button type="submit">작성</button>
		</div>
		

	
	</form>
</body>
</html>