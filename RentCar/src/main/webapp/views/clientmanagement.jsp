<%@page import="java.util.ArrayList"%>
<%@page import="client.controller.ClientDao"%>
<%@page import="util.DBManager"%>
<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMINISTRATOR : Client Management</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<section>
		<jsp:include page="/nav"></jsp:include>
		<h2>회원[Client] 관리</h2>
		<form method="post">
			<table class="clientInfoTable" border="1">
				<tr>
					<th>회원아이디</th>
					<th>비밀번호</th>
					<th>회원이름</th>
					<th>운전면허 등록번호</th>
					<th>핸드폰</th>
					<th>주소</th>
					<th>가입일자</th>
				</tr>
				<%
				ClientDao clientDao = ClientDao.getInstance();
				ArrayList<Client> list = new ArrayList<>();
				list = clientDao.getClientAll();
				for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td><a href="cmupdate?client_id=<%=list.get(i).getId()%>"><%=list.get(i).getId()%></a></td>
					<td><%=list.get(i).getPassword()%></td>
					<td><%=list.get(i).getName()%></td>
					<td><%=list.get(i).getDriverCode()%></td>
					<td><%=list.get(i).getPhone()%></td>
					<td><%=list.get(i).getAddress()%></td>
					<td><%=list.get(i).getRegDate()%></td>
				</tr>
				<%
				}
				%>
			</table>
		</form>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>