package kr.or.ddit.case11.objs.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import jakarta.inject.Inject;
import kr.or.ddit.case11.conf.Case11MybatisSpringConfig;
import kr.or.ddit.vo.LprodVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(classes = Case11MybatisSpringConfig.class)
class LprodServiceImplTest {
	
	@Inject
	LprodServiceImpl service;
	
	@Test
	void testReadLprodList() {
		service.readLprodList();
	}

	@Test
	void testReadLprod() {
		
		assertDoesNotThrow(()->{
			LprodVO lprod = service.readLprod("P101").get();
			log.info("{}, 상품갯수: {}", lprod.getLprodGu(), lprod.getProdList().size());
			// List에 상품이 하나도 등록이 안되어있을 경우에 get(0)이 실행되면 null포인트 익셉션이 떠버림,
			// isEmpty니까 비어있으면 트루 > ! 붙여서 값이 있을때 true 반환하게
			if(!lprod.getProdList().isEmpty()) {
				log.info("첫번째 상품: {}", lprod.getProdList().get(0));
			}			
		});
	}

}
