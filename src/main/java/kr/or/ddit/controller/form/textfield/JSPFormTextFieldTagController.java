package kr.or.ddit.controller.form.textfield;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/formtag/textfield")
public class JSPFormTextFieldTagController {
	/*
	 * 	4. 텍스트 필드 요소
	 * 	- HTML 텍스트 필드를 출력하려면 <form:input> 요소를 사용한다.
	 */
	
	// 1) 모델에 기본생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerFomr01(Model model) {
		log.info("registerForm01()");
		model.addAttribute("member", new Member());
		return "form/textfield/registerForm01";
	}
	
	// 2) 폼 객체를 생성하여 값을 설정한 후에 전달한다.
	// 	실행하고 값을 입력 또는 수정 후, 결과 페이지로 넘어가 결과를 확인한다.
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		log.info("registerForm02()");
		Member member = new Member();
		member.setEmail("ddit@ddit.com");
		member.setUserName("홍길순");
		model.addAttribute("member", member);
		
		return "form/textfield/registerForm01";
		
	}
	
}
