package kr.or.ddit.conf;

import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import kr.or.ddit.filter.DummyFilter;


@Configuration
public class SiteMeshFilterConfig {
	
	@Bean
	FilterRegistrationBean<ConfigurableSiteMeshFilter> siteMeshFilter(){
		FilterRegistrationBean<ConfigurableSiteMeshFilter> filter = new FilterRegistrationBean<>();
		// 실제 필터 생성 // 필터 꺼내서 넘겨준뎅
		filter.setFilter(
			ConfigurableSiteMeshFilter.create((builder)->
				builder.setDecoratorPrefix("/WEB-INF/decorators/")
						.addExcludedPath("/ajax/**")
						.addExcludedPath("/rest/**")
						.addExcludedPath("*.html")	// 모든 html 파일 데코레이터 제외
						.addDecoratorPath("/login", "simpleDecorator.jsp")	// 어떤 데코레이터 사용할건지 알려줌
						.addDecoratorPath("/**", "mantisDecorator.jsp")	// 어떤 데코레이터 사용할건지 알려줌
				)
		);
		// 우선순위 결정
		filter.setOrder(Ordered.LOWEST_PRECEDENCE-100);	// 순서 정해줌 (낮은 숫자로 설정 x - 스프링이 이미 필터 많이 등록해놨음) >> 우선순위 디테일하게 정하지 않고 상수 사용해서 10단위로 건너뜀 
		// 핉처 매핑 설정
		filter.addUrlPatterns("/*");					// 필터 매핑해줌
		
		return filter;
	}
}
