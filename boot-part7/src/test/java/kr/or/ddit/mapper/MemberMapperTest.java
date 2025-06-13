package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class MemberMapperTest {
	@Autowired
	MemberMapper mapper;
	@Test
	void testSelectMemberByMail() {
		MemberVO member = mapper.selectMemberByMail("yesolee97@gmail.com");
		log.info("조회 결과: {}", member);
	}

}
