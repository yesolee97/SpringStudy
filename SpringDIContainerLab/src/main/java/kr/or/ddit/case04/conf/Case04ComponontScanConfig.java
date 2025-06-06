package kr.or.ddit.case04.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.or.ddit.case04.objs.controller.Case04DummyController;
import kr.or.ddit.case04.objs.mapper.Case04DummyMapper;
import kr.or.ddit.case04.objs.mapper.Case04DummyMapperImpl_Oracle;
import kr.or.ddit.case04.objs.service.Case04DummyService;
import kr.or.ddit.case04.objs.service.Case04ServiceImpl;


/**
 * 어플리케이션의 볼륨이 커지면,
 * 특정 패키지(*)에 있는
 * 일정 조건(*)에 맞는 클래스를 자동으로 빈 등록 할 수 있는 방법이 필요함
 * ↓ 의미를 전달해주기 위해서 어노테이션을 분리해서 작성해줘야함
 * @Component: 특정 레이어가 아닌 일반 객체 등록 ex) validate
 * @Repository: 퍼시스턴스 레이어에 사용
 * @Service: 비즈니스 로직 레이어에 사용
 * @Controller: 컨트롤러 레이어에 사용
 * @Configuration - 설정파일 역할을 하는 클래스에 사용
 * 
 * 빈들간의 의존관계 형성 
 * @AutoWired: 1.타입으로 검색하고 주입 > 2.파라미터명이나 변수명을 리플렉션해서 주입결정
 * @Qualifier("주입할 빈id"): 구체적인 아이디를 기준으로 검색하고 주입!
 * -----------
 * @Inject: @Autowired와 동일
 * @Named("빈id") @Qualifier와 동일
 * @Resource(name을 비롯한 멀티 속성... ): 속성들의 조합으로 주입할 객체를 검색함
 * 
 * ↓ 단순한 값(리터럴) 주입용
 * @Value: 문자열이나 숫자와같은 리터럴을 이용해 주입받을 떄 사용됨
 * 
 *  등록된 빈의 생명주기 콜백 결정
 *  init method:   @PostConstruct (생성자 이후 모든 주입이 완료된 후)
 *  destroy method @PreDestroy (scope에 따라 실행 시점이 다름)
 * 
 */
@Configuration
@ComponentScan(basePackages = "kr.or.ddit.case04.objs", lazyInit = false
	, useDefaultFilters = false,
	includeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = Controller.class)
	}

)
@Lazy
public class Case04ComponontScanConfig {
	// 필요한 모든 객체를 빈으로 등록.
//	
//	@Bean
//	public Case04DummyMapper Case04DummyMapperImpl_Oracle() {
//		Case04DummyMapper mapper = new Case04DummyMapperImpl_Oracle();
//		return mapper;
//	}
//	
//	@Bean(initMethod = "start")
//	public Case04DummyService Case04ServiceImpl(Case04DummyMapper mapper) {
//		Case04DummyService service = new Case04ServiceImpl(mapper);
//		return service;
//	}
//	
//	@Bean(initMethod = "start")
//	public Case04DummyController Case04DummyController(Case04DummyService service) {
//		Case04DummyController controller = new Case04DummyController();
//		controller.setService(service);
//		return controller;
//	}
}
