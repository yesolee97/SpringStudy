<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>웰컴페이지</h1>
<h4>${pageContext.request.userPrincipal }</h4>
<security:authorize access="isAuthenticated()">
	<security:authentication property="principal" var="principal"/>
	${principal.realUser }
	<a href="/logout">로그아웃</a>
</security:authorize>

<security:authorize access="isAnonymous()">
	<a href="/login">로그인</a>
</security:authorize>
</body>
</html>