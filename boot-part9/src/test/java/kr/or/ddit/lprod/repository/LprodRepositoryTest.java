package kr.or.ddit.lprod.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.lprod.entity.Lprod;


@Transactional
@SpringBootTest
class LprodRepositoryTest {

	@Autowired
	LprodRepository repository;
	
	@Test
	void testFindById() {
		Lprod lprod = repository.findById("P101").get();
		System.out.println(lprod.getLprodName());
		lprod.getBuyerList().forEach(b-> System.out.println(b.getBuyerName()));
	}

}
