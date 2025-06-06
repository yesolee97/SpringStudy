package kr.or.ddit.case03.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import kr.or.ddit.case03.objs.EagerDummy;
import kr.or.ddit.case03.objs.EagerSingletonDummy;
import kr.or.ddit.case03.objs.LazyDummy;
import kr.or.ddit.case03.objs.LazyPrototypeDummy;
import lombok.extern.slf4j.Slf4j;

/**
 * (스프링) 컨테이너의 빈 관리 특성
 * 1. 싱글턴 scope를 기본으로 사용함.
 * 	: 싱글턴 스코프의 대상을 등록된 빈을 기준으로 측정함. > 즉, 같은 메소드를 몇번 주입받던 하나로 퉁침
 * 		@Scope 어노테이션으로 기본 설정을 변경할 수 있음,
 *  		singleton(기본설정): 미리 객체를 생성하고, 주입할 때마다 동일한 객체가 주입됨 > 주입되는애가 다 똑같은애라 미리 만들어도 상관 xxx
 *  		prototype: 객테 생성 시점을 뒤로 미루고, 주입 직전에 생성하며, 주입할떄마다 새로운 객체가 생성됨 (@Lazy 설정을 포함함) > 주입받을때마다 새로 만들어줘야함. 즉, 미리 만들어놓을 필요 xxx
 *  		----------------------------스탠드얼론은 이 위쪽만 사용 가능 ↑↑↑-------------------------------------------------------
 *  		request: 요청 객체와 똑같은 생명 주기를 갖는 빈 (프로토와 차이, 얜 살아있는동안 계속 같은 객체를 주입해줌)
 *  		session: 세션 객체와 동일한 생명 주기를 갖는 빈 (세션id가 생성될 때 생성, 세션이 소멸될 때 소멸, 쓰레기 세션처럼 쓰레기 빈도 남음)
 *  		application: ServletContext와 동일 생명주기를 갖는 빈(서버가 구동될 때 생성, 서버가 꺼질 때 소멸)
 * 
 * 	* Design Pattern (singleton) - 기존 학습했던 싱긅턴
 * 	: 어플리케이션 실행 중 힙 메모리 상에 특정 클래스의 인스턴스가 하나만 로딩되는 구조
 * 	  즉, 싱글턴 대상 = 클래스
 * 
 * 2. 구체적인 설정이 없으면, eager-loading 방식으로 객체를 미리 생성함. ( 서블릿 컨테이너와 동일한 속성 )
 * 	@Lazy: 객체가 주입되기 전까지는 생성이 지연됨 
 * 
 * 3. 관리 대상 객체의 생명주기 콜백 메소드 실행
 * 	  initMethod(***): 객체 생성 후 필요 의존성 주입이 완료된 후 실행됨
 * 					   주로, 주입된 객체를 대상으로 추가적인 처리가 필요할 때 할용됨 (== 주입잘됐나 확인)
 * 	  destroyMethod  : 객체 소멸 전에 실행됨.
 * 					   singleton: 컨테이너가 소멸될 떄 같이 소멸. (언제 또 객체가 필요할 지 몰라서 쉽게 죽일 수 없음)
 * 					   prototype: null 레퍼런스 할당으로 더이상 사용되지 않는 경우에 소멸
 */

@Slf4j
@Lazy
public class Case03ContainerBeaManagementPolicyConfig {
//	@Bean
//	@Lazy // 주입이 될 때 까지 객체 생성을 뒤로 미루는 것
////	@Scope()
//	public StringBuffer sb1() {
//		log.info("sb1 팩토리 메소드 실행");
//		return new StringBuffer();
//	}

	@Bean(initMethod = "start", destroyMethod = "expire")
//	@Scope("prototype")
	@Lazy(false)
	public EagerDummy eagerDummy(EagerSingletonDummy esd) {
		EagerDummy ed = new EagerDummy();
		ed.setEsd(esd);
		return ed;
	}
	
	@Bean
	@Lazy(false)
	public EagerSingletonDummy eagerSingletonDummy() {
		return new EagerSingletonDummy();
	}
	
	@Bean
	@Lazy
	public LazyDummy lazyDummy() {
		return new LazyDummy();
	}
	
	@Bean
	@Lazy
	@Scope("prototype")
	public LazyPrototypeDummy lazyPrototypeDummy() {
		return new LazyPrototypeDummy();
	}
}
