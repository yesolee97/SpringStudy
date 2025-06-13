package kr.or.ddit.security.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomOidcUserService extends OidcUserService{
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
		OidcUser oidcUser = super.loadUser(userRequest);
		 
		ClientRegistration clientRegistration = userRequest.getClientRegistration();
		
		log.info("oidc Provider : {}", clientRegistration);  
		log.info("oidc : {}", oidcUser);
		log.info("oidc user name : {}", oidcUser.getName());
		log.info("oidc other attribute : {}", oidcUser.getAttributes());
		log.info("oidc authorities : {}", oidcUser.getAuthorities());
		
		log.info("oidc full name : {}", oidcUser.getFullName());
		log.info("oidc nickname : {}", oidcUser.getNickName());
		log.info("oidc email : {}", oidcUser.getEmail());
		log.info("oidc email verified : {}", oidcUser.getEmailVerified());
		log.info("oidc picture : {}", oidcUser.getPicture());
		String userNameAttributeName =  clientRegistration.getProviderDetails().getUserInfoEndpoint()
				.getUserNameAttributeName();
		
		log.info("oidc user name : {}", oidcUser.getAttributes().get(userNameAttributeName));
		
		String username =  oidcUser.getName();
		
 		MemberVO realUser = mapper.selectMemberByMail(oidcUser.getEmail());
 		
		if(realUser==null) {
			// 가입되지 않은 사용자라는 예외 만들어서 던지기
			// (clientRegistration - 어디서 연동해서 로그인 성공했는지에 대한 정보 가지고 있음 / oidcUser - 현재 로그인 되어있는 소셜 로그인 객체가 email 가지고 있음)
			throw new UserNotRegisteredException(oidcUser, clientRegistration);
		}else if(realUser.isMemDelete()) {
			// 이미 탈퇴한 회회원인지 체크!!
			throw new OAuth2AuthenticationException(new OAuth2Error("deleted-user"), "이미 탈퇴한 회원입니다.");
		}
		
		 return new OAuth2MemberVOWrapper(oidcUser, realUser, "dummy");
	}

}