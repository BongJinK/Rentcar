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
			<% if (!id.equals("")) {%>
			<input type="button" value="이용후기 작성" 
			onclick="location.href='writereview?type=1'">
			<%} %>
		</div>
		<form method="post">
			<table class="reviewTable" border="1">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
				<%
				BoardDao boardDao = BoardDao.getInstance();
				ArrayList<Board> list = new ArrayList<>();
				list = boardDao.getBoardAllByType(1);	
				for(int i =0; i < list.size(); i++){
					Timestamp dates = list.get(i).getCreateDate();
					int num = list.get(i).getBoardNum();
				%>
				<tr>
					<td><%=num %></td>
					<%if(common == null) {%>
					<td><a href="reviewdetail?board_number=<%=num %>"><%=list.get(i).getTitle() %></a></td>
					<%} else{%>
					<td><a href="reviewdetail?common=true&board_number=<%=num %>"><%=list.get(i).getTitle() %></a></td>
					<%} %>
					<td><%=list.get(i).getBoardWriter() %></td>
					<td><%=dates %></td>
				</tr>
				<%} %>
			</table>
		</form>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>