package kr.or.ddit.event.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import kr.or.ddit.event.dto.EventDTO;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EventServiceTest {

	@Autowired
	EventService service;
	
	
	@Order(1)
	@Test
	void testCreateEvent() {
		EventDTO dto = new EventDTO("새로 추가한 이벤트---", LocalDateTime.now()); 
		service.createEvent(dto);
	}

	@Order(2)
	@Test
	void testReadAll() {
		service.readAll().forEach(System.out::println);
	}

	@Order(3)
	@Test
	void testModify() {
		EventDTO dto = new EventDTO("일정 제목 변경---");
		dto.setId(1l);
//		dto.setDate(LocalDateTime.now().plusDays(7));
		service.modify(dto);
	}

}
