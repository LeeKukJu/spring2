package kr.or.ddit.controller.form.hidden;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/formtag/hidden")
public class JSPFormHiddenTagController {
	/*
	 * 	12. 숨겨진 필드 요소
	 * 	- HTML 숨겨진 필드를 출력하려면 <form:hidden> 요소를 사용한다.
	 */
	
	// 1) 객체를 생성하여 값을 설정한 후 화면에 전달한다.
	@RequestMapping(value = "/registerFormHidden01", method = RequestMethod.GET)
	public String registerFormHidden01(Model model) {
		log.info("registerFormHidden01()");
		
		Member member = new Member();
		member.setUserId("a001");
		member.setUserName("홍길동");
		model.addAttribute("member", member);
		return "form/hidden/registerFormHidden01";
	}
	
	
	// 2) 결과
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String registerFormHiddenResult(Member member, Model model) {
		log.info("registerFormHiddenResult()");
		
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getUserName() : " + member.getUserName());
		return "form/hidden/result";
		
	}
}
