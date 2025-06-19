package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.or.ddit.common.PaginationInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class ProdMapperTest {

	@Autowired
	ProdMapper mapper;

	@Test
	void testSelectProdList() {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPageNo(3);
	
		mapper. selectProdList(paging) . forEach(p->log.info("{}", p.getRnum()));


	}

}
