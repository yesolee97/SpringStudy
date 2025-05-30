package kr.or.ddit.conf;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitWebConfig(classes = MapperContextConfig.class)
class MapperContextConfigTest {

	@Autowired
	SqlSessionFactory sqlSessionFactroy;
	
	@Test
	void testSqlSessionFactroy() {
		log.info(" {}", sqlSessionFactroy.openSession());
		
	}

}
