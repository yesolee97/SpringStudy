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
	<form action="" method="post">
		<security:csrfInput />
		<input type="text" name="memId" />
		<input type="password" name="memPassword" />
		<button type="submit">로그인</button>
	</form>
</body>
</html>