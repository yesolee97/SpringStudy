package kr.or.ddit.lprod.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.vo.LprodVO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/lprod")
@RequiredArgsConstructor
public class LprodRestController {
	private final LprodService service;
	
	@GetMapping
	public List<LprodVO> allLprod(){
		return service.readLprodList();
	}
	
	@GetMapping("/{lprodGu}")
	public LprodVO oneLprod(
		@PathVariable String lprodGu
	){
		return service.readLprodOne(lprodGu);
	}
	
	// 신규 등록
	@PostMapping()
	public Map<String,Object> newLprod(@RequestBody LprodVO lprod ){
		service.createLprod(lprod);
		return Map.of("success", true, "target", lprod);
	}
}
