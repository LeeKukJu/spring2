package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/redirectattribute")
public class RedirectAttributeMemberController {
	/*
	 * 	4. RedirectAttribute 타입
	 * 	- RedirectAttribute는 일회성으로 데이터를 전달하는 용도로 사용된다.
	 */
	
	// RedirectAttribute 처리를 위한 Form 페이지
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		log.info("RedirectAttribute 타입");
		log.info("registerForm()");
		return "member/registerRedirectAttributeForm";
	}
	
	// RedirectAttribute 객체에 일회성 데이터를 지정하여 전달한다.
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member, RedirectAttributes redirectAttribute) throws Exception {
		log.info("RedirectAttribute 타입");
		log.info("register()");
		log.info("userId : " + member.getUserId());
		log.info("password : " + member.getPassword());
		
		redirectAttribute.addFlashAttribute("msg", "success");
		
		return "redirect:/redirectattribute/result";
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String result() throws Exception {
		log.info("RedirectAttribute 타입");
		log.info("result()");
		return "result";
	}
}
