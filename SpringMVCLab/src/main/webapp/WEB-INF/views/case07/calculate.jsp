<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="calc">
		<form:input path="op1" type="number"/>
		<form:errors path="op1" cssClass="error"/>
			+
		<form:input path="op2" type="number"/>
		<form:errors path="op2" cssClass="error"/>
		
		<button type="submit">전송</button>
		<c:if test="${not empty calc }">
			연산결과 : ${calc.result}
		</c:if>
	</form:form>
</body>
</html>