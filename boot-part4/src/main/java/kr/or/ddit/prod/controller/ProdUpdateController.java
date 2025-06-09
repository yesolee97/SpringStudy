package kr.or.ddit.prod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.ErrorsUtils;
import kr.or.ddit.validate.insertGroup;
import kr.or.ddit.validate.updateGroup;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * /buyer/buyerInsert.do (Get,Post)
 */

@Slf4j
//@WebServlet("/prod/prodUpdate.do")
@Controller
@RequestMapping("/prod/prodUpdate.do")
@RequiredArgsConstructor
public class ProdUpdateController{
	private final ProdService service;
	private final static String MODELNAME = "prod";
	@Autowired
	private ErrorsUtils errorsUtils;
	
	
	@GetMapping
	public String doGet(
		@RequestParam("what") String prodId
		, Model model
	) {
		// 처음 update 요청일 경우 (요청에 실패해 값을 가지고 다시 가야하는 경우가 아님)
		if(!model.containsAttribute(MODELNAME)) {	// 모델안에 MODELNAME이 없을경우 !!
			ProdVO prod = service.readProd(prodId).get();
			model.addAttribute("prod", prod);			
		}		
		model.addAttribute("action", "update");
		return "prod/prodForm";
	}
	
	
	/**
	 * form으로 입력받은 데이터 처리
	 */
	@PostMapping
	public String doPost(
		String what	// 검증의 대상 xx  >> vo에 안들어감
		, @Validated(updateGroup.class) @ModelAttribute(MODELNAME) ProdVO prod
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) {
		String lvn;
		// 3. 검증 통과
		if(!errors.hasErrors()) {
			// 3-1) 로직을 이용해 등록
			service.modifyProd(prod);
			// 3-2) PRG 패턴을 위한 logical view name 결정
			lvn = "redirect:/prod/prodDetail.do?what="+ prod.getProdId();
		}
		// 4. 검증 실패
		else {
			redirectAttributes.addFlashAttribute(MODELNAME, prod);			
			redirectAttributes.addFlashAttribute("errors", errorsUtils.errorsToMap(errors));
			// 4-2) PRG 패턴을 위한 logical view name 결정
			lvn = "redirect:/prod/prodEdit.do?what"+ what;
		}

		return lvn;
	}

}
