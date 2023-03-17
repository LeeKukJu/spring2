package kr.or.ddit.controller.noticeboard.web;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/notice")
public class NoticeRetrieveController {
	
	/*
	 * 	목록, 상세보기 페이지를 관여
	 */
	
	@Inject
	private INoticeService noticeService;
	
	@RequestMapping(value = "/list.do")
	public String noticeList(
			@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String searchWord,
			Model model
			) {
		
		PaginationInfoVO<NoticeVO> pagingVO = new PaginationInfoVO<>();
		
		if (StringUtils.isNotBlank(searchWord)) {
			pagingVO.setSearchType(searchType);
			pagingVO.setSearchWord(searchWord);
			model.addAttribute("searchType", searchType);
			model.addAttribute("searchType", searchWord);
		}
		
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = noticeService.selectNoticeCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<NoticeVO>noticeList = noticeService.selectNoticeList(pagingVO);
		pagingVO.setDataList(noticeList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "notice/list";
	}
	
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String noticeDetail(int boNo, Model model) {
		
		NoticeVO notice = noticeService.selectNotice(boNo);
		model.addAttribute("notice", notice);
		return "notice/detail";
	}
	
	
//	@PreAuthorize("hasRole('ROLE_MEMBER')")
//	@PreAuthorize("hasAnyRole('ROLE_MEMBER','ROLE_ADMIN')")
//	@PreAuthorize("permitAll")
//	@PreAuthorize("denyAll")
//	@PreAuthorize("isAnonymous()") : 현재 사용자가 익명(비로그인)인 상태인 경우 true
//	@PreAuthorize("isAuthenticated()") : 현재 사용자가 익명이 아니라면(로그인 상태라면) true
//	@PreAuthorize("isrememberMe()") : 현재 사용자가 자동로그인 상태라면(RememberMe 사용자라면) true
//	@PreAuthorize("isFullyAuthenticated()") : 현재 사용자가 익명이거나 자동로그인 상태가 아니라면(RememberMe 사용자가 아니라면) true
	@PreAuthorize("hasAnyRole('ROLE_MEMBER','ROLE_ADMIN')")
	@GetMapping("/selectListNotice")
	public String selectListNotice(Model model, Principal principal) {
		// 로그인한 사용자의 아이디(시큐리티의 UserDetails의 입장에서는 username
		//						우리는 memberVO의 userNo(로그인한 유저 기본키))를 리턴
		int userNo = Integer.parseInt(principal.getName());
		log.info("userNo : " + userNo);
		
		List<NoticeVO> noticeVOList = noticeService.selectListNotice();
		
		log.info("noticeVOList : " + noticeVOList);
		
		model.addAttribute("notieceVOList", noticeVOList);
		
		// views > noticeboard > noticeList
		return "noticeboard/noticeList";
	}
	
}
