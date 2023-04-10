<%@page import="venue.controller.VenueDao"%>
<%@page import="util.DBManager"%>
<%@page import="client.Client"%>
<%@page import="vehicle.Vehicle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vehicle.controller.VehicleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bong Car : Rent</title>
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
DBManager.getConnection();

String common = request.getParameter("common");
%>
<jsp:include page="/check"></jsp:include>

	<section>
		<% if (id.equals("admin")) {%>
		<jsp:include page="/nav"></jsp:include>
		<%} %>

		<div class="notice_box">
			<h2>렌트[Rent]</h2>
			<%if(common == null) {%>
			<input type="button" value="렌트카 등록"
				onclick="location.href='registvehicle'">
			<%} %>
		</div>
		<form method="post">
			<table class="rentTable" border="1">
				<tr>
					<th colspan="2">렌트카</th>
					<th>시간당 비용</th>
					<th>차량 위치</th>
				</tr>
				<%
				VehicleDao vehicleDao = VehicleDao.getInstance();

				ArrayList<Vehicle> list = new ArrayList<>();
				list = vehicleDao.getVehicleAll();
	
				for(int i =0; i < list.size(); i++){
				%>
				<tr>
					<td><img class="car" alt="x" src="../resources/images/<%=list.get(i).getVehicleName() %>.png"></td>
					<td><a href="vehicledetail?vehicle_code=<%=list.get(i).getVehicleCode() %>"><%=list.get(i).getVehicleName() %></a></td>
					<td><%=list.get(i).getHourlyRate() %> 원</td>
					<td><%=list.get(i).getVenue_name() %></td>
				</tr>
				<%} %>
			</table>
		</form>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>