package kr.or.ddit.case08.conf;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import kr.or.ddit.case08.objs.DestVO;
import kr.or.ddit.case08.objs.OriginalVO;

/**
 * Map 과 관련된 이슈
 * Map 타입을 주입받을 시, 타입과 빈id 가 모두 일치하도록 주입받아야 함
 * 	--> 그 이외의 경우 [스프링 컨테이너의 빈팩토리]를 map 으로 주입받을 수 있음
 * 	==> 이렇게 컨테이너를 주입받을경우, 순환참조의 문제 발생 가능성이 있음
 * 
 * 
 * @Value 어노테이션의 싱글값으로 spEL을 사용할 수 있음
 * > spEL의 형태: #{빈id}, #{빈id.프로퍼티명}, #{빈id.['프로퍼티명']}
 * 	 --> jsp EL과 문법 구조는 비슷함.
 * > property placeholer: #{프로퍼티명} - 컨테이너의 프로퍼티 소스에 있는 프로퍼티에 접근
 * 
 * 주의!!!
 * 		1. '+', '*' : jsp에서는 산술 연산만 처리함
 * 					: spEL에서는 피연산자의 타입에 따라 다른 연산을 처리함 (문자열과 관련해 처리가 늘어났음)
 * 		2. 삼항연산자 (조건식? 참:거짓)
 * 					: 스프링에서는 앨비스 연산자로도 처리할 수 있음 - js의 널 병합 연산자와 유사
 * 					EX) 	a = null;
 * 							b = a!=null ? a : "기본값"
 * 							js 널 병합 연산 !! 
 * 							> ? b=a ?? "기본값"
 * 							spEL 앨비스연산자 	
 * 							> ? b= a ?: "기본값"
 * 		3. static 구성요소에 대한 접근 지원.
 * 			spEL ? T(kr.or.ddit.case08.objs.OriginalVO).staticNumber
 * 						↑ 이게 → OriginalVO.class 형태로 바뀜!!
 * 				   T(class qualified name).static 프로퍼티명
 */
@Configuration
public class Case08ExpressionLanguageConfig {
	
	@Bean
	public List<String> list(){
		return List.of("값1", "값2");
	}
	
	@Bean
	public List<String> noneUseList(){
		return new ArrayList<>();
	}

	@Bean
	public Map<String, Object> map(){
		return Map.of("key1", "value1", "key-2", "value2");
	}
	
	@Bean
	public OriginalVO original(
		List<String> list,	// 위에서 선언한 list가 여러개일 경우, 메소드 명과 동일한 메소드 명을 써주면 리플렉션 받아서 쓸 수 있음
		Map<String, Object> map,
		@Value("텍스트") String str,
		@Value("classpath:logback.xml") Resource res,
		@Value("34") int number
	) {
		return new OriginalVO(list, map, null, res, number);
	}
	
	@Bean
	public DestVO dest(
		// str이 유효한 값을 가지고 있으면 넣고, 그렇지 않을경우 설정한 기본값 세팅
		// @Value("#{original.str ?: '기본값'}") String str,	// * >> 스프링만 가지고 있는 특수한 연산, 문자열의 길이 *
		// @Value("#{T(org.apache.commons.lang3.StringUtils).isNotBlank(original.str) ? original.str : '기본값'}") String str,
		@Value("#{T(org.apache.commons.lang3.StringUtils).isNotBlank(original.str) ?: '기본값'}") String str,
		@Value("#{original['res']}") Resource res,
		@Value("#{T(kr.or.ddit.case08.objs.OriginalVO).staticNumber * 10}") int number,
//		@Value("#{original.list[1]}") String secondStr
		@Value("#{original.list.get(1)}") String secondStr,
		@Value("#{original.map.get('key1')}") String key1Value,
		@Value("#{original.map['key-2']}") String key2Value,
		@Value("#{T(java.time.LocalDate).now()}") LocalDate today,
		@Value("#{T(java.time.LocalDateTime).now()}") LocalDateTime now		
	) {
//		LocalDate.now();
//		LocalDateTime.now();
		// StringUtils.isNotBlank(str) ? str : "기본값";
		return new DestVO(str, res, number, secondStr, key1Value, key2Value, today, now);
	}
}
