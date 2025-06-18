package kr.or.ddit.meeting.websocket.stomp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MeetingStatusMessageController {
	
	// 요청이 들어오는 주소, 즉 js에서 destination를 통해 보내겠다고 하는 주소!
	// /app/status destination 으로 발행한 메세지를 수신함.
	@MessageMapping("/status")
	@SendTo	// 다시 보내겠다는 뜻 
	// @payload 를 통해 요청으로 들어온 구조중의 body를 달라 !
	public DummyStompVO messageRelay(@Payload DummyStompVO dummy) {	// 알아서 마샬링
		log.info("수신된 메세지: {}" + dummy);
		return dummy;// 응답시 알아서 언마샬링
	}
}
