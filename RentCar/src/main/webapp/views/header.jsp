<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/index.css">
<link rel="shortcut icon" href="../resources/images/BongCar.ico">
<title>Bong Car</title>
</head>
<body>
	<%
	// 스크립틀릿 scriptlet 
	Client log = (Client) session.getAttribute("log");
	%>
	<header>
		<div class="head_left">
			<a href="/"><img alt="x" src="../resources/images/BongCar.png"></a>
			<h1><a href="/"> Bong Car </a></h1>
		</div>
		<div class="head_right">
			<div class="nav">
				<ul>
					<%if (log == null) {%>
					<li><a href="login">로그인</a></li>
					<li><a href="regist">회원가입</a></li>
					<%}%>
					<%if (log != null) {%>
					<li><a href="../service?command=logout">로그아웃</a></li>
					<%if (!log.getId().equals("admin")) {%>
					<li><a href="inquiryinfo">회원정보</a></li>
					<li><a href="myreservation">나의 예약정보</a></li>
					<%} else {%>
					<li>[ 관리자 ]</li>
					<%}%>
					<%}%>
				</ul>
			</div>
			<div class="nav_menu">
				<ul>
					<li><a href="notice?common=true"> 공지사항 </a></li>
					<li><a href="rent?common=true"> 렌트 </a></li>
					<li><a href="review?common=true"> 이용후기 </a></li>
				</ul>
			</div>
		</div>
	</header>
</body>
</html>