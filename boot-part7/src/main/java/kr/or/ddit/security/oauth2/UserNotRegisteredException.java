package kr.or.ddit.security.oauth2;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

// 3) 가입하지 않은 사용자를 표현할 예외 정의
public class UserNotRegisteredException extends OAuth2AuthenticationException {
	public static final String NOT_REGISTERED_CODE = "register-required";
	
	private final OidcUser unRegisteredUser;
	private final ClientRegistration clientRegistration;
	
	// 생성자 - CustomOidcUserService에서 넘긴 정보를 받음
	public UserNotRegisteredException(OidcUser unRegisteredUser, ClientRegistration clientRegistration) {
		super(NOT_REGISTERED_CODE);
		this.unRegisteredUser = unRegisteredUser;
		this.clientRegistration = clientRegistration;
	}
	
	public OidcUser getUnRegisteredUser() {
		return unRegisteredUser;
	}
	
	public ClientRegistration getClientRegistration() {
		return clientRegistration;
	}
	
}