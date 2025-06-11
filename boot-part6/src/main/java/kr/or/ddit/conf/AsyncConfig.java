package kr.or.ddit.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
//스프링이 Async가 붙은 모든 메서드를 찾아서 스레드로 감싸줌 (즉, 멀티스레드 환경 조성이 가능해짐)
@EnableAsync
public class AsyncConfig {

}
