package kr.or.ddit.case06.objs.admin;

import org.springframework.stereotype.Controller;

import kr.or.ddit.case06.objs.preant.CommonService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
//회원 정보 정보 조회용 컨트롤러
public class AdminController {
	private final CommonService service;
}
