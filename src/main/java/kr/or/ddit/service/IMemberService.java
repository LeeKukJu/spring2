package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.MemberVO;

public interface IMemberService {

	public void register(MemberVO member) throws Exception;

	public List<MemberVO> list() throws Exception;

	public MemberVO read(int userNo) throws Exception;

	public void modify(MemberVO member) throws Exception;

	public void remove(int userNo) throws Exception;

	public MemberVO select(int userNo);

}
