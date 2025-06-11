package kr.or.ddit.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import kr.or.ddit.common.exception.PKDuplicatedException;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.validate.insertGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member/memberInsert.do")
@RequiredArgsConstructor
public class MemberInsertController {
	private final MemberService service;
	private static final String MODELNAME = "member";
	
	@ModelAttribute(MODELNAME)
	public MemberVO member() {
		return new MemberVO();
	}
	
	@GetMapping
	public String getForm() {
		return "member/memberForm";
	}
	
	@PostMapping
	public String register(
		@Valid @ModelAttribute(MODELNAME) MemberVO member
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) {
		String lvn;
		// if에 걸리면 검증 통과
		if(!errors.hasErrors()) {
			try {
				service.createMember(member);
				lvn = "redirect:/";
			} catch (PKDuplicatedException e) {
				// 여기 걸리면 id 중복임
				redirectAttributes.addFlashAttribute(MODELNAME, member);
				redirectAttributes.addFlashAttribute("message", "아이디 중복");
				
				lvn = "redirect:/member/memberInsert.do";
			}	
		} else {
			redirectAttributes.addFlashAttribute(MODELNAME, member);
			String errorName = BindingResult.MODEL_KEY_PREFIX + MODELNAME;
			redirectAttributes.addFlashAttribute(errorName, errors);
			lvn = "redirect:/member/memberInsert.do";
		}
		return lvn;
	}
}
