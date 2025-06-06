package kr.or.ddit.case09.conf;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Properties;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.case09.objs.DBInfoVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(classes = Case09ReadPropertisConfig.class)
class Case09ReadPropertisConfigTest {
	
	@Autowired
	String[] array;
	
	
	@Autowired
	DBInfoVO infoVo;
	
	
	@Test
	void dbInfo2Test() {
		log.info("{}", infoVo);	
		log.info("{}", Arrays.toString(array));	
	}
	
	@Test
	@Disabled
	void test() {
		//log.info("{}", VO);
	}

}
