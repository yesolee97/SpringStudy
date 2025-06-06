package kr.or.ddit.case08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import jakarta.inject.Inject;
import kr.or.ddit.case08.conf.Case08ExpressionLanguageConfig;
import kr.or.ddit.case08.objs.DestVO;
import kr.or.ddit.case08.objs.OriginalVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(classes = Case08ExpressionLanguageConfig.class)
class Case08PlaygroundTest {
	
	@Autowired
	OriginalVO original;
	
	@Autowired
	DestVO dest;
	
	@Test
	void testDest() {
		log.info("복사된 객체: {}", dest);
	}
	
	@Test
	@Disabled
	void test() {
		log.info("★★★★★ 주입된 객체: {}", original);
	}
	

}
