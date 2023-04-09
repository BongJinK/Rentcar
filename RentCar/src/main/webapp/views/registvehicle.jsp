<%@page import="venue.Venue"%>
<%@page import="java.util.ArrayList"%>
<%@page import="venue.controller.VenueDao"%>
<%@page import="util.DBManager"%>
<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../resources/validation.js"></script>
<title>Bong Car : Rent Registration</title>
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
VenueDao venueDao = VenueDao.getInstance();
ArrayList<Venue> list = new ArrayList<>();

list = venueDao.getVenueAll();
%>
	<section>
		<div class="notice_box">
			<h2>렌트[Rent]</h2>
		</div>
		<form method="post" action="../service">
			<input type="hidden" name="command" value="registVehicle">
			<table border="1">
				<tbody>
					<tr>
						<th>차량명</th>
						<td><select id="vehicle_name" name="vehicle_name">
							<option value="" >--차량명 선택--</option>
							<option value="K3" >K3</option>
							<option value="K5" >K5</option>
							<option value="K7" >K7</option>
							<option value="GRANDEUR" >그랜져</option>
							<option value="THENEWAVANTE" >더뉴아반떼</option>
						</select></td>
					</tr>
					<tr>
						<th>시간당 렌트비</th>
						<td><input type="text" id="hourly_rate" name="hourly_rate"
							pattern="[0-9]{5,6}"
							placeholder="시간당 렌트비"></td>
					</tr>
					<tr>
						<th>지점 코드</th>
						<td><select id="vehicle_code" name="vehicle_code">
							<option value="" >--지점코드 선택--</option>
							<%for(Venue venue : list){ %>
							<option value="<%=venue.getVenueCode() %>" ><%=venue.getVenueCode() %> | <%=venue.getVenueName() %></option>
							<%} %>
						</select></td>
					</tr>
				</tbody>
			</table>
			<input type="button" id="regi_button" value="가입하기"
				onclick="checkVehicle(form)">
		</form>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>