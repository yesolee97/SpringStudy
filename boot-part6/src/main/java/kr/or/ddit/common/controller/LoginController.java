package kr.or.ddit.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String getFrom() {
		return "login/loginForm";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "login/logout";
	}
	
}
