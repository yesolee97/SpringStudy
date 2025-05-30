package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class LprodMapperTest {

	@Autowired
	LprodMapper proxy;
	
	@Test
	void testSelectLprod() {
		log.info("주입: {}", proxy);
		proxy.selectLprod("P101");
	}
	
	@Test
	void testSelectLprodList() {
		proxy.selectLprodList();
	}

}
