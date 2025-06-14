package kr.or.ddit;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootTest
class BootPart2ApplicationTests {
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
		log.info("data-source: {}", datasource);
		log.info("jdbcTemplate: {}", jdbcTemplate);
	}

}
