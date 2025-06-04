package kr.or.ddit.case06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case06/calculate")
public class Case06CalculateController {
	/* 
	 	
	 	3. 연산결과: get
	 */
	
	// 	1. from으로 연결: get
	@GetMapping()
	public String calForm(Model model) {
		return "case06/calForm";
	}
	
	// 2. from-data 처리: post => redirect로 3번으로 이동
	@PostMapping()
	public String calc(
		@RequestParam int op1
		, @RequestParam int op2
		, RedirectAttributes model // flash Map에 옮겨담고 이걸 다시 model에 옮겨줌 !!
	) {
		int result = op1 + op2;
		model.addFlashAttribute("result", result);
		// return "redirect:calculate/result";
		return "redirect:calculate";
	}
	

	@GetMapping("/result")
	public String result(Model model) {
		log.info("{}", model.getAttribute("result"));
		return "case06/result";
	}
	
}
