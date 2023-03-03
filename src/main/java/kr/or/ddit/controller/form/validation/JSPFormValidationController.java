package kr.or.ddit.controller.form.validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/formtag/validation")
public class JSPFormValidationController {
	/*
	 * 	15. 입력값 검증 에러
	 *	- 입력값 검증 에러를 출력하려면 <form:errors> 요소를 사용한다.
	 */
	
	// 1) 객체를 생성하여 값을 설정한 후 화면에 전달한다.
	@RequestMapping(value = "/registerFormValidation01", method = RequestMethod.GET)
	public String registerFormValidation01(Model model) {
		log.info("registerFormValidation01()");
		
		Member member = new Member();
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		
		model.addAttribute("member", member);
		
		return "form/validation/registerFormValidation01";
	}
	
	// 결과
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String registerFormValidationResult(Member member) {
		return "form/validation/result";
	}
}
