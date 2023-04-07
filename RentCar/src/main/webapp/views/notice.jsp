<%@page import="util.DBManager"%>
<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bong car : Notice</title>
</head>
<jsp:include page="header"></jsp:include>
<body>
<%
Client log = (Client) session.getAttribute("log");
DBManager.getConnection();
String id = "";
if( log != null){
	id = log.getId();
}

String common = request.getParameter("common");
String board_number = "번호";
String title = "제목";
String date = "2023-04-07";
%>
	<section>
		<% if (id.equals("admin")) {%>
		<jsp:include page="nav"></jsp:include>
		<%} %>
		
		<div class="notice_box">
			<h2>공지사항[Notice]</h2>
			<%if(common == null) {%>
				<input type="button" value="공지사항 작성" onclick="location.href='writenotice?type=0'">		
			<%} %>
		</div>
		<form method="post">
			<table class="noticeTable" border="1">
				<tr>
					<th>제목</th>
					<th>작성일</th>
				</tr>
				<%for(int i =0; i < 5; i++){ %>
				<tr>
					<td><a href="<%=board_number %>"><%=title %></a></td>
					<td><%=date %></td>
				</tr>
				<%} %>
			</table>
		</form>
	
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>