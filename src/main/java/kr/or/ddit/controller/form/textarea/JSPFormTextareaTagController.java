package kr.or.ddit.controller.form.textarea;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/formtag/textarea")
public class JSPFormTextareaTagController {
	/*
	 * 	6. 텍스트 영역 요소
	 * 	- HTML 텍스트 영역을 출력하려면 <form:textarea> 요소를 사용한다.
	 */
	
	// 1) 모델에 기본생성자로 생성한 폼 객체를 추가한 후 화면에 전달한다.
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		log.info("registerFomr01()");
		model.addAttribute("member", new Member());
		return "form/textarea/registerForm01";
		
	}
	
	// 2) 폼 객체를 생성하여 값을 설정한 후에 전달한다.
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		log.info("registerFomr02()");
		Member member = new Member();
		String introduction = "안녕하세요! \n 반값습니다. \n";
		member.setIntroduction(introduction);
		model.addAttribute("member", member);
		
		return "form/textarea/registerForm01";
		
	}
	
}
