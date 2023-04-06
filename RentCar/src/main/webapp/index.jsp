<%@page import="client.Client"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<jsp:include page="header"></jsp:include>
<body>
<%
Client log = (Client) session.getAttribute("log");
DBManager.getConnection();
String id = "";
if( log != null){
	id = log.getId();
}
%>
	<%if(id.equals("admin")) {%>
	<nav>
		<ul>
			<li> 공지사항[Notice] 작성 </li>
			<li> 렌트카[Vehicle] 등록 </li>
			<li> 렌트 지점[Venue] 관리 </li>
			<li> 회원[Client] 관리 </li>
		</ul>
	</nav><br><br>
	<%} %>
	<section>
	<p> 보오오오옹 카 </p>
	<p> 보오오오옹 카 </p>
	<p> 보오오오옹 카 </p>
	<p> 보오오오옹 카 </p>
	<p> 보오오오옹 카 </p>
	<p> 보오오오옹 카 </p>
	<p> 보오오오옹 카 </p>
	<p> 보오오오옹 카 </p>
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>