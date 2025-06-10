package kr.or.ddit.lprod.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.vo.LprodVO;

@Controller
@RequestMapping("/lprod")
public class LprodController {
	@Autowired
	private LprodService service;
	
	@GetMapping
	public String list(Model model, Principal pricipal) {
		List<LprodVO> lprodList = service.readLprodList();
		model.addAttribute("lprodList", lprodList);
		return "lprod/lprodList";
	}	
}
