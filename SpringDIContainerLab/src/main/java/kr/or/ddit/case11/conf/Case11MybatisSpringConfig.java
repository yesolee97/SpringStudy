package kr.or.ddit.case11.conf;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import kr.or.ddit.case10.conf.Case10JdbcConfig;

/**
 *  mybatis와 spring 연동 단계
 *  1. 스프링 컨테이너에 DataSource를 빈으로 등록 ( 빈의 id가 소문자 d로 시작하는 datasource로 등록해야함 !!)
 *  2. SqlSessionFactroyBean을 이용해 SqlSessionFactroy를 빈으로 등록!
 *     --> 1. dataSource 주입
 *     --> 2. Configuration 파일의 위치 (Resource)
 *     --> 3. Mapper 파일의 위치 (Resource...)
 *  3. Mapper의 구현체가 필요한경우 (impl을 통해 쿼리문 사용할 경우), SqlSessionTemplate를 등록
 *  4. MapperSacnner 설정 (구현체를 직접 구현x, 하나의 싱글톤으로 Mapper Proxy를 관리하기 위해서)
 *     --> 1. basePackge : mapper 인터페이스 위치 주입
 *     --> 2. 스캔 대상을 선별할 마커 어노테이션 설정 ex) @Mapperm, @Repository
 */

@ComponentScan(basePackages = "kr.or.ddit.case11")
@Configuration
@Import(Case10JdbcConfig.class)
public class Case11MybatisSpringConfig {
	
	// 	SqlSessionFactory 생성하려고 함 > 팩토리 빈으로 등록하면 반환은 그 안에서 만들어지는 객체로 됌
	//	/WebStudy02_MyBatis/src/main/java/kr/or/ddit/mybatis/CustomSqlSessionFactoryBuilder.java 이거랑 똑같이 만듬
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(
		@Value("classpath:kr/or/ddit/case11/Configuration.xml") Resource configLocation,
		DataSource dataSource,
		@Value("classpath:kr/or/ddit/case11/objs/mapper/**/*.xml") Resource...mapperLocations
	) {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setConfigLocation(configLocation);
		factoryBean.setDataSource(dataSource);
		factoryBean.setMapperLocations(mapperLocations);
		return factoryBean;
	}
	
	
	
//	@Bean
//	// SqlSession을 상속받은 구현체 -스프링과 마이바티스를 연동해서 쓰는 두번째 방법
	// 맵퍼의 구현체를 직접 구현해야 하는 경우에는 이걸 구현해줘야함!!!
//	public SqlSessionTemplate sqlSession(
//		SqlSessionFactory sessionFactory
//	) {
//		SqlSessionTemplate template = new SqlSessionTemplate(sessionFactory);
//		return template;
//	}
	
	
	
	@Bean
	// 매퍼를 한번에 생성해주는 팩토리 빈이 있다. > 얘가 우리한테 필요한 구현체를 자동으로 생성해줌
	public MapperScannerConfigurer mapperScanner() {
		MapperScannerConfigurer scanner = new MapperScannerConfigurer();
		scanner.setBasePackage("kr.or.ddit.case11.objs.mapper");	// @Mapper와 함께 사용
		scanner.setSqlSessionFactoryBeanName("sqlSessionFactory");	// 매퍼 프록시가 자동으로 생성되게 해줄 세션팩토리 객체 넘겨줌
		scanner.setAnnotationClass(Repository.class);	// 이 어노테이션을 사용했을떄만 매퍼 생성되게!
		return scanner;
	}
}
