package kr.or.ddit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.NoticeFileVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;
import kr.or.ddit.vo.test.DDITMemberVO;

public interface INoticeService {

	public ServiceResult insertNotice(HttpServletRequest req, NoticeVO noticeVO) throws Exception;

	public NoticeVO selectNotice(int boNo);

	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);

	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);

	public ServiceResult updateNotice(HttpServletRequest req ,NoticeVO notice);

	public ServiceResult deleteNotice(int boNo, HttpServletRequest req);

	public ServiceResult idCheck(String memId);

	public ServiceResult signup(DDITMemberVO memberVO, HttpServletRequest req);

	public DDITMemberVO loginCheck(DDITMemberVO member);

	public String findId(DDITMemberVO member);

	public String findPw(DDITMemberVO member);

	public List<NoticeVO> selectListNotice();

	public NoticeFileVO noticeDownload(int fileNo);

	public DDITMemberVO selectMember(DDITMemberVO sessionMember);

	public ServiceResult profileUpdate(HttpServletRequest req, DDITMemberVO memberVO);
	
}
