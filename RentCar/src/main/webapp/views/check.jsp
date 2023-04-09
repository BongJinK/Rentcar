<%@page import="util.DBManager"%>
<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%
Client log = (Client) session.getAttribute("log");
DBManager.getConnection();
String id = "";
if( log != null){
	id = log.getId();
}

String common = request.getParameter("common");
%>
</body>
</html>