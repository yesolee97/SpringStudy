package kr.or.ddit.member.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyPageController {
	private final MemberService service;
	
	
	@GetMapping("/mypage")
	public String getMyPage(
		// 핸들러 어댑터는 현재 동작하고 있는 어플리케이션에서 프린시펄이 있으면 그걸 꺼내, 근데 그걸 구체적인 타입으로 받고싶으면 알아서 캐스팅 해준데
		Authentication principal
		, Model model
	) {
		String userName = principal.getName();	// 이게 모야 pk 꺼내오는건가?
		MemberVO member = service.readMember(userName);
		model.addAttribute("member", member);
		return "member/mypage";
	}
	
	
	
}
