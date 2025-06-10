package kr.or.ddit.conf;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.or.ddit.filter.auth.GeneratePrincipalFilter;

@Configuration
public class SpringSecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
	// 이 안에 들어있는 필터를 꺼내서 필터체인에 등록해줌
	@Bean
	public FilterRegistrationBean<GeneratePrincipalFilter> principalFilter(){
		FilterRegistrationBean<GeneratePrincipalFilter> filter = new FilterRegistrationBean<>();
		// 실제 필요한 필터 넣어줘야함
		filter.setFilter(new GeneratePrincipalFilter());
		filter.addUrlPatterns("/*");
		filter.setOrder(100);		// 순서 정해주기
		return filter;
	}
	
}
