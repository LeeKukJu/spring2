package kr.or.ddit.controller.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.service.IDDITBoardService;
import kr.or.ddit.vo.test.DDITBoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ddit")
public class DDITBoardController {
	
	@Inject
	private IDDITBoardService boardService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String dditRegisterForm(DDITBoardVO board, Model model) {
		log.info("DDIT board 등록 화면");
		model.addAttribute("board", board);
		return "dditboard/register";
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String dditRegister(DDITBoardVO board, BindingResult result, Model model) throws Exception {
		log.info("DDIT board 등록");
		
		boardService.register(board);
		
		return "redirect:/ddit/detail?boNo=" + board.getBoNo();
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String dditDetail(int boNo, Model model) throws Exception{
		log.info("DDIT 세부 게시글 조회");
		
		DDITBoardVO board = boardService.view(boNo);
		model.addAttribute("board", board);
		
		return "dditboard/detail";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String dditModifyForm(int boNo, Model model) throws Exception{
		log.info("DDIT BOARD 수정 화면");
		
		DDITBoardVO board = boardService.view(boNo);
		model.addAttribute("board", board);
		model.addAttribute("status", "u");
		
		return "dditboard/register";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String dditModify(DDITBoardVO board, Model model) throws Exception{
		log.info("DDIT BOARD 수정");
		
		boardService.update(board);
		
		return "redirect:/ddit/detail?boNo=" + board.getBoNo();
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String dditDelete(int boNo, Model model) throws Exception{
		log.info("DDIT BOARD 삭제");
		
		boardService.remove(boNo);
		
		
		return "redirect:/ddit/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String dditList(Model model) throws Exception{
		log.info("DDIT BOARD 목록 조회");
		
		List<DDITBoardVO> boardList = boardService.list();
		
		model.addAttribute("list", boardList);
		
		return "dditboard/list";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String dditSearch(String searchType, String searchWord, Model model) throws Exception{
		log.info("DDIT BOARD 검색");
		System.out.println(searchType + " : " + searchWord);
		Map<String, String> searchMap = new HashMap<String, String>();
		
		searchMap.put("searchType", searchType);
		searchMap.put("searchWord", searchWord);
		
		List<DDITBoardVO> boardList = boardService.search(searchMap);
		
		model.addAttribute("list", boardList);
		
		return "dditboard/list";
	}
}
