package kr.or.ddit.conf;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.JdbcOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.security.auth.CustomUserDetailsService;
import kr.or.ddit.security.oauth2.CustomOidcUserService;
import kr.or.ddit.security.oauth2.OAuth2AuthenticationFailureHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@Data
@ConfigurationProperties(prefix = "myapp")
public class SpringSecurityConfig {
	private String loginUrl;
	private String logoutUrl;
	private String registerUrl;
	
	@Autowired
	private MemberMapper mapper;
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	/**
	 * 일반 form 로그인 사용자의 정보 조회
	 * @return MemberVOWrapper가 만들어짐
	 */
	@Bean
	public CustomUserDetailsService userDetailService() {
		CustomUserDetailsService service = new CustomUserDetailsService(mapper);
		return service;
	};

	/**
	 * 소셜 로그인 사용자의 정보 조회
	 * @return MemberVOWrapper가 만들어짐
	 */
	@Bean
	public CustomOidcUserService oidUserService() {
		return new CustomOidcUserService(mapper);
	}
	
	/**
	 * 소셜 로그인 실패시,
	 * 미가입자로 인해 실패라면 -> 가입페이지로 리다이렉트
	 * 그냥 인증 실패라면 -> 로그인페이지로 리다이렉트
	 * @return 익셉션 만들어냄
	 */
	@Bean
	public OAuth2AuthenticationFailureHandler failureHandler() {
		OAuth2AuthenticationFailureHandler handler = new OAuth2AuthenticationFailureHandler(registerUrl);
		handler.setDefaultFailureUrl(loginUrl+"?error");
		return handler;
	}
	
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
		// return new InMemoryOAuth2AuthorizedClientService(registrationRepository); // 인메모리로 관리하는 방법
		return new JdbcOAuth2AuthorizedClientService(new JdbcTemplate(dataSource), clientRegistrationRepository);
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	// 폐쇄용이라 화이트리스트 만들어줌 >> 공개용이면 블랙리스트 만들어줌
	private final String[] WHITE_LIST = new String[] {
		"/"
		, "/meeting/**"
		, "/ws/**"
		, "/js/**"
		, "/html/**"
		, "/dist/**"
		, "/error/**"
		, "/swagger-ui/**"
		, "/swagger-ui.html"
		, "/v3/api-docs/**"
		, "/v3/api-docs.yaml"
		, "/oauth2/**"                                           
	};
	
	
//	@Bean
//	// 세션 동시성 제어를 위한 리스너 
	// 서블릿 스펙에서 돌아가는 리스너임 >> 즉, 톰캣이 관리함 >> 톰캣이 관리하는 객체가 하나라도 빈으로 등록되어있으면 스프링 dev 툴즈가 동작을 못함!!
	// 나중에 AWS 쓸때는 주석 풀고 써먹어야 함
//	public HttpSessionEventPublisher sessionEventPublisher() {
//		return new HttpSessionEventPublisher();
//	}
//	
	@Bean
	@Order(2)
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.securityMatcher("/**")
		.csrf(csrf->csrf.disable())	// 방어를 안하겠다는 뜻
		
			// 보호자원 설정
			.authorizeHttpRequests(authroize -> 
				authroize				
					// 패쇄형 사이트용 설정
					.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()	// 모델2애서 이동하는건 보호 xx
					.requestMatchers(WHITE_LIST).permitAll()
					.requestMatchers(loginUrl).permitAll()
					.requestMatchers(registerUrl).permitAll()
					.requestMatchers(new AntPathRequestMatcher("/mypage")).authenticated()
					.requestMatchers(new AntPathRequestMatcher("/member/**")).authenticated()
					.requestMatchers(new AntPathRequestMatcher("/prod/*Insert*")).hasRole("ADMIN")
					.requestMatchers(new AntPathRequestMatcher("/prod/*Update*")).hasRole("ADMIN")
					.requestMatchers(new AntPathRequestMatcher("/buyer/**")).hasRole("ADMIN")
					// 여기서 공개용인지 폐쇄형인지 결정
					.anyRequest().authenticated()	// 위에 설정을 제외한 나머지 /** 이거랑 같아
//					.requestMatchers(new AntPathRequestMatcher("/**")).permitAll()		// 이게 마지막에 설정되어있으면 공개형 사이트임
			)
			.sessionManagement(session->
				session.sessionFixation(fixation->
					fixation.newSession()// 세션 속성 유지 x>> 세션을 스코프로 이용시에는 사용불가
					.maximumSessions(1)// 세션 동시성 제어
					.maxSessionsPreventsLogin(false) // 세션이 최대갯수에 도달했을 때 새로 로그인하는 걸 막을건지 안할건지 이벤트 설저
					.expiredUrl("/login?expired")
				)
			)
			.oauth2Login(oauth2->
				oauth2
					.loginPage(loginUrl)
					.failureHandler(failureHandler())
			)
			.formLogin(login->
				login
					.loginPage(loginUrl)
					.loginProcessingUrl(loginUrl)
					// .failureUrl("/login?error")		// 로그인 실패할때 보여줄 페이지?
					.defaultSuccessUrl("/", false)
			)
			// 로그인후에 크롬이 json 뭐 이상한거 보내는것도 캐싱하는 거 없애려고 설정해줌
			.requestCache(requestCache->
				requestCache.requestCache(requestCache())
			)
			.logout(logout->
				logout
					.logoutUrl(logoutUrl)
			);
		return http.build();
	}
	
	@Bean
	public AntPathMatcher antPathMatcher() {
		return new AntPathMatcher();
	}
	
	@Bean
	public RequestCache requestCache() {
		HttpSessionRequestCache cache = new HttpSessionRequestCache() {
			// 익명객체 생성
			@Override
			public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
				if(!antPathMatcher().match("/.well-known/**", request.getRequestURI())) {
					super.saveRequest(request, response);
				}
			}
		};
		return cache;
	}
}