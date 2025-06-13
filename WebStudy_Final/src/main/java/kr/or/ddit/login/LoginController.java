package kr.or.ddit.login;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {
	
	@GetMapping("${myapp.login-url}")
	public String loginForm(
		Authentication authentication 
		, RedirectAttributes redirectAttributes
		// 이게 뭐노~~
        , @SessionAttribute(name = WebAttributes.AUTHENTICATION_EXCEPTION, required = false) Exception lastException
		, HttpSession session
		, Model model
	) {
		// 익명사용자 체킹할때는 null 만 체킹하면 안됨
		if(authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
			redirectAttributes.addFlashAttribute("message", "이미 로그인 했자나~~~~");
			return "redirect:/";
		}
			
		 if(lastException!=null) {
	         model.addAttribute("message", lastException.getMessage());
	         session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	      }

		return "login/loginForm";
	}
	
	@GetMapping("${myapp.logout-url}")
	public String logout() {
		return "login/logout";
	}
}
