package kr.or.ddit.case05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case05")
public class Case05ForwardingController {
	
	@RequestMapping("start01")
//	전달할떄는 Model로 전달함, 여기서는 req가 살아있어서 req에 저장해줘도됌 >> PRG 패턴에서는 주의해줘야함 
	public String start01(Model model) {
		model.addAttribute("modelInfo","전달할 모델");
		// forwording을 할 때 사용하는 프리픽스		
		return "forward:/case05/dest01";
	}
	
	@RequestMapping("dest01")
	// 요가서 받을때는 @RequestAttribute이걸로 꺼냄
	public String dest01(@RequestAttribute() String modelInfo) {
		log.info("{}", modelInfo);
		return "case05/view01";
		
	}
}
