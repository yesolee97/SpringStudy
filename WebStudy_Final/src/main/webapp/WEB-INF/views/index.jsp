<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>SSR Welcome Page: index로 만든 웰컴 페이지</h1>
	${pageContext.request.userPrincipal }
</body>
</html>