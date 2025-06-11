package kr.or.ddit.security.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
/**
 * spring Security 프레임 워크에서는, 한사람의 사용자에 대한 표현으로 UserDetails를 사용함.
 * UserDetails(implements) => User(extends)
 * 
 * UserDetailsService: 사용자 정보 조회 (인증 위해서 비밀번호 비교 필요함, 이때 조회해서 가져와야함)
 */

import kr.or.ddit.vo.MemberVO;
import lombok.ToString;

@ToString(callSuper = true)
public class MemberVOWrapper extends User {
	private final MemberVO realUser;
	
	// 부모 생성자에 맞춰서 wrapper 만들어줌 ( 근데이제 리얼유저에서 싹다 꺼내서 넣어줌)
	public MemberVOWrapper(MemberVO realUser) {
		super(realUser.getMemId(), realUser.getMemPassword(), AuthorityUtils.createAuthorityList(realUser.getMemRole()));
		this.realUser = realUser;
	}
	
	public MemberVO getRealUser() {
		return realUser;
	}
	

}
