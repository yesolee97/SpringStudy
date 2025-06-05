package kr.or.ddit.case08.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.servlet.http.HttpServletRequest;
import kr.or.ddit.case08.vo.NativeJavaVO;


/**
 * RestFul URI
 * 명사(URI) + 동사(Method)
 * case08/dummy + GET
 * case08/dummy/{key} + GET	 ( 경로 변수로 표현)
 * case08/dummy + POST
 * case08/dummy/{key} + DELETE
 */
@RestController // 이게 붙어있으면 jsp 리졸버는 못씀, 반드시 json 만 응답 데이터로 나가야함
@RequestMapping("/case08/dummy")
public class Case08RestApiController {
	private Map<String, NativeJavaVO> dummyDB;
	{
		dummyDB = new HashMap<>();		
		NativeJavaVO njv1 = new NativeJavaVO();
		dummyDB.put("pk1", njv1);
		njv1.setCode("pk1");
		njv1.setProp1("문자열");
		njv1.setProp2(32);
		njv1.setProp3(new String[] {"v1", "v2"});
		NativeJavaVO njv2 = new NativeJavaVO();
		dummyDB.put("pk2", njv2);
		njv2.setCode("pk2");
		njv2.setProp1("텍스트");
		njv2.setProp2(388);
		njv2.setProp3(new String[] {"v3", "v4"});
	}
	
	@GetMapping
	public List<NativeJavaVO> restGet() {
		return new ArrayList<>(dummyDB.values());		
	}
	
	@GetMapping("{key}")
	public NativeJavaVO restGet(@PathVariable String key) {	// 경로변수 받는 어노테이션 @PathVariable
		NativeJavaVO target = dummyDB.get(key);
		if(target==null) {
			throw new ResponseStatusException(HttpStatusCode.valueOf(404));
		}
		return target;
	}
	
	
	// 스프링을 안썼을 경우 >> HttpServletRequest req 파라미터로 받음 >> req.인풋스트림꺼내서 Gson으로 프롬 제이슨 > 언마샬링 함
	@PostMapping
	public NativeJavaVO create(@RequestBody NativeJavaVO njv) {	// 요거 왜 VO 필요함??
		String newPk = "pk" + dummyDB.size() + 10;
		njv.setCode(newPk);
		dummyDB.put(newPk, njv);
		return njv;		// 지금은 rest 구조니까 리스트로 안가고 기존에 화면에 랜더링되어있는 2개 정보에 지금 추가한 njv정보만 띄워줘도 됨
	}
	
	
	
	@PutMapping("{key}")
	public Map<String,Object> edit(@PathVariable String key, @RequestBody NativeJavaVO njv) {
		dummyDB.put(key, njv);		
		return Map.of("success", true, "target", njv);
	}
	
	
	@DeleteMapping("{key}")
	public Map<String, Object> restDelete(@PathVariable String key) {
		NativeJavaVO target = dummyDB.remove(key);	// 지우기 전에 반환
		return Map.of("success", true, "target", target);
	}
}

