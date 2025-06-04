package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.validate.insertGroup;
import kr.or.ddit.vo.BuyerVO;

/**
 * /buyer/buyerInsert.do (Get,Post)
 */
 
@Controller
@RequestMapping("/buyer/buyerInsert.do")
public class BuyerInsertController {
	@Autowired
	private BuyerService service;
	
	static final String MODELNAME = "buyer";
	
	@ModelAttribute(MODELNAME)
	public BuyerVO buyer() {
		return new BuyerVO();
	}
	
	/**
	 * 등록 form 제공
	 */
	@GetMapping
	public String formUI() {
		return "buyer/buyerForm";
	}
	
	
	/**
	 * form으로 입력받은 데이터 처리
	 */
	@PostMapping
	public String buyerInsert(
		// 커맨드 오브젝트를 어댑터한테 받을건데, 그냥 vo명으로 선언하면 객체가 2개 만들어주니까 모델 어트리뷰트를 사용해서 이름을 통일해 값을 1개만 생성할 수 있게한다.
		@Validated(insertGroup.class) @ModelAttribute(MODELNAME) BuyerVO buyer
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	){
		if(errors.hasErrors()) {		
			String errorsName = BindingResult.MODEL_KEY_PREFIX + MODELNAME;
			redirectAttributes.addFlashAttribute(errorsName, errors);
			redirectAttributes.addFlashAttribute("buyer", buyer);
			
			// 검증 실패시 입력 폼으로 리턴
			return "redirect:/buyer/buyerInsert.do";
			
		}else {	
			service.createBuyer(buyer);
			// PRG 패턴
			return "redirect:/buyer/buyerList.do";
		}
	}

}
