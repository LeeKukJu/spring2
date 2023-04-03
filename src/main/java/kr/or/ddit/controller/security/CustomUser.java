package kr.or.ddit.controller.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUser extends User{
	// jsp에서 principal.memberVO
	private MemberVO memberVO;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	
	public CustomUser(MemberVO memberVO) {
		// 사용자가 정의한 MemberVO 타입을 스프링 시큐리티 UsersDetails 타입으로 변환한다.
		// 사용자아이디, 비밀번호, 권한 리스트(memberVO.getAuthList()) 셋팅
		// memberVO.getAuthList() : List<memberAuth> authList 를
		//							>> Set<GrantedAuthority> authorities 로 바꿔줘야함
		super(memberVO.getUserNo()+"", memberVO.getUserPw(), memberVO.getAuthList().stream()
				.map(auth->new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList()));
		
		this.memberVO = memberVO;
		
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	
	
	

}
