<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMINISTRATOR : Venue Regist</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<section>
		<jsp:include page="/nav"></jsp:include>

		<div class="notice_box">
			<h2>렌트 지점[Venue] 관리</h2>
		</div>
		
		<form method="post" action="../service">
			<input type="hidden" name="command" value="registVehicle">
			<table border="1">
				<tbody>
					<tr>
						<th>지점 코드<span>[ ex) 지점 위치코드 + 호수]</span></th>
						<td><input type="text" id="venue_code" name="venue_code" pattern="[a-zA-Z]{1}[0-9]{2}"></td>
					</tr>
					<tr>
						<th>지점 이름</th>
						<td><input type="text" id="venue_name" name="venue_name" placeholder="지점 이름"></td>
					</tr>
				</tbody>
			</table>
			<input type="button" id="regi_button" value="등록하기"
				onclick="checkVehicle(form)">
		</form>
	
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>