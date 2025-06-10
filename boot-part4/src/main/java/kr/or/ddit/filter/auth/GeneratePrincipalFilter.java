package kr.or.ddit.filter.auth;

import java.io.IOException;
import java.security.Principal;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.vo.MemberVO;

public class GeneratePrincipalFilter extends HttpFilter{
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletRequestWrapper wrapper = 
				new HttpServletRequestWrapper(req) {
			@Override
			public Principal getUserPrincipal() {
				HttpSession session = getSession(false);	// 유효한 세션이 없을경우 null 값 가져오게 함
				
				MemberVO authUser = null;
				// session이 있을 경우에만 로직 실행하게 함.
				if(session != null) {
					authUser = (MemberVO)session.getAttribute("authUser");	
				}				
				if(authUser!=null) {
					return new MemberVOWrapper(authUser);
				} else {
					return null;
				}
			}
		};
		chain.doFilter(wrapper, res);
	}
}
