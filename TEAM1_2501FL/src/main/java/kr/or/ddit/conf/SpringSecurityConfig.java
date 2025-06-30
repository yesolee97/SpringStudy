package kr.or.ddit.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.util.AntPathMatcher;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
	
	
	// 폐쇄용이라 화이트리스트 만들어줌 >> 공개용이면 블랙리스트 만들어줌
	private final String[] WHITE_LIST = new String[] {
		"/"
		, "/meeting/**"
		, "/ws/**"
		, "/board/**"
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
					// 여기서 공개용인지 폐쇄형인지 결정
					.anyRequest().permitAll()	// 위에 설정을 제외한 나머지 /** 이거랑 같아
//					.requestMatchers(new AntPathRequestMatcher("/**")).permitAll()		// 이게 마지막에 설정되어있으면 공개형 사이트임
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
