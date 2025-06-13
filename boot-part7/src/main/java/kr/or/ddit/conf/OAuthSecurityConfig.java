package kr.or.ddit.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.JdbcOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

import kr.or.ddit.security.oauth2.OAuth2AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class OAuthSecurityConfig {
	@Autowired
	private DataSource dataSource;

	// spring boot 로 자동 등록되어있는 객체 주입.
	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;


	/**
	 * 제 3자 > 구글로부터 인가되어 있는 앱의 위임장을 DB에 넣어서 저장하기 위한 메서드
	 * access token 과 refresh token 을 발급받은 OAuth2AuthorizedClient 객체를 관리하는 객체
	 * memory 나 database 기반으로 토큰 정보를 관리할 수 있음.
	 * spring boot starter 를 사용하는 경우 memory 기반의 관리 객체가 자동 등록됨.
	 * DB 기반으로 관리할 경우, 스키마 필요( classpath:org/springframework/security/oauth2/client/oauth2-client-schema.sql )
	 * @param registrationRepository
	 * @return
	 */
	@Bean
	public OAuth2AuthorizedClientService authorizedClientService() {
		// return new InMemoryOAuth2AuthorizedClientService(registrationRepository);
		return new JdbcOAuth2AuthorizedClientService(new JdbcTemplate(dataSource), clientRegistrationRepository);
	}
	
	//예외 발생시 가입 페이지로 이동시킬 핸들러 빈으로 등록
	@Bean
	public OAuth2AuthenticationFailureHandler failureHandler() {
		// 실패시 이동할 회원가입 페이지 정보 ()에 넘겨줌
		OAuth2AuthenticationFailureHandler handler = new OAuth2AuthenticationFailureHandler("/member/memberInsert.do");
		return handler;
	}
	
	
	// 페이지 접근 권한 설정을 위해 필터 체인 구조가 필요함 ~!!
	@Bean
	public SecurityFilterChain SecurityFilterChain (HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize->
			authorize
				.requestMatchers("/**").permitAll()
		)
		.oauth2Login(oauth2->
			// 위에서 등록한 빈으로 등록한 failureHandler를 여기서 써먹음
			oauth2.failureHandler(failureHandler())
		);
		return http.build();
	}
	
	
}
