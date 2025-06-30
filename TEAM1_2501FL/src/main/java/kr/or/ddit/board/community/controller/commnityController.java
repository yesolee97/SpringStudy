package kr.or.ddit.board.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class commnityController {
	
	@GetMapping("/board/commnity")
	public String getCommnity() {
		return "board/commnity/commnityList";
	}
	
	@GetMapping("/board/commnity/view")
	public String getCommnityView() {
		return "board/commnity/commnityView";
	}
}
