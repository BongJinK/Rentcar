<%@page import="util.DBManager"%>
<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bong car : Review</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<%
Client log = (Client) session.getAttribute("log");
DBManager.getConnection();
String id = "";
if( log != null){
	id = log.getId();
}

String common = request.getParameter("common");

%>
	<section>
		<% if (id.equals("admin")) {%>
		<jsp:include page="/nav"></jsp:include>
		<%} %>
		<div class="notice_box">
			<h2>이용 후기[Review]</h2>
			<%if(common != null) {%>
			<input type="button" value="이용후기 작성" onclick="location.href='/'">
			<%}%>
		</div>
		<form method="post">
			<table class="reviewTable" border="1">
				<tr>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
				<%for(int i =0; i < 100; i++){ %>
				<tr>
					<td>공지사항</td>
					<td><%= %></td>
					<td><%= %></td>
				</tr>
				<%} %>
			</table>
		</form>

	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>