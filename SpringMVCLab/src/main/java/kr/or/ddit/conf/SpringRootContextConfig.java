package kr.or.ddit.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

/**
 * 1. DataSource 생성
 * 2. Mybatis 연동 설정
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = "kr.or.ddit")
public class SpringRootContextConfig {
	@PostConstruct
	public void init() {
		log.info("상위 컨테이너 생성");
	}
}
