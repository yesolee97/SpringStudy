package kr.or.ddit.case02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case02")
public class Case02SpeiceficTypeHeaderController {
	
	@GetMapping("header08")
	public void header1(@RequestHeader(value= "my-age", required = false, defaultValue = "3") int myAge){
		
	}
	
	
	/**
	 * "my-flag" 요청 헤더 수신.
	 * 옵셔널 헤더이고, 헤더값으로 true/false만 수신, 생략된 경우, 기본으로 true 수신
	 */
	@GetMapping("header09")
	public void header02(
		@RequestHeader(name = "my-flag", required = false, defaultValue = "true") boolean myFlag
	){
		log.info("/case02/hander09 수신, my-flag: {}", myFlag);
	}
}
