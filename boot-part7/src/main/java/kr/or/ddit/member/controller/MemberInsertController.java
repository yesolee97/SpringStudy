package kr.or.ddit.member.controller;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.ddit.security.oauth2.UserNotRegisteredException;
import kr.or.ddit.vo.MemberVO;

@Controller
@RequestMapping("/member/memberInsert.do")
public class MemberInsertController {
	private static final String MODELNAME = "member";
	
	// formUI에서 가지고 가는 model은 어차피 여기서 만들어진 걸 가지고 가는거기 때문에 로직을 여기서 처리해줌
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
			String mail = unRegisteredUser.getEmail();
			// 가입 시에 
			member.setMemMail(mail);
		}
		// 어디서 소셜 로그인 하려고 했는 지 가지고 있음 >> 구글이야 ~~!
		lastException.getClientRegistration();
		
		return member;
	}
	
	@GetMapping
	public String formUI(
	) {
		return "member/memberForm";
	}
}
