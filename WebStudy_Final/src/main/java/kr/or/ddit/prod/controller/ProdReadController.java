package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;

/**
 * 1. 요청 수신
 * 2. 요청 검증
 * 3. 로직을 사용하고, 모델을 생성 (김치찌개를 만들었다)
 * 4. 모델을 뷰로 전달 (scope를 통해 공유함)
 * 5. 뷰를 선택
 * 6. 뷰로 이동(forword, redirect)
 * 
 * - 스코프 선택 기준:
 * 1. 모델의 사용범위
 * 2. 뷰로 이동할 때 사용하는 이동 방식(forword, redirect)
 */
//@WebServlet({"/prod/prodList.do", "/ajax/prod"})
@Controller
@RequestMapping("/prod")
@RequiredArgsConstructor
public class ProdReadController{	
	private final ProdService service;
	
	@GetMapping("/prodList.do")
	public String doGet(Model model) {
		List<ProdVO> prodList =  service.readProdList();		
		model.addAttribute("prodList", prodList);
		
		return "prod/prodList";
	}
	
	
	@GetMapping("/prodDetail.do")
	public String getDetail(@RequestParam("what") String prodId, Model model) {
		ProdVO prod =  service.readProd(prodId).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "그런 상품 없음"));
		model.addAttribute("prod", prod);
		
		return "prod/prodDetail";
	}

}
