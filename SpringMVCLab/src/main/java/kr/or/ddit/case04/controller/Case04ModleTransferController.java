package kr.or.ddit.case04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;


/**
 *   /case04/model01(GET) 요청을 수신하고,
 *   최종 응답은 "case04/view01"에서 전송함. 
 *   Model, ModelAndView, @ModelAttrbute
 *   
 *   *** 최종적으로 Handler Adapter에게 Model과View 에 대한 정보를 전달하는 법을 봐야함 !!!!!
 *   
 *   Model: 모델과 뷰의 전달을 따로 함. model은 call by reference 형태로 전달하기 위해 핸들러 메소드의 인자로 Model을 받음
 *   	  : logical view name 은 반환값의 형태로 전달
 *   ModelAndView : ModelAndView라는 반환 객체로 model과 view를 한번에 전달
 *   @ModelAttrbute : 하나의 컨트롤러 클래스에 여러 핸들러 메소드가 있고, 각 핸들러가 공통적으로 전달해야할 model이 있는경우에 사용
 *   		Model을 반환하는 메소드를 구현하고, 해당 메소드의 반환타입에 @ModelAttribute 를 사용함  
 */
@Controller
@RequestMapping("/case04")
public class Case04ModleTransferController{
	
	// 기존에 작업하던 방식 !
//	@GetMapping("model01")
//	public String handler01(HttpServletRequest req){		
//		String model = "MODEL INFO";
//		req.setAttribute("modelAttr", model);
//		String lvn = "case04/view01";
//		return lvn;
//	}
	
	// 1. 모델데이터를 전달하는 방법 - 스프링이 인지할 수 있음 > 모델을 전달하는 과정에서 여러가지 작업 진행할 수 있음
	// 이렇게 담아도 이게 request라는 스코프에 그대로 옮겨진데 !!
	@GetMapping("model01")
	public String handler01(Model model){		
		String modelAttr = "MODEL INFO";
		model.addAttribute("modelAttr", modelAttr);
		String lvn = "case04/view01";
		return lvn;
	}
	
	
	// 2. 반환객체 1개에 담아서 넘기는 법, 1번과 다르지 않음
	@GetMapping("model02")
	public ModelAndView handler02(){
		ModelAndView mav = new ModelAndView();
		String modelAttr = "MODEL INFO";
		mav.addObject("modelAttr", modelAttr);
		mav.setViewName("case04/view01");
		return mav;
	}
}
