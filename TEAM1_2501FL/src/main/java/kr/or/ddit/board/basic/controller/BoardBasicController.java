package kr.or.ddit.board.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardBasicController {

	@GetMapping("/board/basic")
	public String getBoardBasicList(Model model) {
		model.addAttribute("fixedValueABC", true);
		return "board/basic/boardBasicList";
	}
	@GetMapping("/board/basic/view")
	public String getBoardBasicView() {
		return "board/basic/basicView";
	}
}
