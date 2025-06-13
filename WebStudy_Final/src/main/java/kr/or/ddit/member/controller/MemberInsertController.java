package kr.or.ddit.member.controller;

import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import kr.or.ddit.common.exception.PKDuplicatedException;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.security.oauth2.UserNotRegisteredException;
import kr.or.ddit.validate.insertGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("${myapp.register-url}")
@RequiredArgsConstructor
public class MemberInsertController {
	private final MemberService service;
	private static final String MODELNAME = "member";
	
	@ModelAttribute(MODELNAME)
	public MemberVO member(
		// 예외 발생해서 왔을때만 익셉션 잡고, required false로 해줘서 그냥 가입하러 온사람은 없을떄 에러 안나게 해줌
		// oidcUser + 구글이야가 들어있데 
		@SessionAttribute(name=WebAttributes.AUTHENTICATION_EXCEPTION, required = false) UserNotRegisteredException lastException
	) {
		MemberVO member = new MemberVO();
		
		// 예외가 있을 때만 이 로직 처리 >> 즉, 소셜 로그인 하려고 했는데 아직 가입이 안되있어서 실패한 사람만 이메일 꺼내서 vo에 넣어줌!
		if(lastException!=null) {
			// 얘가 뭐야??
			OidcUser unRegisteredUser = lastException.getUnRegisteredUser();
			String oidcName =unRegisteredUser.getName();	// 프린시펄의 name, 즉 
			String mail = unRegisteredUser.getEmail();
			// 가입 시에 
			member.setMemMail(mail);
			member.setMemId(oidcName);
		}
		// 어디서 소셜 로그인 하려고 했는 지 가지고 있음 >> 구글이야 ~~!
		// lastException.getClientRegistration();
		
		return member;
	}
	
	@GetMapping
	public String getForm() {
		return "member/memberForm";
	}
	
	@PostMapping
	public String register(
		@SessionAttribute(value=WebAttributes.AUTHENTICATION_EXCEPTION, required=false) UserNotRegisteredException exception
		, @Valid @ModelAttribute(MODELNAME) MemberVO member
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) {
		String lvn;
		// if에 걸리면 검증 통과
		if(!errors.hasErrors()) {
			try {
				service.createMember(member);
				lvn = "redirect:/";
//				if(exception != null) {
//					// 소셜 로그인의 정보 - getClientRegistration
//					String registrationId = exception.getClientRegistration().getClientId();
//					lvn = "redirect:" + OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI + "/" + registrationId;
//				}
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
