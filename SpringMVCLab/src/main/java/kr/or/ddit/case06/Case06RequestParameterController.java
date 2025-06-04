package kr.or.ddit.case06;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/case06") /* 상위단게 맵핑 */	
public class Case06RequestParameterController {
	// 기존방식 >> 스프링을 쓰지 않고 파라미터 처리 !!
	// 문자로 전달된 name(필수), 숫자로 전달된 age(옵셔널), 문자들로 전달된 hobbys(옵셔널)
	@GetMapping("parameter01")
	public String heandler01(HttpServletRequest req) {
		String name = req.getParameter("name");
		// 필수 파라미터 name 검증 !!
		if(org.apache.commons.lang3.StringUtils.isBlank(name)) {
			throw new ResponseStatusException(HttpStatusCode.valueOf(400));
		}

		// 파라미터가 있는지 없는 지 봐야함!
		int age = Optional.ofNullable(req.getParameter("age"))
				.map(Integer::parseInt)
				.orElse(-1);
		String[] hobbies = req.getParameterValues("hobbys");
		
		log.info("name: {}", name);
		log.info("age: {}", age);
		log.info("hobbies: {}", Arrays.toString(hobbies));
		return "case06/view01";
	}
	
	// 스프링방식 >> request없이 어노테이션을 통해 어댑터에게 주입받기
	@GetMapping("parameter02")
	public String heandler02(
		@RequestParam String name
		, @RequestParam(required = false, defaultValue = "-1") int age
		, @RequestParam(required = false) String[] hobbies	// 없을 떄 null을 받을 수 있는 애라 디폴트벨류 필요x
		, Model model
	) {				
		log.info("name: {}", name);
		log.info("age: {}", age);
		log.info("hobbies: {}", Arrays.toString(hobbies));
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("hobbies", hobbies);
		
		return "case06/view01";
	}
	
	
	@RequestMapping("parameter03")
	public String heandler03(
			// @RequestParam Map<String,String[]> parameters
			@RequestParam MultiValueMap<String,String> parameters
			, Model model
			) {				
		log.info("parameters: {}", parameters);
		model.addAllAttributes(parameters);
		
		return "case06/view01";
	}
}
