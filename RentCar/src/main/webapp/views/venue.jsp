<%@page import="venue.controller.VenueDao"%>
<%@page import="venue.Venue"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMINISTRATOR : Venue Management</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<section>
		<jsp:include page="/nav"></jsp:include>

		<div class="notice_box">
			<h2>렌트 지점[Venue] 관리</h2>
			<!-- <input type="button" value="지점 등록" onclick="location.href='registvenue'"> -->
		</div>
		<form method="post">
			<table class="clientInfoTable" border="1">
				<tr>
					<th>지점 코드</th>
					<th>지점 이름</th>
					<th>지점 등록 일자</th>
				</tr>
				<%
				VenueDao dao = VenueDao.getInstance();
				ArrayList<Venue> list = new ArrayList<>();
				list = dao.getVenueAll();
				for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td><%=list.get(i).getVenueCode() %></td>
					<td><%=list.get(i).getVenueName() %></td>
					<td><%=list.get(i).getRegDate() %></td>
				</tr>
				<%} %>
			</table>
		</form>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>