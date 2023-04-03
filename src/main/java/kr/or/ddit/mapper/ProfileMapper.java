package kr.or.ddit.mapper;

import kr.or.ddit.vo.test.DDITMemberVO;

public interface ProfileMapper {

	public DDITMemberVO selectMember(DDITMemberVO sessionMember);

	public int profileUpdate(DDITMemberVO memberVO);

}
