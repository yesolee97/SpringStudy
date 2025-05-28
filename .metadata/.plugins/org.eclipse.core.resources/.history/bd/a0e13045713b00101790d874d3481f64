package kr.or.ddit.dummy.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.dummy.conf.DummyContextConfig;
import kr.or.ddit.dummy.dao.DummyDAO;
import kr.or.ddit.dummy.dao.DummyDAOImpl_MariaDB;
import kr.or.ddit.dummy.dao.DummyDAOImpl_Oracle;
import kr.or.ddit.dummy.service.DummyServiceCase1;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyController {
	public static void main(String[] args) {
		// context = 객체의 저장소, DummyContextConfig에서 저장한 2개의 구현체가 저장되어있음 
		ApplicationContext context = new AnnotationConfigApplicationContext(DummyContextConfig.class);
		DummyServiceCase1 service = context.getBean(DummyServiceCase1.class);
		
		StringBuffer infomation = service.readDummy("primary");
		log.info("만들어진 요리: {}", infomation);
	}
}
