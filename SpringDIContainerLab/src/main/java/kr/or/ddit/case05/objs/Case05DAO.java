package kr.or.ddit.case05.objs;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class Case05DAO {
	
	@PostConstruct
	public void start() {
		log.info("★★ DAO 생성자 {}", this.getClass().getSimpleName());
	}
}
