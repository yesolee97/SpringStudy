package kr.or.ddit.member.service;

import org.springframework.beans.factory.annotation.Autowired;
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

}
