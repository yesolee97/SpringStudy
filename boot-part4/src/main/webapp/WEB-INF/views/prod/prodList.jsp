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

<main class="container mt-5">
	<h4>상품 목록</h4>
	<table class="table">
		<thead>
			<tr>
				<th>상품명</th>
				<th>상품분류</th>
				<th>제조사</th>
				<th>구매가</th>
				<th>판매가</th>
				<th>요약정보</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty prodList }">
				<c:forEach var="prod" items="${prodList }" >
					<c:url value="/prod/prodDetail.do" var="detailUrl">
						<c:param name="what" value="${prod.prodId}"></c:param>
					</c:url>
					<c:url value="/buyer/buyerDetail.do" var="buyerDetailUrl">
						<c:param name="what" value="${prod.buyerId}"></c:param>
					</c:url>
					<tr>
						<td>
							<a href="${detailUrl }">${prod.prodName }</a>
						</td>
						<td>${prod.lprod.lprodName }</td>
						<td>
							<a href="${buyerDetailUrl }">${prod.buyer.buyerName }</a></td>
						<td>${prod.prodPrice }</td>
						<td>${prod.prodCost }</td>
						<td>${prod.prodOutline }</td>
					</tr>				
				</c:forEach>
			</c:if>
			<c:if test="${empty prodList }">
				<tr>
					<td colspan="6">상품이 없습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</main>
</body>
</html>