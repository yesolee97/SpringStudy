package kr.or.ddit.case08.conf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import lombok.extern.slf4j.Slf4j;

@SpringJUnitConfig(classes = Case08MapinjectTestConfing.class)
@Slf4j
class Case08MapinjectTestConfingTest {
	
	@Autowired
	ConfigurableApplicationContext context;	// 컨테이너 주입
	
	@Test
	void testDummy() {
		log.info("컨테이너에 등록된 빈의 갯수: {}", context.getBeanDefinitionCount());
	}

}
