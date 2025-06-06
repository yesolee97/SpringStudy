package kr.or.ddit.mission.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import kr.or.ddit.mission.objs.Cabbin;
import kr.or.ddit.mission.objs.Hunter;
import kr.or.ddit.mission.objs.HuntingDog;
import kr.or.ddit.mission.objs.HuntingGround;
import kr.or.ddit.mission.objs.gun.shotGun;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * 사냥게임 모델링
 * 1. Hunter (헌터는 여러명 = 싱글턴으로 운영 x)
 * 	- 얘가 건을 가짐
 * 	- 케빈, 헌팅독 사용할 수 있어야 함
 * 2. HuntingGround: 사냥터에는 여러명의 사냥꾼이 존재할 수 있음 - 이 모든걸 얘가 가지고 있어야 함
 * 	- 오두막, 사냥개는 여기 속해있음
 * 3. Gun: 사냥꾼은 각자 자기 총을 소유함. ( 인터페이스 )
 * 	  ( 구현체 )
 * 	  - ShotGun 
 * 	  - Riffle (* 기본값, 우선권 가지고 있어야 함) 
 * 4. HuntingDog: 한마리의 사냥개를 여러 사냥꾼이 공유함
 * 5. Cabbin: 하나의 오두막을 공유함
 * 
 * 
 * 사냥터와 사냥꾼은 생명주기가 다름
 * 어그리게이션? - 생명주기가 다를때
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = "kr.or.ddit.mission.objs")
public class MissionConfig {
	@Autowired // 이렇게 선언하면 private를 잠깐 public으로 강제로 바꿔버림
	private ConfigurableApplicationContext context; // 플레이 그라운드에서 만든 객체를 여기서 주입받을 수 있음
	
	@Bean
	public List<Hunter> hunters(){
		return new ArrayList<>();
	}
	
	@Bean
	public HuntingGround ground(
		Cabbin cabin,
		HuntingDog dog
	) {
		return new HuntingGround(dog, cabin, hunters());
	}
	
	@PostConstruct
	public void init() {
		log.info("===================init!==========================");
		
		HuntingGround ground = context.getBean(HuntingGround.class);
		log.info("ground: {}", ground);
		Hunter hunter1 = context.getBean(Hunter.class);
		ground.enter(hunter1);	//  그라운드에서 만들었던 엔터 메소드 실행
		
		Hunter hunter2 = context.getBean(Hunter.class);
		ground.enter(hunter2);
		shotGun shotGun = context.getBean(shotGun.class);
		hunter2.changeGun(shotGun);
	}
}
