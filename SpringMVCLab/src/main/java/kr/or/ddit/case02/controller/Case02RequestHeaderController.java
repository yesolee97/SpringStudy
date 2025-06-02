package kr.or.ddit.case02.controller;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * 요청 헤더를 수신하고, 그걸 파싱하고, 핸들러 메소드를 실행하는 건??
 * HandlerAdapter 에 의해 처리됨.
 * 
 * 요청헤더 수신: @RequestHeader(name, requried, defaultValue)
 * 파싱?? : 핸들러 메소드 아규먼트 타입으로 파싱 타입이 결정됨
 * ex) @RequestHeader(name="myAge", required="false", defaultValue="34")int myAge
 * 
 * HandlerAdapter
 * 	: HandlerMapping > 핸들러를 검색하면, HandlerAdapter가 POJO 기반의 핸들러를 실행하는 역할을 함
 */
@Slf4j
@Controller
@RequestMapping("/case02")
public class Case02RequestHeaderController {
	
	@GetMapping("header01")
	public void handler01(HttpServletRequest req) {
		log.info("case02/header01 수신, accept Header: {}", req.getHeader("accept"));
	}
	
	
	@GetMapping("header02")
	// (@RequestHeader("accept") 어노테이션으로 request에서 헤더 꺼낸거랑 같은 효과
	public void handler02(@RequestHeader("accept") String accept) {
		log.info("case02/header02 수신, accept Header: {}", accept);
	}
	@GetMapping("header03")
	// (@RequestHeader 아무것도 안쓰면? >  coc가 적용된다. 파라미터명과 이름이 같은 경우 알아서 넣어줌
	public void header03(@RequestHeader("accept-language") String acceptLanguage) {
		log.info("case02/header03 수신, accept Header: {}", acceptLanguage);
	}
	@GetMapping("header04")
	// 넘어오는 모든 요청의 Header를 받고싶은 경우: 멀티 벨류맵 ( 벨류의 타입을 리스트로 만든다 )
	public void header04(@RequestHeader MultiValueMap<String, String> headers) {
		log.info("case02/header04 수신, accept Header: {}", headers);
	}
	@GetMapping("header05")
	// 멀티 벨류맵을 상속받아 만든 구현체!! 이걸 사용ㅎ면 멀티벨류 사용한것과 동일한 효과를 낸다
	public void header05(@RequestHeader HttpHeaders headers) {
		log.info("case02/header05 수신, accept Header: {}", headers);
	}
	@GetMapping("header06")
	// 넘어오는 모든 요청의 Header를 받고싶은 경우: 멀티 벨류맵 ( 벨류의 타입을 리스트로 만든다 )
	public void header06(@RequestHeader String cookie) {
		log.info("case02/header06 수신, Cookie: {}", cookie);
	}
	@GetMapping("header07")
	// 넘어오는 모든 요청의 Header를 받고싶은 경우: 멀티 벨류맵 ( 벨류의 타입을 리스트로 만든다 )
	public void header07(@CookieValue(value = "dummyCookie", required = false, defaultValue = "DEFAULTVALUE") String dummyCookie) {
		log.info("case02/header07 수신, dummyCookie: {}", dummyCookie);
	}
	
	// requeired 는 기본값이 true임, 이걸 false로 바꾸면 ? >> 기본값도 설정해줄수 있다!!
}
