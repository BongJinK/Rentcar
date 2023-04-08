<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BongCar : 로그인</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<section>
		<h2>로그인</h2>
		<form method="post" action="../service">
			<input type="hidden" name="command" value="login">
			<div class="login">
				<span>아이디</span><br> <input type="text" name="id"
					placeholder="아이디" value="admin" autofocus><br> <span>비밀번호</span><br> <input
					type="password" name="password" placeholder="비밀번호" value="1"><br>
				<input type="submit" value="로그인" id="login_button">
			</div>
		</form>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>