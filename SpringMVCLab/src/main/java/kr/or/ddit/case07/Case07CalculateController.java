package kr.or.ddit.case07;

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

import jakarta.validation.Valid;
import kr.or.ddit.case07.vo.CalcVO;


/**
 * 피연산자 두개를 입력받고, 더하기 연산의 결과를 생성함.
 * 두개의 피연산자는 모두 양의 정수로 가정함 (vo에서 어노테이션 조건)
 * 검증에 통과하지 못할 경우, 커맨드 오브젝트와 스프링의 객체 검증 모델(VindingResult 사용)을 사용함.
 * form UI는 커스텀 태그 사용.
 * 
 */
@Controller
@RequestMapping("/case07/calculate")
public class Case07CalculateController {
	static final String MODELNAME = "calc";
	
	@ModelAttribute(MODELNAME)
	public CalcVO commandObj() {
		return new CalcVO();
	}
	
	@GetMapping
	public void formUI() {
//		return "case07/calculate";
	}
	
	@PostMapping
	public String calculate(
		// 위에서 만든 빈 calc랑 이름이 겹치면 그걸 가져와서 거기에 값 넣어준다 !!
		@Valid @ModelAttribute(MODELNAME) CalcVO calc
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) {
		if(errors.hasErrors()) {
			redirectAttributes.addFlashAttribute(MODELNAME, calc);
			String errorNames = BindingResult.MODEL_KEY_PREFIX + MODELNAME;
			redirectAttributes.addFlashAttribute(errorNames, errors);
		} else {
			// int result = calc.getOp1() + calc.getOp2();
			calc.setResult(calc.getOp1() + calc.getOp2());
		}

		return "redirect:/case07/calculate";
	}
}
