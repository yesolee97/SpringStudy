package kr.or.ddit.event.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventDTO implements Serializable{
	private Long id;
	private String title;
	private LocalDateTime date;
	
	
	public EventDTO(String title) {
		super();
		this.title = title;
	}
	public EventDTO(String title, LocalDateTime date) {
		super();
		this.title = title;
		this.date = date;
	}	
}
