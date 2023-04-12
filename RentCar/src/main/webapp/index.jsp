<%@page import="client.controller.ClientDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="client.ClientRequestDto"%>
<%@page import="client.Client"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<%-- <jsp:include page="/header"></jsp:include> --%>
<c:import url="header"/>
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
		<%String fruits = "apple"; %>
		<p><%=fruits %></p>
		<p>${"apple" } </p>
		
		
		<%--
		EL Tag : JSP Expression Language
		 --%>
		 
		<%-- 산술 연산 --%>
		<p>${5 + 2 }  </p>
		<p>${5 - 2 }  </p>
		<p>${5 / 2 }  </p>
		<p>${5 * 2 }  </p>
		<p>${5 % 2 }  </p>
		
		<%-- 비교 연산 --%>
		<p>${5 == 2 } ${5 eq 2 } equals </p>
		<%-- <p>${5 != 2 } ${5 ne 2 } not equals</p> --%>
		<p>${5 < 2 } ${5 lt 2 } less than</p>
		<p>${5 > 2 } ${5 gt 2 } greater than</p>
		<p>${5 <= 2 } ${5 le 2 } less than or equals</p>
		<p>${5 >= 2 } ${5 ge 2 } greater than or equals</p>
		
		
		<%-- 논리 연산 --%>
		<p>${ 1 < 2 && 2 < 3 } ${ 1 < 2 and 2 < 3 } </p>
		<p>${ 1 < 2 || 2 > 3 } ${ 1 < 2 or 2 > 3 }</p>
		<p>${ !(1 < 2) } ${ not(1 < 2) }</p>
		
		<%-- null 연산 --%>
		<p>null : ${null }</p>
		<p>empty null : ${empty null }</p>
		
		<%-- 파라미터값 얻어오기 --%>
		<p>empty param.id :${empty param.id }</p>
		<p>param.id :${param.id }</p>
		
		<p>param.val1 : ${param.val1 + param.val2}</p>
		<p><%=request.getParameter("val1") + request.getParameter("val2")%></p>
		
		<%-- EL 태그로 내장 객체에 접근하지 --%>
		<%--
		1) page
		2) request
		3) session
		4) application
		 --%>
		 
		 <%
		 pageContext.setAttribute("pageVal","페이지 영역의 데이터입니다.");
		 request.setAttribute("requestVal","리퀘스트 영역의 데이터입니다.");
		 session.setAttribute("sessionVal","세션 영역의 데이터입니다.");
		 application.setAttribute("appVal","애플리케이션 영역의 데이터입니다.");
		 %>
		 
		 <p>page : ${pageScope.pageVal } ${ pageVal } </p>
		 <p>request : ${requestScope.requestVal } ${ requestVal }</p>
		 <p>session : ${sessionScope.sessionVal } ${ sessionVal }</p>
		 <p>application : ${applicationScope.appVal } ${ appVal }</p>
		 
		 <%-- 4가지 영역의 내장객체 속성명이 유일하다면, Scope키워드를 생략할 수 있다 >> 권장하지 않음 --%>
		 
		 
		 
		 <%-- JSTL --%>
		 
		 <p><c:out value="${1 + 10 }"></c:out></p>
		 
		 <c:url var="rent"  value="rent" ></c:url>
		 <%-- <c:redirect url="${rent }"></c:redirect> --%>
		 
		 <%
         ClientRequestDto client = new ClientRequestDto();
         pageContext.setAttribute("data", client);

		 %>
		 
		 <%-- core set 태그 사용방법 1) --%>
		 <%-- setAttribute(속성명, 속성값) --%>
		 <c:set var="client" value="${pageScope.data}" scope="session"/>

		 <%-- core set 태그 사용방법 2) --%>
		 <%-- setProperty() --%>
		 <%-- public setter가 있는 속성값에 한하여 설정 가능 --%>
		 <c:set target="${client}" property="name" value="김봉진"/>

		 <%-- public setter가 있는 속성값에 한하여, .속성명으로 얻어올 수 있다. --%>
		 <p>client : <c:out value="${client.name}"/></p>
		 <p>client : <c:out value="${empty client.getName()}"/></p>
		 
		 
		 <c:remove var="client"/>
		 <p>client : <c:out value="${empty client.getname }"></c:out></p>
		 
		 
		 <c:if test="${1 > 2 }">
		 	<button>click</button>
		 </c:if>
		 
		 <c:choose>
		 	<c:when test=""></c:when>
		 	<c:when test=""></c:when>
		 	<c:when test=""></c:when>
		 	<c:when test=""></c:when>
		 	<c:when test=""></c:when>
		 	<c:otherwise></c:otherwise>
		 </c:choose>
		 
		 <c:import url="service">
		 	<c:param name="command" value="hello world"></c:param>
		 </c:import>

		<%
		ClientDao dao = ClientDao.getInstance();
		ArrayList<Client> list = dao.getClientAll();
		int a = list.size();
		
		pageContext.setAttribute("list", list);
		%>
		<p>size : ${a}</p>
		
		<c:forEach items="${pageScope.list}" var="client" begin="1"  step="2">
			<p>${member.name}</p>
		</c:forEach>
		
		<c:forEach items="${pageScope.list}" var="client" varStatus="info">
			<p>${info.index} [${info.count }]</p>
		</c:forEach>
		
		<c:forTokens items="가/나/다" delims="/" var="data">
			<p>${data}</p>
		</c:forTokens>










	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>