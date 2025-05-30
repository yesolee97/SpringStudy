package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.annotation.RootContextConfig;
import kr.or.ddit.vo.BuyerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RootContextConfig
class BuyerMapperTest {
	
	@Autowired
	BuyerMapper mapper;


	@Test
	void testInsertBuyer() {
		BuyerVO buyer = new BuyerVO();
		buyer.setBuyerName("상품제조사2");
		buyer.setLprodGu("P101");
		buyer.setBuyerBank("하나2");
		buyer.setBuyerBankname("계좌주2");
		buyer.setBuyerBankno("0000");
		buyer.setBuyerComtel("000-0000-0000");
		buyer.setBuyerMail("a@naver.com");
		buyer.setBuyerCharger("담당자");
		
		
		assertEquals(1, mapper.insertBuyer(buyer)); 
	}
	
	@Test
	void testSelectBuyerList() {
		mapper.selectBuyerList()
			.forEach(buyer->log.info("---> {}, {}", buyer.getBuyerName(), buyer.getProdList().size()));
	}
	
	
	@Test
	void testSelectBuyer() {
		// P10101 을 조회하고
		// 제조사 명과 제조사 주소, 제조사 분류명, 거래품목명, 구매가
//		log.info("출력결과 {}", mapper.selectBuyer("P10101"));
		BuyerVO buyer = mapper.selectBuyer("P10108");
		log.info("제조사정보: {}, {}, {}",
			buyer.getBuyerName(),
			buyer.getBuyerAdd2(),
			buyer.getLprod().getLprodName()
		);
		buyer.getProdList()
				.forEach((prod)-> log.info("거래품목명{}, {}, {}", prod.getProdName(), prod.getProdPrice(), prod.getBuyerId()));
	}

}
