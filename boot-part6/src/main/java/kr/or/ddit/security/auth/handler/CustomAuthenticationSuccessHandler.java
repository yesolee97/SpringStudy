package kr.or.ddit.security.auth.handler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.dummy.ExtenalCommunicator;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	@Autowired
	private ExtenalCommunicator exComm;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		log.info("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥ custom handler 동작");
		
		
		// 로그인 성공 시 gmail 스크랩핑 해서 가지고 오는 상황 가정
		exComm.longTermJob();	// 동기 실행이라서 10초 기다렸다가 로그인 됌
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
