package kr.or.ddit.event.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.event.dto.EventDTO;
import kr.or.ddit.event.entity.Event;
import kr.or.ddit.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {
	private final EventRepository repository;
	private final ModelMapper mapper;
	
	
	@Transactional
	public void createEvent(EventDTO dto){
		Event entity = new Event();
//		entity.setTitle(dto.getTitle());
//		entity.setDate(dto.getDate());
		mapper.map(dto, entity);
		repository.save(entity);
	}
	
	
	public List<EventDTO> readAll() {
		return repository.findAll().stream()
			.map(entity->
				mapper.map(entity, EventDTO.class)
//				EventDTO dto = new EventDTO();
//				dto.setId(entity.getId());
//				dto.setTitle(entity.getTitle());
//				dto.setDate(entity.getDate());
//				return dto;
			).toList();
	}
	
	@Transactional
	public void modify(EventDTO dto) {
		Event entity = repository.findById(dto.getId()).orElseThrow();
		mapper.map(dto, entity);
//		if(dto.getTitle()!=null)
//		entity.setTitle(dto.getTitle());
	}
}
