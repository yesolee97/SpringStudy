package kr.or.ddit.case08.objs;

import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Component
@AllArgsConstructor
@Data
public class SimpleVO {
	private Map<String, Object> map;	// 요기 빈 팩토리 들어왔음 {dummy= SimpleVO}
	private String str;
}
