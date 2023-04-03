package kr.or.ddit.controller.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

// 비밀번호 암호화 하지 않겠다!!
// 스프링 시큐리티 5부터는 기본적으로 PAsswordEncoder를 지정해야함 
@Slf4j
@Controller
public class CustomNoOpPasswordEncoder implements PasswordEncoder {
	
	// 비밀번호를 암호화 하지 않고 파라미터로 받은 비밀번호를 아무런 암호화 없이 리턴하여 그대로 사용한다.
	@Override
	public String encode(CharSequence rawPassword) {
		log.warn("before encode : " + rawPassword);
		
		return rawPassword.toString();
	}
	
	// 위의 리턴 값을 encodedPassword 로 받음
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		log.warn("matches : " + rawPassword + ":" + encodedPassword);
		
		return rawPassword.toString().equals(encodedPassword);
	}
}
