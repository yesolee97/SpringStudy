package kr.or.ddit.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Configuration
public class MapperContextConfig {
	
	
	public MapperContextConfig() {
		log.info("------------------------- test");
	}

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	
	@Bean
	// 매퍼를 한번에 생성해주는 팩토리 빈이 있다. > 얘가 우리한테 필요한 구현체를 자동으로 생성해줌
	public MapperScannerConfigurer mapperScanner() {
		MapperScannerConfigurer scanner = new MapperScannerConfigurer();
		scanner.setBasePackage("kr.or.ddit.**.mapper");	// @Mapper와 함께 사용
		// scanner.setSqlSessionFactoryBeanName("sqlSessionFactory");	// 매퍼 프록시가 자동으로 생성되게 해줄 세션팩토리 객체 넘겨줌
		scanner.setSqlSessionFactory(sqlSessionFactory);
		scanner.setAnnotationClass(Repository.class);	// 이 어노테이션을 사용했을떄만 매퍼 생성되게!
		return scanner;
	}
	
	@PostConstruct
	public void init() {
		log.info("sqlSessionFactory : {}", sqlSessionFactory);
	}
}
