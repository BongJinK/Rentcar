<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../resources/validation.js"></script>
<title>Bong Car : 개인정보</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
<%
Client log = (Client) session.getAttribute("log");

Object[] address = log.getAddress().split(",");
%>
	<section>
		<h2>회원 정보</h2>
		<form method="post" action="../service">
			<input type="hidden" name="command" value="updateInfo">
			<table border="1">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" id="client_id" name="client_id"
							maxlength="15" value="<%=log.getId()%>" readonly></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" id="name" name="name"
							value="<%=log.getName()%>"></td>
					</tr>
					<tr>
						<th>휴대전화</th>
						<td><input type="tel" id="phone" name="phone"
							pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" maxlength="13"
							value="<%=log.getPhone()%>"></td>
					</tr>
					<tr>
						<th>운전면허번호</th>
						<td><input type="text" id="driver_code" name="driver_code"
							pattern="[0-9]{2}-[0-9]{2}-[0-9]{6}-[0-9]{2}" maxlength="15"
							value="<%=log.getDriverCode()%>" readonly></td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<div>
								<input type="text" id="sample4_postcode" name="address_postNum" value="<%=address[0]%>" >
								<input type="button" id="postcode" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
								<input type="text" id="sample4_roadAddress" name="address_roadNm" value="<%=address[1]%>">
								<input type="text" id="sample4_jibunAddress" name="address_jibun" value="<%=address[2]%>">
								<span id="guide" style="color: #999; display: none"></span><br>
								<input type="text" id="sample4_detailAddress" name="address_detail" value="<%=address[3]%>">
								<input type="text" id="sample4_extraAddress" name="address_extra" value="<%=address[4]%>">
								<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="info_button">
				<input type="button" id="update_button" value="수정하기" onclick="checkInfo(form)">
				<input type="button" id="updatePassword_button" value="비밀번호 변경" onclick="location.href='updatepassword'">
				<input type="button" id="leave_button" value="회원탈퇴" onclick="leaveCheck()">					
			</div>
		</form>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>