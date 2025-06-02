package kr.or.ddit.case01.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.ws.rs.POST;
import lombok.extern.slf4j.Slf4j;

/**
 * case01/rest/api로 발생하는 요청에 대한 핸들러 매핑
 * CRUD 요청 처리 가능해야함
 * 해당 요청에서 POST/PUT 요청의 경우, body컨텐츠로 json을 수신함
 */
@Slf4j
// 스프링 컨테이너가 빈을 등록하는 조건으로 사용되고,
// 잠재적으로 내부에 핸들러메소드가 있을거라고 가정을 함 > HandlerMapping에 의해 핸들러 메소드의 클래스로 수집됨
@Controller	
@RequestMapping(value = "case01/rest/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Case01RestController {
	
	@GetMapping()
	public void handler01() {
		log.info("API Get 메소드 요청 성공", this.getClass().getSimpleName());
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void handler02() {
		log.info("API POST 요청 성공", this.getClass().getSimpleName());
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void handler03() {
		log.info("API PUT 요청 성공", this.getClass().getSimpleName());
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void handler04() {
		log.info("API PUT 요청 성공", this.getClass().getSimpleName());
	}
	
}
