package kr.or.ddit.case09.conf;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import kr.or.ddit.case09.objs.DBInfoVO;

/**
 * DBInfo.properties 파일을 읽고,
 * 프로퍼티들의 값을 DBInfoVO로 복사
 * 1. place holder와 property Source(빈으로 등록 x)의 활용 : Bean이 등록되지 않음으로 EL 사용불가
 * 2. spEL 과 Properties 객체의 활용 = 빈으로 등록되야지 사용할 수 있음
 */

@PropertySource("classpath:kr/or/ddit/db/DBInfo.properties")	// 프로퍼티 파일 읽기
@Configuration
public class Case09ReadPropertisConfig {
	
	
	@Bean
	public FactoryBean<String[]> array(){
		return new FactoryBean<String[]>() {
			
			@Override
			public Class<?> getObjectType() {
				return String[].class;
			}
			
			@Override
			public String[] getObject() throws Exception {
				return new String[] {"value1", "value2"};
			}
		};
	}
	
	/**
	 * FactoryBean의 빈 등록 구조
	 * FactoryBean이 팩토리 메소드의 반환 타입으로 선언되었더라도,
	 * 실제 등록되는 객체는 factory에서 생성되는 객체(getObject의 리턴객체)가 빈으로 등록됨
	 * @param location
	 * @return
	 * @throws IOException
	 */
	@Bean("infoProps")
	public PropertiesFactoryBean dbInfoProp(
		@Value("classpath:kr/or/ddit/db/DBInfo.properties") Resource location	// 컨테이너한테 프로퍼티스 정보 value로 받음
	) throws IOException {
		PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
		factoryBean.setLocation(location);
		return factoryBean;
		// factoryBean.afterPropertiesSet();
		// return factoryBean.getObject();
	}
	
	@Bean
	public DBInfoVO dbInfo2(
		@Value("#{infoProps['maindb.driverClassName']}") String driverClassName,
		@Value("#{infoProps['maindb.url']}") String url,
		@Value("#{infoProps['maindb.username']}") String username,
		@Value("#{infoProps['maindb.password']}") String password,
		@Value("#{infoProps['maindb.autoCommit']}") boolean autoCommit,
		@Value("#{infoProps['maindb.minimumIdle']}") int minimumIdle,
		@Value("#{infoProps['maindb.maximumPoolSize'] }") int maximumPoolSize,
		@Value("#{infoProps['maindb.connectionTimeout']}") long connectionTimeout
	) {
		return DBInfoVO.builder()
				.driverClassName(driverClassName)
				.url(url)
				.username(username)
				.password(password)
				.autoCommit(autoCommit)
				.minimumIdle(minimumIdle)
				.maximumPoolSize(maximumPoolSize)
				.connectionTimeout(connectionTimeout)
				.build();
	}
	
//	@Bean
//	public DBInfoVO dbInfo1(
//		@Value("${maindb.driverClassName}") String driverClassName,
//		@Value("${maindb.url}") String url,
//		@Value("${maindb.username}") String username,
//		@Value("${maindb.password}") String password,
//		@Value("${maindb.autoCommit}") boolean autoCommit,
//		@Value("${maindb.minimumIdle}") int minimumIdle,
//		@Value("${maindb.maximumPoolSize}") int maximumPoolSize,
//		@Value("${maindb.connectionTimeout}") long connectionTimeout
//	) {
//		return DBInfoVO.builder()
//				.driverClassName(driverClassName)
//				.url(url)
//				.username(username)
//				.password(password)
//				.autoCommit(autoCommit)
//				.minimumIdle(minimumIdle)
//				.maximumPoolSize(maximumPoolSize)
//				.connectionTimeout(connectionTimeout)
//				.build();
//	}
}
