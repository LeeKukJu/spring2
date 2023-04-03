package kr.or.ddit.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonController {
	
	@Autowired
	private IMemberService memberService;
	
	@GetMapping("/accessError")
	public String accessDenied(Authentication auth, Model model) {
		log.info("접근 거부 : " + auth);
		
		model.addAttribute("msg", "접근이 거부되었습니다.");
		return "security/accessError";
	}
	
	// 오류가 발생된 요청 URI : ex) /login?error=1
	// 로그아웃 후에 다시 로그인폼으로 돌아올 때의 요청URI : ex) /login?logout=1
	@GetMapping("/login")
	public String loginForm(@RequestParam(value = "error", required = false)String errors, 
			String logout, Model model) {
		log.info("error : " + errors);
		log.info("logout : " + logout);
		
		if(errors != null) {
			model.addAttribute("error", "로그인 에러!");
		}
		if(logout != null) {
			model.addAttribute("logout", "로그아웃!");
		}
		
		// <definition name="*/*" extends="tiles-layout">
		return "security/loginForm";
		
	}
	
	@GetMapping("/loginTest")
	public String loginTest(@RequestParam int userNo) {
		log.info("userNo : " + userNo);
		
		MemberVO memberVO = memberService.select(userNo);
		log.info("memberVO : " + memberVO);
		
		return null;
	}
}
