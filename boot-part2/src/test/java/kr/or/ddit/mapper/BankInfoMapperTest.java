package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BankInfoMapperTest {
	@Autowired
	BankInfoMapper mapper;

	@Test
	void testSelectbankList() {
		mapper.selectbankList();
	}

}
