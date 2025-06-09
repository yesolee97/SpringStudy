/**
 * 
 */

document.addEventListener("DOMContentLoaded", ()=>{
	const lprodGuSel = document.querySelector("[name='LprodGu']");
	const guInitVal = lprodGuSel.dataset.initVal;
	console.log(lprodGuSel);
	/*alert(axios)*/
	const CPATH = document.body.dataset.contextPath;
	axios.get(`${CPATH}/rest/lprod`)
	.then(resp=>{
		/*
		기존 방법
		let json = resp.data;	// json 데이터 넘어오면 언마샬링해줌
		if(resp.data.lprodList){
			const lprodList = resp.data.lprodList;
		}*/
		
		console.log(resp.data)
		//구조분해로 꺼내는 방법
		const lprodList = resp.data;
		if(lprodList){
			const options = lprodList.map(({lprodGu, lprodName})=> 
				`<option value="${lprodGu}">${lprodName}</option>`).join("\n");
			lprodGuSel.innerHTML += options;
			// if(initVal){select.value = initVal;}
			lprodGuSel.value = guInitVal ?? ""; // initVal가 있으면 select.value에 할당, 없으면 ""를 할당해라
			
		}
	})
	

	const buyerIdSel = document.querySelector("[name='buyerId']");
	const idInitVal = buyerIdSel.dataset.initVal;
	axios.get(`${CPATH}/rest/buyer`)
	.then(resp=>{		
		//구조분해로 꺼내는 방법
		const list = resp.data;
		if(list){
			const options = list.map(({buyerId, buyerName, lprodGu})=> 
				`<option class="${lprodGu}" value="${buyerId}">${buyerName}</option>`).join("\n");
			console.log(options);
			buyerIdSel.innerHTML += options;
			// if(initVal){select.value = initVal;}
			buyerIdSel.value = idInitVal ?? ""; // initVal가 있으면 select.value에 할당, 없으면 ""를 할당해라
			
			
		}
	})
	lprodGuSel.addEventListener("change", (e)=>{
		const selGu = e.target.value; // P101
		buyerIdSel.querySelectorAll("option[class]").forEach(op=>{
			// op에 selGu가 포함되어있으면 ~
			if(op.classList.contains(selGu)){
				op.style.display = "block";	// 눈에 보이게
			} else{
				op.style.display = "none";
			}
		})
	})
})