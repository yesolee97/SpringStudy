package kr.or.ddit.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import kr.or.ddit.meeting.websocket.MeetingStatusWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer {
	
	@Autowired
	private MeetingStatusWebSocketHandler meetingHandler;
	
	
	// 핸들러 : 어떤 요청이 발생했을 떄 그 요청을 독립적으로 처리하는 것 
	// 받아주는 핸들러를 registry여기에 등록한다는 메소드
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// 이 방향으로 /ws/meeting/status 요청이 들어왔을떄 받아주는 핸들러 등록 하겠다는 말
		registry.addHandler(meetingHandler, "/ws/meeting/status");
		
	}
	
}
