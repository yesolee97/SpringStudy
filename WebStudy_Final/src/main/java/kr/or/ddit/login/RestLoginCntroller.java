package kr.or.ddit.login;

import java.util.Base64;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


// 이 컨트롤러가 위임장 발급해주는 서버와 같은 역할을 해줌 !!!
@RestController
@RequiredArgsConstructor
public class RestLoginCntroller {
	private final AuthenticationManager authenticationManager;
	
	@PostMapping("/rest/auth")
	public ResponseEntity<?> authenticate(@RequestBody RestAuthVO auth) {
		// 매니저 쓰려면 토큰 만들어야함
		UsernamePasswordAuthenticationToken inputData = 
		UsernamePasswordAuthenticationToken.unauthenticated(auth.getUsername(), auth.getPassword());
		
		try {
			// 인증에 성공하는경우, 실패하는 경우 존재함 >> 얘가 인증해주는애라서
			authenticationManager.authenticate(inputData);
			// String tokenValue = "c001:java"; << 이 형태로 만들어주는 작업해줌
			String tokenValue = auth.getUsername() + ":" +auth.getPassword();
			String encodedToken = Base64.getEncoder().encodeToString(tokenValue.getBytes());	// 인코딩된 토큰 만들어줌
			
			return ResponseEntity.ok().body(Map.of("token", encodedToken));
		} catch (AuthenticationException e) {
			// 인증실패 - 401 상태코드 내보냄
			return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(Map.of("error", 401, "message", e.getMessage()));
		}
	}
	
}
