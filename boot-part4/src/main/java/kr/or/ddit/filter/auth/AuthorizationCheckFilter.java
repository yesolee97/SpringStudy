package kr.or.ddit.filter.auth;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.util.AntPathMatcher;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorizationCheckFilter extends HttpFilter {
	private final Map<String, List<String>> securedResoures;
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 보호자원에 대한 요청인지 판단
		String uri = request.getRequestURI();
		AntPathMatcher matcher = new AntPathMatcher();
		boolean secured = false;
		List<String> allowedRoles = null;	// 뭐하는놈?
		for(String key : securedResoures.keySet()) {
			secured = matcher.match(key, uri);	// 매칭 여부에 따라 값 결정
			if(secured) {	// 얘 왜 보호자원~~~?
				allowedRoles = securedResoures.get(key);
			}
		}
		
		boolean grandedUser = true;
		boolean pass = true;
		if(secured) {
		// 보호자원 요청
			// 권한 획득 여부 판단
			MemberVOWrapper principal = (MemberVOWrapper)request.getUserPrincipal();
			String userRole = principal.getRealUser().getMemRole(); // 로그인한 사용자의 권한
			// 권한 소유 여부: 자원에 설정된 접근한과 사용자가 부여받은 역할의 일치 여부
			grandedUser = allowedRoles.contains(userRole);
			if(grandedUser) {				
				// 인가된 사용자(권한 있음), 통과
				pass=true;
			} else {
				// 비인가 사용자(권한 없음), 403 에러 전송
				pass=false;
			}
		} else{
			// 비보호자원 요청, 통과	
			pass=true;
		}
		
		if(pass) {
			chain.doFilter(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "접근 권한이 없음");
		}
		
	}
}
