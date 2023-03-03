package kr.or.ddit.controller.form.selectbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.CodeLabelValue;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/formtag/selectbox")
public class JSPFormSelectboxTagController {
	/*
	 * 	11. 셀렉트 박스 요소
	 * 	- HTML 셀렉트 박스를 출력하려면 <form:select> 요소를 사용한다.
	 */
	
	// 1) 모델에 Map타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormSelectbox01", method = RequestMethod.GET)
	public String registerFormSelectbox01(Model model) {
		log.info("registerFormSelectbox01()");
		
		Map<String, String> nationalityCodeMap = new HashMap<>();
		nationalityCodeMap.put("01", "Korea");
		nationalityCodeMap.put("02", "Canada");
		nationalityCodeMap.put("03", "Austrailia");
		
		model.addAttribute("nationalityCodeMap", nationalityCodeMap);
		model.addAttribute("member", new Member());
		
		return "form/selectbox/registerFormSelectbox01";
		
	}
	
	// 2) 모델에 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "registerFormSelectbox02", method = RequestMethod.GET)
	public String registerFormSelectbox02(Model model) {
		log.info("registerFormSelectbox02()");
		
		List<CodeLabelValue> nationalityCodeList = new ArrayList<>();
		nationalityCodeList.add(new CodeLabelValue("Korea", "01"));
		nationalityCodeList.add(new CodeLabelValue("Canada", "02"));
		nationalityCodeList.add(new CodeLabelValue("Austrailia", "02"));
		
		model.addAttribute("nationalityCodeList", nationalityCodeList);
		model.addAttribute("member", new Member());
		
		return "form/selectbox/registerFormSelectbox02";
		
	}
	
	// 3) 모델에 Map 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormSelectbox03", method = RequestMethod.GET)
	public String registerFormSelectbox03(Model model) {
		log.info("registerFormSelectbox03()");
		
		Map<String, String> carCodeMap = new HashMap<>();
		carCodeMap.put("01", "Jeep");
		carCodeMap.put("02", "Bmw");
		carCodeMap.put("03", "Audi");
		
		model.addAttribute("carCodeMap", carCodeMap);
		model.addAttribute("member", new Member());
		
		return "form/selectbox/registerFormSelectbox03";
	}
	
	// 4) 모델에 CodeLabelValue 타입의 요소를 가지는 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormSelectbox04", method = RequestMethod.GET)
	public String registerFormSelectbox04(Model model) {
		log.info("registerFormSelectbox04()");
		
		List<CodeLabelValue> carCodeList = new ArrayList<>();
		carCodeList.add(new CodeLabelValue("Jeep", "01"));
		carCodeList.add(new CodeLabelValue("Bmw", "02"));
		carCodeList.add(new CodeLabelValue("Audi", "03"));
		
		model.addAttribute("carCodeList", carCodeList);
		model.addAttribute("member", new Member());
		
		return "form/selectbox/registerFormSelectbox04";
	}
	
	// 4) 모델에 CodeLabelValue 타입의 요소를 가지는 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormSelectbox05", method = RequestMethod.GET)
	public String registerFormSelectbox05(Model model) {
		log.info("registerFormSelectbox05()");
		
		List<CodeLabelValue> carCodeList = new ArrayList<>();
		carCodeList.add(new CodeLabelValue("Jeep", "01"));
		carCodeList.add(new CodeLabelValue("Bmw", "02"));
		carCodeList.add(new CodeLabelValue("Audi", "03"));
		
		model.addAttribute("carCodeList", carCodeList);
		model.addAttribute("member", new Member());
		
		return "form/selectbox/registerFormSelectbox05";
	}
	
	
	// 결과1
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String registerFormSelectboxResult(Member member, Model model) {
		log.info("registerFormSelectboxResult()");
		log.info("member.getNationality() : " + member.getNationality());
		
		model.addAttribute("nationality", member.getNationality());
		return "form/selectbox/result";
		
	}
	
	// 결과2
	@RequestMapping(value = "/result2", method = RequestMethod.POST)
	public String registerFormSelectboxResult2(Member member, Model model) {
		log.info("registerFormSelectboxResult2()");
		
		List<String> carList = member.getCarList();
		
		if (carList != null) {
			log.info("carList != null : " + carList.size());
			
			for (int i = 0; i < carList.size(); i++) {
				log.info("carList("+i+") : " + carList.get(i));
			}
		}else {
			log.info("carList == null");
		}
		
		model.addAttribute("carList", carList);
		return "form/selectbox/result2";
		
	}
	
	
	
	
	
}
