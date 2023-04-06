<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/index.css">
<title>Bong Car</title>
</head>
<body>
<%
// 스크립틀릿 scriptlet 
Client log = (Client) session.getAttribute("log"); 
%>
	<header>
		<div class="head_left">
			<a href="/">
			<img alt="x" src="../resources/images/BongCar.png"></a>
			<h1><a href="/"> Bong Car </a></h1>
		</div>
		<div class="head_right">
			<div class="nav">
				<ul>
					<%if(log == null) {%><li><a href="login">로그인</a></li>
					<li><a href="regist">회원가입</a></li><%} %>
					<%if(log != null) {%><li><a href="logout">로그아웃</a></li>
					<li><a href="inquiryInfo">회원정보</a></li><%} %>
				</ul>
			</div>
			<div class="nav_menu">
				<ul>
					<li><a href=""> 렌트 </a></li>
					<li><a href=""> 이용후기 </a></li>
					<li><a href=""> 공지사항 </a></li>
				</ul>
			</div>
		</div>
	</header>
</body>
</html>