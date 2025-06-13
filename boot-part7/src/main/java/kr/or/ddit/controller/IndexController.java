package kr.or.ddit.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class IndexController {
	
	@GetMapping("/")
	public String getIndex(
		Authentication authentication
	) {
		log.info("인증 객체: {}", authentication);
		return "index";
	}
}
