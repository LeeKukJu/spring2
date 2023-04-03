package kr.or.ddit.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/springBoard")
public class SpringBoardController {
	
	// 1) 게시판 목록 요청 => 누구나 접근 가능
	// 요청URI : /springBoard/list
	@GetMapping("/list")
	public String list() {
		log.info("list : 누구나 접근 가능");
		// view > springBoard > list.jsp를 forwarding
		return "springBoard/list";
				
	}
	
	// 2) 게시판 등록 요청 => 로그인한 회원만 접근 가능
	// 요청URI : /springBoard/register
	@GetMapping("/register")
	public String registerForm() {
		log.info("register : 로그인한 회원만 접근 가능");
		// view > springBoard > register.jsp를 forwarding
		return "springBoard/register";
	}
	
	
	
	
}
