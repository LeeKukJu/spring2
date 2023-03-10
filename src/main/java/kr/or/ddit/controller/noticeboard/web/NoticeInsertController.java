package kr.or.ddit.controller.noticeboard.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.test.DDITMemberVO;

@Controller
@RequestMapping("/notice")
public class NoticeInsertController {
	
	@Inject
	private INoticeService noticeService;
	
	@RequestMapping(value = "/form.do", method = RequestMethod.GET)
	public String noticeform() {
		return "notice/form";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String noticeInsert(
			HttpServletRequest req,
			NoticeVO noticeVO, Model model) throws Exception {
		String goPage = "";
		Map<String, String> errors = new HashMap<>();
		
		if(StringUtils.isBlank(noticeVO.getBoTitle())) {
			errors.put("boTitle", "제목을 입력해주세요.");
		}
		if(StringUtils.isBlank(noticeVO.getBoContent())) {
			errors.put("boContent", "내용을 입력해주세요.");
		}
		
		if(errors.size() > 0) {
			model.addAttribute("errors", errors);
			model.addAttribute("notice", noticeVO);
			goPage = "notice/form";
		}else {
			HttpSession session = req.getSession();
			DDITMemberVO memberVO = (DDITMemberVO)session.getAttribute("SessionInfo");
			if(memberVO != null) {
				noticeVO.setBoWriter(memberVO.getMemId());
				ServiceResult result = noticeService.insertNotice(req, noticeVO);
				if(result.equals(ServiceResult.OK)) {
					goPage = "redirect:/notice/detail.do?boNo=" + noticeVO.getBoNo();
				}else {
					errors.put("message", "서버 에러, 다시 시도해주세요!");
					model.addAttribute("errors", errors);
					goPage = "notice/form";
				}
			}else {
				model.addAttribute("message", "로그인 후에 사용 가능합니다!");
				model.addAttribute("notice", noticeVO);
				goPage = "notice/form";
			}
			
		}
		return goPage;
		
		
		
	}
}
