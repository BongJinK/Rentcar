<%@page import="java.sql.Timestamp"%>
<%@page import="board.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.controller.BoardDao"%>
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
			<h2>공지사항[Notice]</h2>
			<%if(common == null) {%>
			<input type="button" value="공지사항 작성"
				onclick="location.href='writenotice?type=0'">
			<%} %>
		</div>
		<form method="post">
			<table class="noticeTable" border="1">
				<tr>
					<th>제목</th>
					<th>작성일</th>
				</tr>
				<%
				BoardDao boardDao = BoardDao.getInstance();
				ArrayList<Board> list = new ArrayList<>();
				list = boardDao.getBoardAllByType(0);	
				for(int i =0; i < list.size(); i++){
					Timestamp dates = list.get(i).getCreateDate();
				%>
				<tr>
				<%if(common == null) {%>
					<td id="board_title"><a href="noticedetail?board_number=<%=list.get(i).getBoardNum() %>"><%=list.get(i).getTitle() %></a></td>
					<%} else{%>
					<td id="board_title"><a href="noticedetail?common=true&board_number=<%=list.get(i).getBoardNum() %>"><%=list.get(i).getTitle() %></a></td>
					<%} %>
					<td><%=dates %></td>
				</tr>
				<%} %>
			</table>
		</form>

	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>