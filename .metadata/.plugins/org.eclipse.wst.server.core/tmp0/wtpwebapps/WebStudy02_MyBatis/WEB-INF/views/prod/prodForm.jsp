<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value='/resources/js/app/prod/ProdForm.js'/>"></script>
</head>
<body>
<div class="card">
  <div class="card-header">
    <h5>Form controls</h5>
  </div>
  <div class="card-body">
    <div class="row">
    
       <form method="post" enctype="application/x-www-form-urlencoded">
       		<c:if test="${action eq 'update'}">
				<input type="hidden" name="prodId" value="${prod.prodId}" readonly />
				<span class="text-danger">${errors.prodId }</span>
       		</c:if>
			
			<div class="form-group">
				<label class="form-label" for="prodName">상품명</label>
				<input
					type="text" id="prodName" name="prodName" class="form-control"
					placeholder="상품명">
				<span class="text-danger">${errors.prodName }</span>
			</div>
			<div class="form-group">
				<label class="form-label" for="lprodGu">분류코드</label>
				<select name="LprodGu" id="LprodGu" class="form-select" data-init-val="${prod.lprodGu}">
					<option value="">분류선택</option>			
				</select>
				<span class="text-danger">${errors.lprodGu }</span>
			</div>
			<div class="form-group">
				<label class="form-label" for="buyerId">거래처코드(외래키,
					부모테이블:LPROD)</label>
					<select name="buyerId" id="buyerId" class="form-select" data-init-val="${prod.buyerId}">
						<option value="">거래처 선택</option>			
					</select>
				<span class="text-danger">${errors.buyerId }</span>
			</div>
			<div class="form-group">
				<label class="form-label" for="prodCost">매입단가</label>
				<input
					type="number" id="prodCost" name="prodCost" class="form-control"
					placeholder="매입단가">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodPrice">매출단가</label>
				<input
					type="number" id="prodPrice" name="prodPrice"
					class="form-control" placeholder="매출단가">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodSale">할인판매단가</label>
				<input
					type="number" id="prodSale" name="prodSale" class="form-control"
					placeholder="할인판매단가">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodOutline">매충 설명</label>
				<input
					type="text" id="prodOutline" name="prodOutline"
					class="form-control" placeholder="매충 설명">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodDetail">자세한설명</label>
				<input
					type="text" id="prodDetail" name="prodDetail"
					class="form-control" placeholder="자세한설명">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodImg">상품이미지</label>
				<input
					type="text" id="prodImg" name="prodImg" class="form-control"
					placeholder="상품이미지">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodTotalstock">전재고량</label>
				<input
					type="number" id="prodTotalstock" name="prodTotalstock"
					class="form-control" placeholder="전재고량">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodProperstock">적정재고</label>
				<input
					type="number" id="prodProperstock" name="prodProperstock"
					class="form-control" placeholder="적정재고">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodSize">크기</label>
				<input
					type="text" id="prodSize" name="prodSize" class="form-control"
					placeholder="크기">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodColor">색상</label>
				<input
					type="text" id="prodColor" name="prodColor" class="form-control"
					placeholder="색상">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodDelivery">배송주의사항</label>
				<input
					type="text" id="prodDelivery" name="prodDelivery"
					class="form-control" placeholder="배송주의사항">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodUnit">판매단위</label>
				<input
					type="text" id="prodUnit" name="prodUnit" class="form-control"
					placeholder="판매단위">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodQtyin">포장수량</label>
				<input
					type="number" id="prodQtyin" name="prodQtyin"
					class="form-control" placeholder="포장수량">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodQtysale">판매단위수량</label>
				<input
					type="number" id="prodQtysale" name="prodQtysale"
					class="form-control" placeholder="판매단위수량">
			</div>
			<div class="form-group">
				<label class="form-label" for="prodMileage">마일리지</label>
				<input
					type="number" id="prodMileage" name="prodMileage"
					class="form-control" placeholder="마일리지">
			</div>
					

			<div>
				<button type="submit" class="btn btn-primary mb-4">Submit</button>
				<button type="reset" class="btn btn-danger mb-4">Submit</button>
			</div>
			
	
	
	
	
			<div class="form-group">
				<label class="form-label" for="exampleFormControlSelect1">Example
					select</label> <select class="form-select" id="exampleFormControlSelect1">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>
			</div>
			<div class="form-group">
           <label class="form-label" for="exampleFormControlTextarea1">Example textarea</label>
           <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
         </div>
       </form>
    </div>
  </div>
</div>
</body>
</html>