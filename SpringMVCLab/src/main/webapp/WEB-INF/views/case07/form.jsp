<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath }/case07/commandObject02" modelAttribute="dummy">
	<%-- <input  type="text" name="name" value="${name}"/> --%>
	<form:input path="name" />
	<form:errors path="name" />
	
	<form:input path="age" type="number"/>
	<form:errors path="age" />
	
	<form:checkbox path="hobbies" value="취미1" label="취미1"/>
	<form:checkbox path="hobbies" value="취미2" label="취미2"/>	
	<form:errors path="hobbies" />
	
	<button type="submit"></button>
</form:form>
</body>
</html>