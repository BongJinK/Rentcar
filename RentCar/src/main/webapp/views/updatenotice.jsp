<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bong Car : Notice modification</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>


	<section>
		<jsp:include page="/nav"></jsp:include>
		<form method="post" action="../service">
			<input type="hidden" id="type" name="type" value="0">
			<input type="hidden" id="command" name="command" value="UpdateNoticeAction">
			<div>
				제목 : <input type="text" id="title" name="title" value="<%= %>">
			</div>
			<div>
				내용 : <br>
				<br>
				<textarea rows="20" cols="100" id="content" name="content" value="<%= %>" style="padding: 5px;"></textarea>
			</div>
			<input type="button" value="수정" onclick="checkWrite(form)">
		</form>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>