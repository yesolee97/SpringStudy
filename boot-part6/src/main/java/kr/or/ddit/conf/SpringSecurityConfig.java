package kr.or.ddit.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//시큐리티는 필터 체인을 기반으로 동작 > 최대 16 개가 돌아가는데 이 어노테이션 하나로 싹 다 등록함
@EnableWebSecurity  
public class SpringSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize->
		authorize
			// 필터 체인은 동작 순서가 중요함, 접근 제어 시 포괄적인게 뒤로 밀려야함
			.requestMatchers("/lprod/**").authenticated()
			.requestMatchers("/**").permitAll()
		)
		// 로그인폼은 withDefaults() 기본 설정을 따르겠다
		.formLogin(Customizer.withDefaults());
		return http.build();
	}
}
