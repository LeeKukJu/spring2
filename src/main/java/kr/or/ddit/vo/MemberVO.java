package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private int userNo;					// 회원번호
	private String userId;				// 회원아이디
	private String userPw;				// 회원 비밀번호
	private String userName;			// 회원이름
	private Date regDate;				// 등록일
	private Date updDate;				// 수정일
	private List<MemberAuth> authList;	// 회원권한목록
}
