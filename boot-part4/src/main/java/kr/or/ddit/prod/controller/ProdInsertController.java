package kr.or.ddit.prod.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.BindErrorUtils;

import jakarta.validation.Valid;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.ErrorsUtils;
import kr.or.ddit.validate.insertGroup;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * /buyer/buyerInsert.do (Get,Post)
 */

@Slf4j
//@WebServlet("/prod/prodInsert.do")
@Controller
@RequestMapping("/prod/prodInsert.do")
@RequiredArgsConstructor
public class ProdInsertController {
	private final ProdService service;
	private static final String MODELNAME = "prod";
	@Autowired	
	private ErrorsUtils errorsUtils;
	
	@ModelAttribute(MODELNAME)
	public ProdVO prod() {
		return new ProdVO();
	}
	
	@GetMapping
	public String doGet() {
		// logical viewname
		return "prod/prodForm";
	}
	
	
	/**
	 * form으로 입력받은 데이터 처리
	 */
	@PostMapping
	public String doPost(
		@Validated(insertGroup.class) @ModelAttribute(MODELNAME) ProdVO prod
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) {
		String lvn;
		// 3. 검증 통과
		if(!errors.hasErrors()) {
			// 3-1) 로직을 이용해 등록
			service.createProd(prod);
			// 3-2) PRG 패턴을 위한 logical view name 결정
			lvn = "redirect:/prod/prodDetail.do?what="+prod.getProdId();
		}
		// 4. 검증 실패
		else {
			// 4-1) 세션 스코프를 이용해서 command object, errors 전달 (flash attrivute)
			redirectAttributes.addFlashAttribute(MODELNAME, prod);

//			BindErrorUtils.resolve(null)	// 나중에 사용해보기			
//			String errorName = BindingResult.MODEL_KEY_PREFIX +  MODELNAME;			
//			redirectAttributes.addFlashAttribute(errorName, errors);
						
			MultiValueMap<String, String> customErrors = errorsUtils.errorsToMap(errors);
			redirectAttributes.addFlashAttribute("errors", customErrors);

			// 4-2) PRG 패턴을 위한 logical view name 결정
			lvn = "redirect:/prod/prodInsert.do";
		}		

		// 3-3) viewResolver 이용 실제 이동
		// 4-3) ViewResolver 이용
		// 등록 성공
		return lvn;
	}

}
