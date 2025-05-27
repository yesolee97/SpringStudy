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
		<table class="table">
			<tr>
				<td colspan="2">
					<c:url value="/buyer/buyerUpdate.do" var="updateURL">
						<c:param name="what" value="${buyer.buyerId}" />
					</c:url>					
					<a href="${updateURL}" class="btn btn-primary">수정</a>
				</td>
			</tr>
			<tr><th>기본주소</th><td>${buyer.buyerAdd1}</td></tr>
			<tr><th>상세주소</th><td>${buyer.buyerAdd2}</td></tr>
			<tr><th>회사전화번호</th><td>${buyer.buyerComtel}</td></tr>
			<tr><th>팩스번호</th><td>${buyer.buyerFax}</td></tr>
			<tr><th>메일주소</th><td>${buyer.buyerMail}</td></tr>
			<tr><th>담당자</th><td>${buyer.buyerCharger}</td></tr>
			<tr><th>몰라</th><td>${buyer.buyerTelext}</td></tr>
			<tr><th>거래처이름(*)</th><td>${buyer.buyerName}</td></tr>
			<tr><th>분류코드(*)</th><td>${buyer.lprod.lprodName}</td></tr>
			<tr><th>주거래은행</th><td>${buyer.buyerBank}</td></tr>
			<tr><th>계좌번호</th><td>${buyer.buyerBankno}</td></tr>
			<tr><th>예금주</th><td>${buyer.buyerBankname}</td></tr>
			<tr><th>우편번호</th><td>${buyer.buyerZip}</td></tr>
			<tr>
				<th>거래품목</th>			
				<td>
					<table>
						<tbody>
							<c:choose>
								<c:when  test="${not empty buyer.prodList}">
									<c:forEach items="${buyer.prodList}" var="prod">
										<tr>
											<th>상품명</th>
											<td>${prod.prodName }</td>
										</tr>
										<tr>
											<th>소비자가</th>
											<td>${prod.prodCost }</td>
										</tr>
										<tr>
											<th>판매가</th>
											<td>${prod.prodPrice }</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<th colspan="3">해당 상품이 존재하지 않습니다.</th>
									</tr>
									
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</td>
			</tr>
			
		</table>
</main>
</body>
</html>