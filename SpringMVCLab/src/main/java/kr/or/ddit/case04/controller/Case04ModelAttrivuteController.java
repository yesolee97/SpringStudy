package kr.or.ddit.case04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/case04")
public class Case04ModelAttrivuteController {

	@ModelAttribute("modelAttr")
	public String modelAttr() {
		return "MODEL INFO";
	}
	
	// 모델을 전달하는 세번째 방법 - 어노테이션을 통해 넘기는방법
	@GetMapping("model03")
	public String handler03() {
		return "case04/view01";
	}
	
	// 똑같은 모델로 전달할 수도 있음
	@GetMapping("model04")
	public String handler04() {
		return "case04/view01";
	}
}
