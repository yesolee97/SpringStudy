package kr.or.ddit.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kr.or.ddit.security.auth.handler.CustomAuthenticationSuccessHandler;

@Configuration
//시큐리티는 필터 체인을 기반으로 동작 > 최대 16 개가 돌아가는데 이 어노테이션 하나로 싹 다 등록함
@EnableWebSecurity  
public class SpringSecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public CustomAuthenticationSuccessHandler seccessHandler() {
		CustomAuthenticationSuccessHandler handler = new CustomAuthenticationSuccessHandler();
		handler.setDefaultTargetUrl("/");
		handler.setAlwaysUseDefaultTargetUrl(false);
		return handler;
	}
	// SecurityFilterChain로 필터 커스터마이징
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf(Customizer.withDefaults())
		.authorizeHttpRequests(authorize->
		authorize	// 접근 제어 설정
			// 필터 체인은 동작 순서가 중요함, 접근 제어 시 포괄적인게 뒤로 밀려야함
			.requestMatchers(new AntPathRequestMatcher("/lprod/**")).hasRole("ADMIN")
			.requestMatchers("/**").permitAll()
		)
		// 로그인폼은 withDefaults() 기본 설정을 따르겠다
		.formLogin(login->
			login
				.loginPage("/login")
				.usernameParameter("memId")
				.passwordParameter("memPassword")
				.loginProcessingUrl("/login")
				// .defaultSuccessUrl("/", false)	// false, true 여부에 따라 캐싱기능 on/off, successHandler랑 같이 사용 못함 (같은 인터페이스를 사용해서 만든 구현체여서 둘이 같이 사용 못함)
				.failureUrl("/login?error")
				.successHandler(seccessHandler())
		)
		.logout(logout->
			logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
		);
		return http.build();
	}
}
