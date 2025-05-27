<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>제조사 목록</title>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", ()=>{
	/* $("body"); */
})
</script>
</head>
<body>
	<main class="container">
		<table class="table text-center">
			<thead>
				<tr>
					<th>제조사명</th>
					<th>분류명</th>
					<th>소재지</th>
					<th>전화번호</th>
					<th>담당자</th>
					<th>거래은행</th>
					<th>거래 품목 수</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty list}">
						<c:forEach items="${list }" var="buyer">
							<tr>
								<c:url value="/buyer/buyerDetail.do" var="buyerDetail">
									<c:param name="what" value="${buyer.buyerId }"></c:param>
								</c:url>
								<td>
									<a href="${buyerDetail }">${buyer.buyerName }</a>
								</td>
								<td>${buyer.lprod.lprodName }</td>
								<td>${buyer.buyerAdd1 }</td>
								<td>${buyer.buyerComtel }</td>
								<td>${buyer.buyerCharger }</td>
								<td>${buyer.buyerBank }</td>
								<td>${buyer.prodList.size() }</td>
							</tr>						
						</c:forEach>
					</c:when>
					<c:otherwise>
							<tr>
								<td colspan="7">등록된 제조사가 없습니다</td>
							</tr>						
					</c:otherwise>
				</c:choose>		
			</tbody>
		</table>
	</main>
</body>
</html>