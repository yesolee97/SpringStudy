package kr.or.ddit.event.repository;

import org.springframework.data.repository.ListCrudRepository;

import kr.or.ddit.event.entity.Event;

public interface EventRepository extends ListCrudRepository<Event, Long>{
	
}
