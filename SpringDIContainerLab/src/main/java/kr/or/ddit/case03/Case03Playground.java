package kr.or.ddit.case03;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.or.ddit.case03.conf.Case03ContainerBeaManagementPolicyConfig;
import kr.or.ddit.case03.objs.EagerDummy;
import kr.or.ddit.case03.objs.EagerSingletonDummy;
import kr.or.ddit.case03.objs.LazyDummy;
import kr.or.ddit.case03.objs.LazyPrototypeDummy;
import lombok.extern.slf4j.Slf4j;

/**
 *  메소드를 파라미터로 주입받는 방법까지만 봤음!
 */
@Slf4j
public class Case03Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Case03ContainerBeaManagementPolicyConfig.class);
		
		context.registerShutdownHook();
		// 객체를 2번 주입받는다
		StringBuffer sb1 = context.getBean("sb1", StringBuffer.class);
		StringBuffer sb2 = context.getBean("sb1", StringBuffer.class);
		sb1 = null;	// null 레퍼런스 할당, 바로 없어지지는 않음

//		log.info("sb1==sb2 : {}", (sb1==sb2));
	
//		context.getBean(LazyDummy.class);
//		context.getBean(LazyDummy.class);	// 얘는 왜 한개만 생겨???
//		context.getBean(LazyPrototypeDummy.class);
//		context.getBean(LazyPrototypeDummy.class);
	}
}
