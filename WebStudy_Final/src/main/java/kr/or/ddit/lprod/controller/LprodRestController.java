package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.vo.LprodVO;
import lombok.RequiredArgsConstructor;

@Controller
// @RestController
@RequiredArgsConstructor
@RequestMapping({"/rest/lprod", "/ajax/lprod"})
public class LprodRestController{	
	private final LprodService service; 
	
	/* Resolver 사용 */
//	@GetMapping("/ajax/lprod")
//	@ResponseBody
//	public void getList(Model model){
//		List<LprodVO> lprodList = service.readLprodList();
//		model.addAttribute("lprodList", lprodList);
//		
//		String lvn = ""; // json에서는 사용xxx	
//	}

	@GetMapping()
	@ResponseBody
	public List<LprodVO> getList(Model model){
		List<LprodVO> lprodList = service.readLprodList();
		return lprodList;
	}
}
