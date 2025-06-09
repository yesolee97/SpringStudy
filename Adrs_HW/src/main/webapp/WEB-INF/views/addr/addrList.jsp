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
	<h1>Arrd List</h1>
	<table class="table">
		<thead>
			<th>번호</th>
			<th>소유자</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>주소</th>
		</thead>
		<tbody id="addrList">
		</tbody>
	</table>
	
	<script type="text/javascript">
		const addrTable = document.querySelector("#addrList");	// tbody 태그
		document.addEventListener("DOMContentLoaded", async function(){
		try {
			const resp = await axios.get(`<c:url value="/rest/addr/list"/>`);
			const addrList = resp.data;
			addrTable.innerHTML = "";
			
			if (Array.isArray(addrList) && addrList.length > 0) {
	            // 주소 목록이 유효하고 데이터가 있을 경우
	            const html = addrList.map(addr => {
	                return `
	                    <tr>
	                        <td>\${addr.adrsNo}</td>
	                        <td><a href='<c:url value="/rest/addr/list/\${addr.adrsNo}"/>'>\${addr.memId}</a></td>
	                        <td>\${addr.adrsName}</td>
	                        <td>\${addr.adrsTel}</td>
	                        <td>\${addr.adrsAdd}</td>
	                    </tr>
	                `;
	            }).join('');
	            addrTable.innerHTML = html;
	        } else {
	            // 주소 목록이 없거나 비어있는 경우
	            addrTable.innerHTML = '<tr><td colspan="5">등록된 주소가 없습니다.</td></tr>';
	            // 단순히 비우고 싶다면: addrTable.innerHTML = "";
	        }
	    } catch (error) {
	        // 네트워크 오류 등 예외 발생 시
	        console.error("주소 목록을 불러오는 중 오류 발생:", error);
	        addrTable.innerHTML = '<tr><td colspan="5">데이터를 불러오는 데 실패했습니다. 잠시 후 다시 시도해주세요.</td></tr>';
	    }
		})
	</script>
</body>
</html>