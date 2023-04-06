<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../resources/validation.js"></script>
<title>Bong Car : 비밀번호 변경</title>
</head>
<jsp:include page="header"></jsp:include>
<body>
<%
Client log = (Client) session.getAttribute("log");
%>
	<section>
		<h2>비밀번호 변경</h2>
		<form method="post" action="../service">
			<input type="hidden" name="command" value="updatePassword">
			<table border="1">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" id="client_id" name="client_id"
							maxlength="15" value="<%=log.getId()%>" readonly></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" id="password" name="password"
							pattern="(?=.*\d)(?=.*[a-zA-Z])(?=.*[~!@#$%^&*()_+}{'\[\]).{8,15}"
							placeholder="비밀번호"></td>
					</tr>
					<tr>
						<th>비밀번호 재확인</th>
						<td><input type="password" id="password_check"
							name="password_check"
							pattern="(?=.*\d)(?=.*[a-zA-Z])(?=.*[~!@#$%^&*()_+}{'\[\]).{8,15}"
							placeholder="비밀번호 확인"></td>
					</tr>
				</tbody>
			</table>
			<div class="info_button">
				<input type="button" id="transfer_button" value="변경하기" onclick="checkPassword(form)">						
			</div>
		</form>
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>