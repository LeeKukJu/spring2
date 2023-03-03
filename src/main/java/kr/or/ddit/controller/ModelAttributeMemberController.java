package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/modelattribute")
public class ModelAttributeMemberController {
	
	/*
	 * 	3. @ModelAttribute 어노테이션
	 * 	- 해당 어노테이션은 전달받은 매개변수를 강제로 Model에 담아서 전달하도록 할 때 필요한 어노테이션이다.
	 */
	
	// @ModelAttribute 사용 페이지
	@RequestMapping(value = "registerForm", method = RequestMethod.GET)
	public String registerForm() {
		log.info("@ModelAttribute 어노테이션");
		log.info("registerForm()");
		return "member/registerModelAttributeForm";
	}
	
	// 1) 기본 자료형은 매개변수로 선언하더라도 기본적으로 전달되지 않는다.
	@RequestMapping(value = "/register01", method = RequestMethod.POST)
	public String register01(String userId, String password) {
		log.info("@ModelAttribute 어노테이션");
		log.info("register01()");
		log.info("userId : " + userId);
		log.info("password : " + password);
		
		return "result";
	}
	
	// 2) 기본 자료형인 매개변수에 @ModelAttribute 어노테이션을 지정하여 데이터를 전달한다.
	@RequestMapping(value = "/register02", method = RequestMethod.POST)
	public String register02(@ModelAttribute("userId") String userId, String password) {
		// @ModelAttribute 어노테이션을 이용해서 데이터를 전달한다.
		// Model을 따로 받지 않아도 데이터를 전달할 수 있다.
		log.info("@ModelAttribute 어노테이션");
		log.info("register02()");
		log.info("userId : " + userId);
		log.info("password : " + password);
		
		return "result";
	}
	
	// 3) 기본 자료형인 매개변수가 여러 개인 경우에 각각의 매개변수에 @ModelAttribute 어노테이션을 지정하여 데이터를 전달한다.
	@RequestMapping(value = "/register03", method = RequestMethod.POST)
	public String register03(
			@ModelAttribute("userId") String userId, 
			@ModelAttribute("password") String password) {
		// @ModelAttribute 어노테이션을 이용해서 데이터를 전달한다.
		// Model을 따로 받지 않아도 데이터를 전달할 수 있다.
		log.info("@ModelAttribute 어노테이션");
		log.info("register03()");
		log.info("userId : " + userId);
		log.info("password : " + password);
		
		return "result";
	}
	
	// 4) 자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 기본적으로 전달된다.
	@RequestMapping(value = "/register04", method = RequestMethod.POST)
	public String register04(Member member) {
		log.info("@ModelAttribute 어노테이션");
		log.info("register04()");
		log.info("userId : " + member.getUserId());
		log.info("password : " + member.getPassword());
		
		return "result";
	}
	
	// 5) 자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 기본적으로 전달된다.2222
	@RequestMapping(value = "/register05", method = RequestMethod.POST)
	public String register05(Member member) {
		log.info("@ModelAttribute 어노테이션");
		log.info("register05()");
		log.info("userId : " + member.getUserId());
		log.info("password : " + member.getPassword());
		log.info("postCode : " + member.getAddress().getPostCode());
		log.info("location : " + member.getAddress().getLocation());
		
		return "result";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
