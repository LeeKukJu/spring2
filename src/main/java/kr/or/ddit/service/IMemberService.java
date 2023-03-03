package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.MemberVO;

public interface IMemberService {

	void register(MemberVO member) throws Exception;

	List<MemberVO> list() throws Exception;

	MemberVO read(int userNo) throws Exception;

	void modify(MemberVO member) throws Exception;

	void remove(int userNo) throws Exception;

}
