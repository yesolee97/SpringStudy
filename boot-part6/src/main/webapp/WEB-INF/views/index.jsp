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
<security:authorize  url="/lprod">
<ul>
	<li>
		<a href="/lprod">상품 분류</a>
	</li>
</ul>

</security:authorize>
<hr />
<security:authorize access="isAnonymous()">
	<a href="/login">로그인</a>
</security:authorize>
<security:authorize access="isAuthenticated()">
<pre>
	principal: <security:authentication property="principal"/>
	realUser : <security:authentication property="principal" var="principal"/>${principal.realUser.memName }
	details: <security:authentication property="details"/>
	authorities: <security:authentication property="authorities"/>
</pre>
<a href="/logout">로그아웃</a>
</security:authorize>
</body>
</html>