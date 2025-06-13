package kr.or.ddit.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.exception.PKDuplicatedException;
import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private final AuthenticationManager authenticationManager;
	
	@Override
	public MemberVO readMember(String username) {
		return mapper.selectMember(username);
	}

	@Override
	public void createMember(MemberVO member) {
		// 중복 조회, 사용자가 보낸 id가 db에 없는 값이어야 inser 진행
		if(mapper.selectMember(member.getMemId())==null) {
			String encdPw = passwordEncoder.encode(member.getMemPassword());
			member.setMemPassword(encdPw);
			mapper.insertMember(member);
		} else {
			throw new PKDuplicatedException(member.getMemId()); 
		}
	}

	@Override
	public void removeMember(String username, String password) {// username, password를 가지고 토큰으로 만들어줌 >> 시큐리티가 토큰으로 인증을 처리하기 때문에 이걸 만들어줘야함
		UsernamePasswordAuthenticationToken inputData = UsernamePasswordAuthenticationToken.unauthenticated(username, password);
		authenticationManager.authenticate(inputData);
		
		// 여기까지 왔으면 인증 성공이니까 mapper 실행
		mapper.updateMemDelete(username);
	}

	
	
	@Override
	public void modifyMember(MemberVO member) {
		 // 수정할때도 인증 한번 해줘야함
		UsernamePasswordAuthenticationToken inputData = UsernamePasswordAuthenticationToken.unauthenticated(member.getMemId(), member.getMemPassword());
		authenticationManager.authenticate(inputData);
		mapper.updateMember(member);
		
		
		// 기존 인증객체 변경 - 어센티케이션
		changeAuthentication(member);
	}

	
	// 시큐리티는 인증객체를 바로 관리하지 않음 - contextHolder에 들어있음
	// 모르겠음
	private void changeAuthentication(MemberVO member) {
		UsernamePasswordAuthenticationToken inputData = UsernamePasswordAuthenticationToken.unauthenticated(member.getMemId(), member.getMemPassword());
		
		SecurityContext context = SecurityContextHolder.getContext();
		UsernamePasswordAuthenticationToken before = (UsernamePasswordAuthenticationToken)context.getAuthentication();
		Object details = before.getDetails();
		
		UsernamePasswordAuthenticationToken newAuthentication = (UsernamePasswordAuthenticationToken)authenticationManager.authenticate(inputData);
		newAuthentication.setDetails(details);
		context.setAuthentication(newAuthentication);
	}

}
