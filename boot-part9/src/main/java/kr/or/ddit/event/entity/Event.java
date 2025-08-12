package kr.or.ddit.event.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 테이블에서 레코드 하나를 가져올 떄 이 엔터티가 사용됨
@Entity
@Table(name = "Events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
	@Id
	@GeneratedValue // 값을 입력받아서 넣는게 아니라 자동생성하겠다는 의미, 시퀀스도 자동으로 만들어줌, 시퀀스가 없을경우에는 자동으로 만들어줌
	private Long id;
	private String title;
	@Column(name="EVENTDATE")
	private LocalDateTime date;
	
	
	public Event(String title, LocalDateTime date) {
		super();
		this.title = title;
		this.date = date;
	}
}
