package kr.or.ddit.meeting.websocket;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Component
public class MeetingStatusWebSocketHandler extends TextWebSocketHandler {
	@Value("${contentFile}")
	private Path contentFile;	// 해당 디렉토리나 경로에 대한 정보만 가직 있는 객체 = Path
	
	// 단점 2. 모든 사용자의 접속 정보를 우리가 직접 관리해야함, 근데 멀티 스레딩 고려 전혀 안하는 중 
	private List<WebSocketSession> sessionList = new ArrayList<>();
	
	//  연결된 웹 소켓 대상으로 해서 세션이 하나 만들어짐, 상윤이가 접속하면 상윤이세션, 윤석이가 접속하면 윤석이 세션만들어짐
	// >> 이걸 다 모아놓을 수 있는 컬렉션이 필요함
	// 이 메소드가 실행됐다는 건 연결이 수립됐다는것
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 여기서 모아놓은 session한테 한번에 방송해줄 수 있음
		// 연결중인 사람만 남아있음
		sessionList.add(session);
	}
	
	
	// 메세지를 수신받는 메세지 - 웹소켓 연결을 통해서 누군가가 보내온 메세지
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 경로, 기록할대상 - message, 추가할건지 덮어씌울건지 정해줌 
		// 단점 3. getPayload는 그냥 문자열임, 구조화가 전혀 안되어있음
		Files.writeString(contentFile, message.getPayload(), StandardOpenOption.WRITE);
		
		// 반복문 돌려서 현재 접속되어있는 사람한테 메세지 다 발송해줌 - 단점1. 강제로 발송, 연결되어있는 사용자는 모두 메세지를 받아야함
		for(WebSocketSession single: sessionList) {
			single.sendMessage(message);
		}
	}
	
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 연결 끊길 때 삭제해줌
		sessionList.remove(session);
	}
}
