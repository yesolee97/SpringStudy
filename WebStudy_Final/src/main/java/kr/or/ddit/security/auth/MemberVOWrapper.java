package kr.or.ddit.security.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import kr.or.ddit.vo.MemberVO;

public class MemberVOWrapper implements RealUserWrapper<MemberVO>, UserDetails{
	private final MemberVO realUser;
	// realUser를 받는 생성자
	public MemberVOWrapper(MemberVO realUser) {
		super();
		this.realUser = realUser;
	}

	@Override
	public MemberVO getRealUser() {
		return realUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return AuthorityUtils.createAuthorityList(realUser.getMemRole());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return realUser.getMemPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return realUser.getMemId();
	}

}
