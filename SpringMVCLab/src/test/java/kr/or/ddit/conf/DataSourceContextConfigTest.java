package kr.or.ddit.conf;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitWebConfig(classes = DataSourceContextConfig.class)
class DataSourceContextConfigTest {
	
	@Inject
	DataSource datasuurce;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void testDatasource() {
		log.info("dataSource: {}", datasuurce);
	}
	
	@Test
	void templateTest() {
		log.info("jdbcTemplate: {}", jdbcTemplate);
	}

}
