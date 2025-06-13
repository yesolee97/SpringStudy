/**
 * 
 */

document.addEventListener("DOMContentLoaded", ()=>{
	const select = document.querySelector("[name='LprodGu']");
	const initVal = select.dataset.initVal;
	console.log(select);
	/*alert(axios)*/
	const CPATH = document.body.dataset.contextPath;
	axios.get(`${CPATH}/ajax/lprod`)
	.then(resp=>{
		/*
		기존 방법
		let json = resp.data;	// json 데이터 넘어오면 언마샬링해줌
		if(resp.data.lprodList){
			const lprodList = resp.data.lprodList;
		}*/
		
		const lprodList = resp.data;
		if(lprodList){
			const options = lprodList.map(({lprodGu, lprodName})=> 
				`<option value="${lprodGu}">${lprodName}</option>`).join("\n");
			select.innerHTML += options;
			// if(initVal){select.value = initVal;}
			select.value = initVal ?? ""; // initVal가 있으면 select.value에 할당, 없으면 ""를 할당해라
			
		}
	})
})