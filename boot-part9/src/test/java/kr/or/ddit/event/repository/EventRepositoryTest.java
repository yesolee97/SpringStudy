package kr.or.ddit.event.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.event.entity.Event;

@SpringBootTest
class EventRepositoryTest {
	
	@Autowired
	EventRepository repository;	
	

	@Test
	void testFindAll() {
		repository.findAll().forEach(System.out::println);
	}

	@Test
	void testSave() {
		Event e1 = new Event("새로 추가한 이벤트", LocalDateTime.now());
		repository.save(e1);
	}

	@Test
	void testFindById() {
		assertDoesNotThrow(()->{
			Optional<Event> optional = repository.findById(1l);
			Event event = optional.orElseThrow();
			System.out.println(event);
		});
	}

	@Test
	void testDeleteById() {
		repository.deleteById(2l);
	}
	

	@Test
	@Transactional
	void testUpdate() {
		Event event = repository.findById(1l).get();
		event.setTitle("일정 제목 변경");
	}

}
