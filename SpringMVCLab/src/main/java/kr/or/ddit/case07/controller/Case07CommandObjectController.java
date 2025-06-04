package kr.or.ddit.case07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import kr.or.ddit.case07.vo.DummyVO;
import kr.or.ddit.validate.insertGroup;
import kr.or.ddit.validate.updateGroup;
import lombok.extern.slf4j.Slf4j;

/**
 * command object를 이용한 form data 바인딩
 * 1. form UI 구성
 * 	1) controller 구현
 * 		- GetMapping 핸들러 메소드 구현
 * 		- Model attribute를 전달해야 함.
 * 		  > Model, ModelAndView, @ModelAttribute 중 어노테이션을 메소드 단위에 구현하고, 모델 객체를 생성 및 반환
 * 	2) view 구현
 * 		- form 커스텀 태그 사용 (반드시 써야 하는 속성: modelattribute)
 * 
 * 2. farm data 처리 (핸들러 메소드 구현)
 * 	1) PostMapping 핸들러 메소드
 * 		- 핸들러 메소드 이규먼트로 커맨드 오브젝트 사용. : 동시에 모델 속성으로도 저장됨 (CoC 반영) (폼데이터 확보 과정)
 * 		  @ModelAttribute 로 속성명 변경 가능
 * 		- 커멘드 오브젝트에 대한 검증
 * 		  @Vaild, @Validated(group hint) 와, Errors(BindingResult) 인터페이스 활용
 * 		  ex) handlerMethod(@Valid CommandObject co, BindingResult errors)
 * 			주의 !!! 
 * 			- 검증 결과는 검증 대상인 커맨드 오브젝트 바로 다음 인자로 받아야함! ex) DummyVO vo, BindingResult errors, Model model 순으로
 * 		- 검증 실패 시 form UI로 이동 (redirect)
 * 		  1. 커맨드 오브젝트와 2. 검증 결과(errors)를 모델 속성으로 저장해야 함.
 * 			주의 ! >> 검증 결과를 모델로 전달할때 사용할 모델 명은 BindingResult.MODEL_KEY_PREFIX + "커맨드 오브젝트의 모델명"
 */

@Slf4j
@Controller
@RequestMapping("/case07")
public class Case07CommandObjectController {
	
	// 이렇게 선언하면 얘는 언제나 핸들러보다 먼저 실행됨. 
	// 항상 빈 dummy가 먼저 만들어짐, 같은 이름으로 만들어진 플래쉬 어트리뷰트에 dummy 가 있을 경우,
	// 이 작업을 건너뜀, (즉, dummyVO안에 있던 에러가 날아가지 않음)
	@ModelAttribute("dummy")
	public DummyVO dummy() {
		log.info("dummy 메소드 실행 및 'dummy' 속성 생성");
		return new DummyVO();
	}
	
	
	@GetMapping("dummyForm")
	public String formUI() {
//		DummyVO dummy = new DummyVO();
//		model.addAttribute("dummy", dummy);
		log.info("dummy 메소드 실행 및 'dummy' 핸들러 메소드 실행");
		return "case07/form";
	}
	
	
	
	@RequestMapping("commandObject01")
	// 문자로 전달된 name(필수), 숫자로 전달된 age(옵셔널), 문자들로 전달된 hobbys(옵셔널)
	public String handler01(
			@ModelAttribute("dummy") DummyVO dummy
			, Model model
	) {
		// model.addAttribute("dummy", dummy);// 이름 바꾸려고 굳이 모델로 받아서 ADD 해주는 거임 이렇게 안하면 COC로 dummyVO로 알아서 전달함, 근데 이렇게 전달하면 coc1개, add한 어트리뷰트 한개 총 2개가 전달됌
		log.info("dummy vo : {}", dummy);
		return "case07/view01";
	}
	

	@RequestMapping("commandObject02")
	public String handler02(
		// 너는 VO안에 값을 다 바인딩해줘야해, 근데 검증도 해줘야햄!
		// Vaild 어노테이션만 붙이면 그 구현체가 있는 지 알아서 찾아서 세팅해줌
		@Validated(insertGroup.class) @ModelAttribute("dummy") DummyVO dummy
		, BindingResult errors	// @Valid 검증 결과 여기에서 받음 
		, RedirectAttributes redirectAttributes
	) {
		if(errors.hasErrors()) {
			redirectAttributes.addFlashAttribute("dummy", dummy);
			String errorsName = BindingResult.MODEL_KEY_PREFIX + "dummy";	// 커스텀태그가 이해할 수 있는 에러 key 이름으로 전달하기 위함
			redirectAttributes.addFlashAttribute(errorsName, errors);
			log.error("검증 실패, {}", errors);
			errors.getAllErrors().forEach(oe->{
				log.error("{}", oe);
			});			
			// 검증에 실패했을 떄 다시 form으로 돌려보내기 위한 코드
			return "redirect:/case07/dummyForm";
		} else {
			log.info("dummy vo : {}", dummy);
			return "case07/view01";			
		}
	}
	
}
