package kr.or.ddit.case08.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/case08")
public class Case08JsonResponseController {
	
	// map to json
	@GetMapping("json01")
	@ResponseBody // 리턴 값을 body에 담아서 보내겠다
	public Map handler01() {
		Map<String, Object> original = new HashMap<>();
		original.put("prop1", "문자열");
		original.put("prop2", 23);
		original.put("prop3", new String[] {"a1", "b2"});
		return original;
		
	}
	
	/**
	 * @param model
	 * 기존 처리 방식 !!
	 * accept 요청 헤더를 기준으로 content-type을 협상하는 방식
	 * ContentNegotiatingViewResolver의 동작방식에 따라 GsonView 에서 마샬링이 처리되는 방식
	 */
	
	@GetMapping("json02")
	public void handler02(Model model) {
		Map<String, Object> original = new HashMap<>();
		original.put("prop1", "문자열");
		original.put("prop2", 23);
		original.put("prop3", new String[] {"a1", "b2"});
		model.addAllAttributes(original);
		
	}

}
