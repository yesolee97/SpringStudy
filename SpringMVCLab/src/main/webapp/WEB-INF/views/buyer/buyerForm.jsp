<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script src="<c:url value='/resources/js/app/buyer/BuyerForm.js'/>"></script>
</head>
<body>
<div class="card">
  <div class="card-header">
    <h5>Form controls</h5>
  </div>
  <div class="card-body">
    <div class="row">
    	<!-- java에서는 class를 키워드로 사용하기 때문에 충돌을 피하기 위해서 굳이 cssclass라는 태그를 만들어서 사용함  -->
    	<form:form modelAttribute="buyer">
			<div class="form-group">
				<form:input path="buyerName" lable="거래처이름(*)" placeholder="거래처이름(*)" cssClass="form-control"/>
				<form:errors path="buyerName" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<select name="LprodGu" id="LprodGu" class="form-select" data-init-val="${buyer.lprodGu}">
					<option value="">분류선택</option>			
				</select>
					<span class="text-danger">${errors.lprodGu }</span>
			</div>
			<div class="form-group">
				<form:input path="buyerBank" lable="주거래은행" placeholder="주거래은행" cssClass="form-control"/>
				<form:errors path="buyerBank" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<form:input path="buyerBankno" lable="계좌번호" placeholder="계좌번호" cssClass="form-control"/>
				<form:errors path="buyerBankno" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<form:input path="buyerBankname" lable="예금주" placeholder="예금주" cssClass="form-control"/>
				<form:errors path="buyerBankname" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<form:input path="buyerZip" lable="우편번호" placeholder="우편번호" cssClass="form-control"/>
				<form:errors path="buyerZip" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<form:input path="buyerAdd1" lable="기본주소" placeholder="기본주소" cssClass="form-control"/>
				<form:errors path="buyerAdd1" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<form:input path="buyerAdd2" lable="상세주소" placeholder="상세주소" cssClass="form-control"/>
				<form:errors path="buyerAdd2" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<form:input path="buyerComtel" lable="회사전화번호" placeholder="회사전화번호" cssClass="form-control"/>
				<form:errors path="buyerComtel" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<form:input path="buyerFax" lable="팩스번호" placeholder="팩스번호" cssClass="form-control"/>
				<form:errors path="buyerFax" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<form:input path="buyerMail" lable="메일주소" placeholder="메일주소" cssClass="form-control"/>
				<form:errors path="buyerMail" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<form:input path="buyerCharger" lable="담당자" placeholder="담당자" cssClass="form-control"/>
				<form:errors path="buyerCharger" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<form:input path="buyerTelext" lable="내선번호" placeholder="내선번호" cssClass="form-control"/>
				<form:errors path="buyerTelext" cssClass="text-danger"/>
			</div>
			
			<div>
				<button type="submit" class="btn btn-primary mb-4">Submit</button>
				<button type="reset" class="btn btn-danger mb-4">Reset</button>
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
       </form:form>
    </div>
  </div>
</div>
</body>
</html>