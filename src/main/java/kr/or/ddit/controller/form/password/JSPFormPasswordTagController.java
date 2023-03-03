package kr.or.ddit.controller.form.password;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/formtag/password")
public class JSPFormPasswordTagController {
	/*
	 * 	5. 패스워드 필드 요소
	 *	- HTML 패스워드 필드를 출력하려면 <form:password> 요소를 사용한다.
	 */
	
	// 1) 모델에 기본생성자로 생성한 폼 객체를 추가한 후 화면에 전달한다.
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		log.info("registerForm01()");
		model.addAttribute("member", new Member());
		return "form/password/registerForm01";
	}
	
	// 2) 폼 객체를 생성하여 값을 설정한 후에 전달한다.
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		log.info("registerForm02()");
		Member member = new Member();
		// 값을 설정해서 뷰에 전달하더라도 패스워드 필드에 반영되지 않는다.
		member.setPassword("11223344");
		model.addAttribute("member", member);
		return "form/password/registerForm01";
		
	}
}
