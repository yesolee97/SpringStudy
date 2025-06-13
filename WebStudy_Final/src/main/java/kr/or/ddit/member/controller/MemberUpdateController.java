package kr.or.ddit.member.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.validate.updateGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member/memberUpdate.do")
@RequiredArgsConstructor
public class MemberUpdateController {
	private static final String MODELNAME = "member";
	private final MemberService service;
	
//	@ModelAttribute(MODELNAME)
//	public MemberVO member() {
//		MemberVO member = null;
//		if (member == null) {
//			return new MemberVO();			
//		} else {
//			return member;
//		}
//	}

	
	@GetMapping
	public String formUI(
		Authentication authentication 
		, Model model
	) {
		String userName = authentication.getName();
		// member 가 없을 경우 if 문탐, 있으면 건너뛰고 이전데이터 가지고 jsp로 감
		if(!model.containsAttribute(MODELNAME)) {
			MemberVO member = service.readMember(userName);
			model.addAttribute(MODELNAME, member);			
		}
		
		return "member/memberEdit";
	}
	
	@PostMapping
	public String formEdit(
		@Validated(updateGroup.class) @ModelAttribute(MODELNAME) MemberVO member
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) {
		String lvn;
		// 검증 통과
		if(!errors.hasErrors()) {
			// 수정 성공 후? mypage로 이동?
			try {
				service.modifyMember(member);
				lvn = "redirect:/mypage";
			} catch (AuthenticationException e) {
				// 인증 실패? - 수정양식으로 redirect, 비번오류 메세지, 기존 입력 데이터
				redirectAttributes.addFlashAttribute(MODELNAME, member);
				redirectAttributes.addFlashAttribute("message", "비밀번호 오류!");				
				lvn = "redirect:/member/memberUpdate.do";
			}
		} else {
			// 검증 실패 시 - 수정양식으로 redirect, 검증 에러 메세지, 기존 입력 데이터
			redirectAttributes.addFlashAttribute(MODELNAME, member);
			String errorName = BindingResult.MODEL_KEY_PREFIX + MODELNAME;
			redirectAttributes.addFlashAttribute(errorName, errors);
			lvn = "redirect:/member/memberUpdate.do";
		}
		return lvn;
	}
}
