<%@page import="client.Client"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
%>
	<section>
		<% if (id.equals("admin")) {%>
		<jsp:include page="/nav"></jsp:include>
		<%} %>
		<p>보오오오옹 카</p>
		<p>보오오오옹 카</p>
		<p>보오오오옹 카</p>
		<p>보오오오옹 카</p>
		<p>보오오오옹 카</p>
		<p>보오오오옹 카</p>
		<p>보오오오옹 카</p>
		<p>보오오오옹 카</p>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>