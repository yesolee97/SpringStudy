package kr.or.ddit.case04.objs.mapper;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("daoMaria")
public class Case04DummyMapperImpl_mariadb implements Case04DummyMapper {
	public Case04DummyMapperImpl_mariadb() {
		log.info("★★ {} 기본 생성자 실행", this.getClass().getSimpleName());
	}
	
}
