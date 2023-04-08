<%@page import="board.Board"%>
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
int num = Integer.parseInt(request.getParameter("board_number"));
System.out.print(num);
BoardDao boardDao = BoardDao.getInstance();
Board board = boardDao.getBoardByBoardNum(num);

String href = "location.href='updatenotice?board_number=" + num + "'";
/* System.out.print(board.getCreateDate());

String cDate = String.valueOf(board.getCreateDate()).substring(0, 11);  */
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
		<div>
			<div id="title"><%=board.getTitle() %></div>
			<div id="writer"><%=board.getBoardWriter() %></div>
			<!-- <div id="created_date"></div> -->
			<div id="content"><%=board.getContent() %></div>
		</div>
		<input type="button" value="공지사항 수정"
				onclick="<%=href %>">
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>