/**
 * 
 */
// 20250617 수업내용
document.addEventListener("DOMContentLoaded", ()=>{
	// 전이중 통신구조 웹소켓 개방 > 요청이 한번은 넘어가야함 (http기반이라서)
	const ws = new WebSocket("ws://localhost/ws/meeting/status");
	// 자바스크립트는 보통 이벤트를 처리할떄 on을 붙여줌, onopen / onclose / onmassage
	ws.onopen=console.log;
	ws.onclose=console.log;
	ws.onerror=console.error;
	ws.onmessage=function({data}){ // e를 받아소 e.data;를 하면 message를 꺼내는건데, 아예 첨부터 구조분해로 꺼내기
		// alert(data);
		contentarea.innerHTML = data;
	}
	
	// attr은 무조건 속성값ㄹ을 문자열로 줘야함
	$(".edit").prop("contenteditable", true);
	$("#sendbtn").on("click", ()=>{
		const message = contentarea.innerHTML;	// contentarea 한테 테이블 소스 꺼냄
		ws.send(message);	// 보낼때는 sand!!!
	})
 })