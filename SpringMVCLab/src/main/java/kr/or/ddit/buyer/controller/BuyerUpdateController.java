package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.validate.ErrorsUtils;
import kr.or.ddit.validate.updateGroup;
import kr.or.ddit.vo.BuyerVO;
import lombok.RequiredArgsConstructor;

/**
 * /buyer/buyerUpdate.do (Get,Post)
 */
 

@Controller
@RequestMapping("/buyer/buyerUpdate.do")
@RequiredArgsConstructor
public class BuyerUpdateController{
	// 생성자 주입
	private final BuyerService service;
	// 셋터 주입 > 옵셔널
	private ErrorsUtils errorUtils;
	@Autowired(required = false)
	public void setErrorUtils(ErrorsUtils errorUtils) {
		this.errorUtils = errorUtils;
	}
	
	static final String MODELNAME = "buyer";
	
	
	/**
	 * 등록 form 제공
	 */
	@GetMapping
	public String editForm(
			String what
			, Model model
		) {						
		// 처음 update 요청일 경우 (요청에 실패해 값을 가지고 다시 가야하는 경우가 아님)
		if(!model.containsAttribute(MODELNAME)) {
			BuyerVO buyer = service.readBuyer(what).get();
			model.addAttribute(MODELNAME, buyer);			
		}
		
		return "buyer/buyerEdit";
	}
	
	
	/**
	 * form으로 입력받은 데이터 처리
	 */
	@PostMapping
	public String formProcess(
		String what
		, @Validated(updateGroup.class) @ModelAttribute(MODELNAME) BuyerVO buyer
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) {
		String lvn;
		if(!errors.hasErrors()) {			
			service.modifyBuyer(buyer);
			lvn = "redirect:/buyer/buyerDetail.do?what="+ buyer.getBuyerId();
		}else {
			redirectAttributes.addFlashAttribute(MODELNAME, buyer);
			MultiValueMap<String,String> customErrors = errorUtils.errorsToMap(errors);
			redirectAttributes.addFlashAttribute("errors", customErrors);
			
			lvn = "redirect:/buyer/buyerUpdate.do?what="+ what;
		}
		return lvn;
	}


	

}
