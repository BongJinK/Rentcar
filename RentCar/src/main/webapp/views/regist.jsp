<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../resources/validation.js"></script>
<link rel="stylesheet" href="../resources/index.css">
<title>BongCar : 회원가입</title>
</head>
<body>
	<%
	String id = request.getParameter("client_id");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String driverCode = request.getParameter("driver_code");
	%>
	<h2>
		<a href="/"> Bong Car </a>
	</h2>
	<section>
		<form method="post" action="../service">
			<input type="hidden" name="command" value="regist">
			<table border="1">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" id="client_id" name="client_id"
							maxlength="15" placeholder="아이디"
							value="<%=id != null ? id : ""%>"
							<%=id == null ? "autofocus" : ""%>></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" id="password" name="password"
							pattern="(?=.*\d)(?=.*[a-zA-Z])(?=.*[~!@#$%^&*()_+}{'\[\]).{8,15}"
							placeholder="비밀번호"></td>
					</tr>
					<tr>
						<th>비밀번호 재확인</th>
						<td><input type="password" id="password_check"
							name="password_check"
							pattern="(?=.*\d)(?=.*[a-zA-Z])(?=.*[~!@#$%^&*()_+}{'\[\]).{8,15}"
							placeholder="비밀번호 확인"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" id="name" name="name"
							value="<%=name != null ? name : ""%>"
							<%=name == null ? "autofocus" : ""%>></td>
					</tr>
					<tr>
						<th>휴대전화</th>
						<td><input type="tel" id="phone" name="phone"
							pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" maxlength="13"
							placeholder="010-1234-1234"
							value="<%=phone != null ? phone : ""%>"
							<%=phone == null ? "autofocus" : ""%>></td>
					</tr>
					<tr>
						<th>운전면허번호</th>
						<td><input type="text" id="driver_code" name="driver_code"
							pattern="[0-9]{2}-[0-9]{2}-[0-9]{6}-[0-9]{2}" maxlength="15"
							placeholder="12-12-123456-12"
							value="<%=driverCode != null ? driverCode : ""%>"
							<%=driverCode == null ? "autofocus" : ""%>></td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<div>
								<input type="text" id="sample4_postcode" name="address_postNum"
									placeholder="우편번호"> <input type="button" id="postcode"
									onclick="execDaumPostcode()" value="우편번호 찾기"><br>
								<input type="text" id="sample4_roadAddress"
									name="address_roadNm" placeholder="도로명주소"> <input
									type="text" id="sample4_jibunAddress" name="address_jibun"
									placeholder="지번주소"> <span id="guide"
									style="color: #999; display: none"></span><br> <input
									type="text" id="sample4_detailAddress" name="address_detail"
									placeholder="상세주소"> <input type="text"
									id="sample4_extraAddress" name="address_extra"
									placeholder="참고항목">
								<script
									src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<input type="button" id="regi_button" value="가입하기"
				onclick="checkValues(form)">
		</form>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>

</html>