<%@page import="java.text.SimpleDateFormat"%>
<%@page import="vehicle.Vehicle"%>
<%@page import="vehicle.controller.VehicleDao"%>
<%@page import="venue.Venue"%>
<%@page import="java.util.ArrayList"%>
<%@page import="util.DBManager"%>
<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../resources/reservation.js"></script>
<title>Bong Car : Rent Car Detail</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
<%
Client log = null;
String id = "";
if( session.getAttribute("log") != null ){
	log = (Client) session.getAttribute("log");
	id = log.getId();
}
DBManager.getConnection();

String common = request.getParameter("common");
String code = request.getParameter("vehicle_code");
VehicleDao vehicleDao = VehicleDao.getInstance();
Vehicle vehicle = vehicleDao.getVehicleByCode(code);
%>
		<section>
		<div class="notice_box">
			<h2>렌트[Rent]</h2>
		</div>
		<form method="post" action="../service">
			<input type="hidden" name="vehicle_code" value="<%=code %>">
			<input type="hidden" name="time_diff" value="">
			<input type="hidden" name="command" value="registReservation">
			<table border="1">
				<tbody>
					<tr>
						<th>렌트카사진</th>
						<td><img class="car" alt="x" src="../resources/images/<%=vehicle.getVehicleName() %>.png"></td>
					</tr>
					<tr>
						<th>차종명</th>
						<td><%=vehicle.getVehicleName() %></td>
					</tr>
					<tr>
						<th>시간당 비용</th>
						<td><%=vehicle.getHourlyRate() %> 원</td>
					</tr>
					<tr>
						<th>차량 위치</th>
						<td><%=vehicle.getVenue_name() %></td>
					</tr>
				</tbody>
			</table>
			<%if( !id.equals("")) {%>
			대여일
			<input type="date" id="booking_date" name="booking_date"><span><input type="time" id="booking_time" name="booking_time" step="1800"></span>
			반납일
			<input type="date" id="return_date" name="return_date"><span><input type="time" id="return_time" name="return_time" step="1800"></span>
			
			<input type="button" id="reservation_button" value="예약하기"
				onclick="reservation(form)">
			<%} %>
		</form>
	</section>
<script>
//초기 시간 설정
let bookingdate = document.getElementById('booking_date');
let today = new Date().toISOString().slice(0, 10);
bookingdate.value = today;


let bookingTime = document.getElementById('booking_time');
let returnTime = document.getElementById('return_time');


bookingTime.addEventListener("change", function() {
	let current = bookingTime.value.split(":");
	if (current[1] != "00" && current[1] != "30") {
		if (current[1] < "30") {
			current[1] = "30";
		} else {
			current[0] = parseInt(current[0]) + 1;
			current[1] = "00";
		}
		bookingTime.value = current.join(":");
	}
});

returnTime.addEventListener("change", function() {
	let current = returnTime.value.split(":");
	if (current[1] != "00" && current[1] != "30") {
		if (current[1] < "30") {
			current[1] = "30";
		} else {
			current[0] = parseInt(current[0]) + 1;
			current[1] = "00";
		}
		returnTime.value = current.join(":");
	}
});
</script>

</body>
<jsp:include page="/footer"></jsp:include>
</html>