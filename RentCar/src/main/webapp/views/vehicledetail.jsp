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
<script src="../resources/validation.js"></script>
<title>Bong Car : Rent Car Detail</title>
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
String code = request.getParameter("vehicle_code");
VehicleDao vehicleDao = VehicleDao.getInstance();
Vehicle vehicle = vehicleDao.getVehicleByCode(code);


// 1. 오늘 날짜
// 2. 오늘 날짜 변경 > 맥스날짜 변경
// 3. 맥스 날짜 변경 > 오늘 최소 날짜 변경

// 예약 테이블 날짜 중복 안되게

// 오늘 날짜 + 30
%>
		<section>
		<div class="notice_box">
			<h2>렌트[Rent]</h2>
		</div>
		<form method="post" action="../service">
			<input type="hidden" name="vehicle_code" value="<%=code %>">
			<input type="hidden" name="command" value="registVehicle">
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
			대여일
			<input type="datetime-local" id="dateTimeLocal">
			반납일
			<input type="datetime-local" id="dateTimeLocal_return" min="">
			
			<input type="button" id="regi_button" value="예약하기"
				onclick="reservation(form)">
		</form>
	</section>
	
	<script>
        let dateElement = document.getElementById('dateTimeLocal');
        let returnDate = document.getElementById('dateTimeLocal_return');
        let date = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000).toISOString().slice(0, -8);
        dateElement.value = date;
        dateElement.setAttribute("min", date);
        
        dateElement.addEventListener("change", function() {
            returnDate.setAttribute("min", dateElement.value);
        });
    </script>
</body>
<jsp:include page="/footer"></jsp:include>
</html>