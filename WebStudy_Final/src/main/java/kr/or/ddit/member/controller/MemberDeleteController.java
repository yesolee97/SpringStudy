package kr.or.ddit.member.controller;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberDeleteController {
	private final MemberService service;
	private final OAuth2AuthorizedClientService authorizedClientService;
	
	// 회원 탈퇴하면 로그아웃 시켜줘야함 >> 그럼 세션에서 삭제시켜줘야함
	// 사용자는 탈퇴할 떄 비밀번호를 입력해줌, 로그인되어이으니까 username은 거기서 꺼내면 됨 !! 그래서 포스트맵핑임
	@PostMapping("/member/memberDelete.do")
	public String deleteMember( 
		Authentication authentication
		, @AuthenticationPrincipal(expression = "realUser") MemberVO realUser
		, @RequestParam(name = "memPassword") String memPassword
		, HttpSession session
		, RedirectAttributes redirectAttributes
	) {
			try {
				String userName = realUser.getMemId();
				
				log.info("userName -----> {}", userName);
				log.info("memPassword -----> {}", memPassword);
				service.removeMember(userName, memPassword);
				
				// 소셜로그인으로 로그인한건지 검사 하는 if문
				// authentication얘가 상위객체임, instanceof를 통해 OAuth2AuthenticationToken가 authentication에 속한 구현체인지 확인
				if(authentication instanceof OAuth2AuthenticationToken) {
					// 다운캐스팅 하는 거
					OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken)authentication;
					// 구글이라는 정보를 가지고 있데
					String clientRegistrationId = authToken.getAuthorizedClientRegistrationId();
					authorizedClientService.removeAuthorizedClient(clientRegistrationId, userName);
				}
				SecurityContextHolder.clearContext();	// 싹 비우는 작업이래
				
				
				session.invalidate();	
				return "redirect:/";
			} catch (AuthenticationException e) {
				redirectAttributes.addFlashAttribute("message", "패스워드 틀림");
				return "redirect:/mypage";
			}
		}
		
	}
