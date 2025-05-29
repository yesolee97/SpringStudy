package kr.or.ddit.case08.conf;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import kr.or.ddit.case08.objs.OtherVO;
import kr.or.ddit.case08.objs.SimpleVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ComponentScan(basePackages = "kr.or.ddit.case08.objs")
public class Case08MapinjectTestConfing {
	
	@Bean
	public StringBuffer dummy2(
		Map<String, Object> beanFactory,
		@Value("${username}") String username
	) {
		log.info("username: {}", username);
		log.info("beanFactory size: {}", beanFactory.size());	// 17
		beanFactory.forEach((k,v)->{
			log.info("{} : {}", k, v);
		});
		
		return null;
	}
	
	
	
	
//	
//	@Bean
//	public Map<String, Object> map(){
//		return Map.of("K1", 34, "k2", "value");
//	}
//	
//	@Bean
//	public SimpleVO dummy(
//		Map<String, Object> map,	// hashmap으로 넣으면 >>  bean factory가 주입됐음
//		@Value("TEXT") String str
//	) {
//		map.forEach((k,v)->{
//			log.info("{} : {}", k, v);
//		});
//		
//		return new SimpleVO(map, str);
//	}
//	
//	@Bean
//	public OtherVO other(
//		@Value("#{dummy.str}") String str
//	) {
//		return new OtherVO(str);
//	}
}
