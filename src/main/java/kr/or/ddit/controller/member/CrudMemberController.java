package kr.or.ddit.controller.member;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/crud/member")
public class CrudMemberController {
	
	@Inject
	private IMemberService memberService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String crudMemberRegisterForm(MemberVO member, Model model) {
		log.info("crudMemberRegisterForm()");
		model.addAttribute("member", member);
		return "crud/member/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String crudMemberRegister(MemberVO member, Model model) throws Exception{
		log.info("crudMemberRegister()");
		// 서비스를 통해 회원 등록 요청
		memberService.register(member);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		
		return "crud/member/success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String crudMemberList(Model model) throws Exception {
		log.info("crudMemberList()");
		List<MemberVO> memberList = memberService.list();
		model.addAttribute("list", memberList);
		
		return "crud/member/list";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String crudMemberRead(int userNo, Model model) throws Exception {
		log.info("crudMemberRead()");
		MemberVO member = memberService.read(userNo);
		model.addAttribute("member", member);
		return "crud/member/read";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String crudMemberModifyForm(int userNo, Model model) throws Exception {
		log.info("crudMemberModify()");
		MemberVO member = memberService.read(userNo);
		model.addAttribute("member", member);
		return "crud/member/modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String crudMemberModify(MemberVO member, Model model) throws Exception{
		log.info("crudMemberModify()");
		memberService.modify(member);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "crud/member/success";
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String crudMemberDelete(int userNo, Model model) throws Exception{
		log.info("crudMemberDelete()");
		memberService.remove(userNo);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "crud/member/success";
	}
}
