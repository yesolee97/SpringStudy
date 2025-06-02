package kr.or.ddit.case01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

/**
 * 컨트롤러를 bean으로 등록하고,
 * 해당 컨트롤러가 특정 요청을 수신할 수 있는 방법.
 * 
 * @RequestMapper(url, method, header, paramter)
 * *** 특정 요청에 대한 커맨드 핸들러를 메소드를 기준으로 구현함
 * 
 * HandlerMapping 의 역할
 * 1. 컨트롤러와 핸들러 메소드에 대한 정보를 수집하고, "Handler Map"을 형성함.
 * 		- 수집 대상 조건: @Controller, @RequestMapping, @Get[Post...] Mapping 등의 어노테이션을 트레이싱함
 * 		매핑 조건을 표현하는 속성들
 * 		value: 매핑 url
 * 		method: 매핑 request method
 * 		consumes: request Content-Type 헤더에 대한 매핑 - 일치 x 415에러
 * 		produces: request Accept 헤더에 대한 매핑 - 일치 x 406에러
 * 
 * 2. Front controller가 받은 요청을 처리할 수 있는 핸들러를 검색함.
 * 		--> 검색에 실패한 경우, 4XX  계열의 상태코드로 응답이 전송됨.
 */
@Slf4j
@Controller
@RequestMapping("/case01")
public class Case01ReceieveRequestController {
	
	// POJO 방식 = 하나의 요청을 하나의 메소드로 받음
	@RequestMapping(value = "handler01", method = RequestMethod.GET)
	public void handler01() {
		log.info("handler01 요청 수신");
	}

	// 메소드와 관계없이 모든 요청ㅇㄹ 이  url로 받음		
	@RequestMapping(value = "handler02")
	public void handler02() {
		log.info("handler02 요청 수신");
	}

	// context-type이 있을때만 요청을 받을거임, 근데 이 헤더속성은 요청에 body가 있을때만 헤더에 생김
	@RequestMapping(value = "handler03", headers = "content-type=application/json")
	public void handler03() {
		log.info("handler03 요청 수신");
	}
	
	@RequestMapping(value = "handler04", params = "p1=23")
	public void handler04() {
		log.info("handler04 요청 수신");
	}
	// ------------------------------------------ ↑ 실제 많이 사용되지 않는 필터링 조건들
	
	@GetMapping("handler05")
	public void handler05_1() {
		log.info("handler05 Get 요청 수신");
	}	
	@PostMapping("handler05")
	public void handler05_2() {
		log.info("handler05 Post 요청 수신");
	}
	@PutMapping("handler05")
	public void handler05_3() {
		log.info("handler05 Put 요청 수신");
	}
	@DeleteMapping("handler05")
	public void handler05_4() {
		log.info("handler05 Delte 요청 수신");
	}


	@PostConstruct
	public void init() {
		log.info("{} 빈 등록 완료", this.getClass().getSimpleName());
	}
}
