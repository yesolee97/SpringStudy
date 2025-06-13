package kr.or.ddit.conf;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "cors")
@Configuration
public class RestSpringSecurityConfig {	
	private List<String> allowedOrigins;
	private List<String> allowedMethods;
	private List<String> allowedHeaders;
	private boolean allowCredentials;
	
	// restSecurityFilterChain 여기에 넣어줄거임 
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(allowedOrigins);
		corsConfig.setAllowedMethods(allowedMethods);
		corsConfig.setAllowedHeaders(allowedHeaders);
		// 인증시스템을 가지고 있다면 그 인증과 관련된 헤더를 받겠다는 설정
		corsConfig.setAllowCredentials(allowCredentials);
		
		UrlBasedCorsConfigurationSource corsConfigSource = new UrlBasedCorsConfigurationSource();
		corsConfigSource.registerCorsConfiguration("/rest/**", corsConfig);
		return corsConfigSource;
	}
	
	// 얘는 securityMatcher에 설정된 /rest/**로 들어오는 요청에 대한 필터링임
	@Bean
	@Order(1)	// 같은 타입의 빈이 여러개있으면 내가 제일 먼저 동작할거야
	public SecurityFilterChain restSecurityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf->csrf.disable())
			.securityMatcher("/rest/**")
			.cors(cors->
				cors.configurationSource(corsConfigurationSource())
			)
			.authorizeHttpRequests(authorize->
				authorize
					.requestMatchers("/rest/auth").permitAll()
					// 모든 요청에 대해서 인증된 사람만 접근할 수 있게 허용
					.anyRequest().authenticated()
			)
			.sessionManagement(session->
				session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			)
			// 헤더기반 인증, 세션 필요 xx
			.httpBasic(Customizer.withDefaults());		
		return http.build();
	}
}
