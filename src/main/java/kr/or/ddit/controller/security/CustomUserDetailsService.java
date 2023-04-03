package kr.or.ddit.controller.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Inject
	private MemberMapper mapper;
	
	// 요청 파라미터 : username=2?password=1234&remember-me=on
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		log.warn("UserName : " + userName);;
		
		MemberVO memberVO = mapper.select(Integer.parseInt(userName));
		log.info("memberVO : " + memberVO);
		
		// null : 회원아이디에 해당하는 회원이 없을 때
		// User는 UserDetails와 부모와 자식의 관계. 스프링 시큐리티에서 제공
		return memberVO==null? null : new CustomUser(memberVO);
	}
	
}
