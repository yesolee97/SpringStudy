package kr.or.ddit.meeting.websocket.stomp;

import java.io.Serializable;

import lombok.Data;

@Data
public class DummyStompVO implements Serializable{
	private String sender;
	private String message;
}
