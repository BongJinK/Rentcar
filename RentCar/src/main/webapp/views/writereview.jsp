<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../resources/Administrator.js"></script>
<title>Bong Car : WriteReview</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<section>
		<jsp:include page="/nav"></jsp:include>
		<form method="post" action="../service">
			<input type="hidden" id="type" name="type" value="1">
			<input type="hidden" id="command" name="command" value="WriteBoard">
			<div>
				제목 : <input type="text" id="title" name="title">
			</div>
			<div>
				내용 : <br>
				<br>
				<textarea rows="20" cols="100" id="content" name="content" style="padding: 10px;"></textarea>
			</div>
			<input type="button" value="작성" onclick="checkWrite(form)">
		</form>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>