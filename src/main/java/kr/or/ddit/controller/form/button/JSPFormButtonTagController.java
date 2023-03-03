package kr.or.ddit.controller.form.button;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/formtag/button")
public class JSPFormButtonTagController {
	/*
	 * 	14. 버튼 요소
	 * 	- HTML 버튼을 출력하려면 <form:button> 요소를 사용한다.
	 */
	
	// 1) 객체를 생성하여 값을 설정한 후 화면에 전달한다.
	@RequestMapping(value = "/registerFormButton01", method = RequestMethod.GET)
	public String registerFormButton01(Model model) {
		log.info("registerFormButton01");
		
		model.addAttribute("member", new Member());
		return "form/button/registerFormButton01";
	}
}
