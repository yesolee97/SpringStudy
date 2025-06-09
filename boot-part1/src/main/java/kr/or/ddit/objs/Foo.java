package kr.or.ddit.objs;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class Foo {
	private final Bar bar;
	
	public void method() {
		log.info("로직 실행");
	}
	
	@PostConstruct
	public void init() {
		log.info("주입여부 확인 : {}", bar);
	}
}
