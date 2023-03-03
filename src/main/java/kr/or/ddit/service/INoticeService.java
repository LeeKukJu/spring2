package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;
import kr.or.ddit.vo.test.DDITMemberVO;

public interface INoticeService {

	public ServiceResult insertNotice(NoticeVO noticeVO);

	public NoticeVO selectNotice(int boNo);

	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);

	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);

	public ServiceResult updateNotice(NoticeVO notice);

	public ServiceResult deleteNotice(int boNo);

	public ServiceResult idCheck(String memId);

	public ServiceResult signup(DDITMemberVO memberVO);

	public DDITMemberVO loginCheck(DDITMemberVO member);

	public String findId(DDITMemberVO member);

	public String findPw(DDITMemberVO member);
	
}
