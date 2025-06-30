package kr.or.ddit.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	@GetMapping
	public String getIdx() {
		return "index";
	}
	

	@GetMapping("/login")
	public String getLoginForm() {
		return "login/loginForm";
	}
	
	// 개인회원가입
	@GetMapping("/signUp")
	public String getSignUp() {
		return "join/joinForm";
	}
	
	// 기업회원가입
	@GetMapping("/signUp/corp")
	public String getSingCorp() {
		return "join/joinFormCorp";
	}
}
