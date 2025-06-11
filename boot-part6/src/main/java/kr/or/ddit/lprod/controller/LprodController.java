package kr.or.ddit.lprod.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.security.auth.MemberVOWrapper;
import kr.or.ddit.vo.LprodVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/lprod")
public class LprodController {
	@Autowired
	private LprodService service;
	
	@GetMapping
	public String list(
		Model model
		, Authentication authentication
		, @AuthenticationPrincipal MemberVOWrapper pricipal	// authentication.getPrincipal()를 꺼내서 넣어달라는 어느테이션임
		, @AuthenticationPrincipal(expression = "realUser") MemberVO realUser
	) {
		// MemberVOWrapper pricipal = (MemberVOWrapper)authentication.getPrincipal();
		// MemberVO realUser =  pricipal.getRealUser();
		log.info("인증된 사용자 누구?? : {}", realUser);
		
		WebAuthenticationDetails details = (WebAuthenticationDetails)authentication.getDetails();
		log.info("web details?? ip + session 들어있음 : {}", details);
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		log.info("authorities?? ROLE 들어있음 : {}", authorities);
		
		List<LprodVO> lprodList = service.readLprodList();
		model.addAttribute("lprodList", lprodList);
		return "lprod/lprodList";
	}	
}
