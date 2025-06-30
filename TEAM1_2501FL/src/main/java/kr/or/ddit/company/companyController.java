package kr.or.ddit.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class companyController {
	
	@GetMapping("/company/view")
	public String getviewUI() {
		return "company/companyView";
	}
}
