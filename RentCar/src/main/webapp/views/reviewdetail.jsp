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
int num = Integer.parseInt(request.getParameter("board_number"));
System.out.print(num);
BoardDao boardDao = BoardDao.getInstance();
Board board = boardDao.getBoardByBoardNum(num);

// notive > review로 수정
String updateHref = "location.href='updatereview?board_number=" + num + "'";
String deleteHref = "location.href='../service?command=RemoveReview&board_number=" + num + "'";
/* System.out.print(board.getCreateDate());

String cDate = String.valueOf(board.getCreateDate()).substring(0, 11);  */
%>
	<section>
		<% if (id.equals("admin")) {%>
		<jsp:include page="/nav"></jsp:include>
		<%} %>
		<div class="notice_box">
			<h2>이용후기[Review]</h2>
			<input type="button" value="이용후기 작성"
				onclick="location.href='writenreview?type=1'">
		</div>
		<div>
			<div id="title"><%=board.getTitle() %></div>
			<div id="writer"><%=board.getBoardWriter() %></div>
			<!-- <div id="created_date"></div> -->
			<div id="content"><%=board.getContent() %></div>
		</div>
		<%if(id.equals(board.getBoardWriter()) || (id.equals("admin") && common == null)) {%>
		<input type="button" value="수정"
				onclick="<%=updateHref %>">
		<input type="button" value="삭제"
				onclick="<%=deleteHref %>">
		<%} %>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>