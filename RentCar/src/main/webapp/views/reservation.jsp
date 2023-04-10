<%@page import="reservation.Reservation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="booking.controller.BookingDao"%>
<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bong Car : Reservation Detail</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
<%
Client log = null;
String id = "";
if( session.getAttribute("log") != null){
	log = (Client) session.getAttribute("log");
	id = log.getId();
}
%>
	<section>
		<% if (id.equals("admin")) {%>
		<jsp:include page="/nav"></jsp:include>
		<%} %>
		<div class="notice_box">
			<h2>예약내역[Reservation Detail]</h2>
		</div>
		<form method="post">
			<table class="rentTable" border="1">
				<tr>
					<th>예약번호</th>
					<th>예약신청일</th>
					<th>대여시간</th>
					<th>고객 아이디</th>
					<th>고객 이름</th>
					<th>고객 운전면허번호</th>
					<th>차량번호</th>
					<th>예약일</th>
					<th>반납일</th>
					<th>렌트비용</th>
					<th>차량위치</th>
				</tr>
				<%
				BookingDao dao = BookingDao.getInstance();

				ArrayList<Reservation> list = new ArrayList<>();
				list = dao.getBookingAll();
				
				if( list.size() != 0){
				for(int i =0; i < list.size(); i++){
				%>
				<tr>
					<th><%=list.get(i).getReservationCode() %></th>
					<th><%=list.get(i).getRegDate() %></th>
					<th><%=list.get(i).getRentalTime() %> 시간</th>
					<th><%=list.get(i).getClientId() %></th>
					<th><%=list.get(i).getClientName() %></th>
					<th><%=list.get(i).getDriverCode() %></th>
					<th><%=list.get(i).getVehicleCode() %></th>
					<th><%=list.get(i).getReservationDate() %></th>
					<th><%=list.get(i).getReturnDate() %></th>
					<th><%=list.get(i).getRentCost() %> 원</th>
					<th><%=list.get(i).getVehicleVenue() %></th>
				</tr>
				<%}} %>
			</table>
				<%if(list.size() == 0){ %>
				<h2> 예약 내역이 존재하지 않습니다.</h2>
				<%} %>
		</form>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>