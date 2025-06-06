package kr.or.ddit.case05.objs;

import org.springframework.stereotype.Controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Case05Controller {
	private Case05Service service;
	
	@Resource(name = "service")
	public void setService(Case05Service service) {
		this.service = service;
	}
	
	@PostConstruct
	public void start() {
		log.info("★★ 생성자로 주입된 service 확인: {}", service.getClass().getSimpleName());
	}
}
