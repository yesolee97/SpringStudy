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
				<th>일련번호</th>
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
						<td>${prod.rnum }</td>
						<td>
							<a href="${detailUrl }">${prod.prodName }</a>
						</td>
						<td>${prod.lprod.lprodName }</td>
						<td><a href="${buyerDetailUrl }">${prod.buyer.buyerName }</a></td>
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
		<tfoot>
			<tr>
				<td colspan="7">
					<div id="searchUI">
						<select name="searchType">
							<option value="">전체</option>
							<option value="buyer">제조사</option>
							<option value="name">상품명</option>
						</select>
						<input type="text" name="searchWord"/>
						<button id="searchBtn">검색</button>
					</div>
					<div>${pagingHTML }</div>
				</td>
			</tr>
		</tfoot>
	</table>
	<form id="searchForm">
		<input type="text" name="page" value="1"/>
		<input type="text" name="searchType" />
		<input type="text" name="searchWord" />
	</form>
</main>
<!-- 이렇게 뺀 이유 검색하려고 ~! 삼성을 검색할건데 2번째 페이지에 나오는걸로 검색해라! -->
<script>
	function fnPaging(page){
		/* location.href="?page="+page; */
		searchForm.page.value=page;
		searchForm.requestSubmit();
	}
	document.addEventListener("DOMContentLoaded", ()=>{
		$("[name='searchType']").val("${search.searchType}");
		$("[name='searchWord']").val("${search.searchWord}");
		
		searchBtn.addEventListener("click", (e)=>{
			const target = e.target;
			const $searchUI = $(target).closest("#searchUI");
			$searchUI.find(":input[name]").each((idx,ipt)=>{
				const name = ipt.name;
				const value = $(ipt).val();			
				searchForm[name].value = value;
			})
			searchForm.requestSubmit();
		})
	})
	
	
	
</script>
</body>
</html>