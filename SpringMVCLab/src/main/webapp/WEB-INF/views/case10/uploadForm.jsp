<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
	파일 업로드 처리
	1. Front-end (form UI) 
		1) request body를 형성하기 위해 method(POST) 설정
		2) request body를 형성하기 위해 content-type 설정 : enctype
		3) multipart content 형태로 전송됨 : MIME : multipart/form-data
		4) Part 하나는 별도의 헤더를 가지고 있음.
			Content-Disposition: Part name(파트이름=input의 name), file name(파일이름)
			Content-Type: file mime type (Content-type 헤더가 없는 경우, 문자Part로 인식되고, 파라미터 맵으로 형성됨)
			
	2. Back-end(multipart request process) : multipart-config 설정 필요
		1) 서블릿 스펙 - 기존에 사용하던 코드(java 기반) (각 서블릿에 multipart-config 설정)
			Part 를 통해 하나의 파트를 캡슐화함  - 멀티파트 하나하나를 가지고 놀 수 있는 api가 필요
			getPart(PartName), Conllection &lt;Part&rt; getParts()
			문자기반 파트: getParamter... 기존과 그대로 사용
			파일기반 파트: 서버 사이드의 특정 위치(이게 먼저 결정 돼야함)에 저장(Part.write)
			
		2) Spring webmvc: dispatcherServlet에 multipart-config 설정 (얘는 한번만 설행해줘도 됨)
			MultipartFile을 통해 하나의 파트를 캡슐화함
			핸들러 메소드 인자로 MultiPartFile, @RequesetPart 받음! 전송파일이 여러개일 경우 > MultipartFile[] (배열), command object (VO)로 한번에 받기 가능
			문자기반 파트: @RequestParam
			파일기반 파트: 서버사이드의 특정 위치에 저장 (MultipartFile transferTo)
			
</pre>

<form method="post" enctype="multipart/form-data">
<pre>
	<input type="text" name="uploader" placeholder="업로더" />
	<input type="file" name="uploadFile" placeholder="업로드파일" />
	<button type="submit">업로드</button>
</pre>
</form>
<c:if test="${not empty saveName}">
	업로드된 파일명 :${saveName }
</c:if>
</body>
</html>