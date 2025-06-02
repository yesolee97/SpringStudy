package kr.or.ddit.case05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case05")
public class Case05RedirectController {
	@GetMapping("start02")
	// RedirectAttributes 사용 시 플래쉬 어트리뷰트가 사용된다 !! >> 즉, session 스코프에 저장된 데이터 리무브해주는 작업 얘가 해줌 !
	// 여기서 API를 쓰면 modelInfo를 모델에 넣어줌!! > 그래야 jsp로 넘어가기 직전 메소드에서 req에 담을 수 있기 때문
	public String start02(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("modelInfo", "전달데이터");
		
		//PRG Pattern
		return "redirect:/case05/dest02";
	}
	
	@GetMapping("dest02")
	// 여기 모델에 옮겨담을때 이미 플래시 어트리뷰트 작업 끝남
	// addFlashAttribute -> FlashMap에 데이터 저장
	// redirect
	// 새로운 Model 생성 ( dest02에 들어갈 모델 ) --> FlashMap에 저장되어 있는 flash attrbute --> Model로 이동 --> flash attribute 삭제
	public String dest02(Model model) {
		if(model.containsAttribute("modalInfo")) {
			log.info("model : {}" , model.getAttribute("modalInfo"));
		}
		return "case05/view01";
	}
	
}
