package kr.or.ddit.case02.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import kr.or.ddit.case02.objs.dao.Case02DAO;
import kr.or.ddit.case02.objs.service.Case02Service;
import lombok.experimental.Wither;

//@Configuration
public class Case02DependencyInjectionConfig {
	@Bean
	public StringBuffer optionBuffer() {
		return new StringBuffer();
	}
		
	@Bean
	public Case02DAO dao1() {
		return new Case02DAO();
	}
	@Bean
	public Case02DAO dao2() {
		return new Case02DAO();
	}
	
	@Bean
	// 갖고 있는 빈들중에서 넣어준 파라미터와 동일한 빈이 있는 지 검색하고 있다면 넣어줌
	// 이때, 파라미터로 넘기는 값이 검색조건이 된다. (유일한 식별자 역할을 할 수 있게 pom.xml 설정해줘야함!!)
	public Case02Service service(Case02DAO dao1, StringBuffer optionBuffer) {	
		Case02Service service = new Case02Service(dao1);
		service.setOption(optionBuffer);
		return service;
	}
}
