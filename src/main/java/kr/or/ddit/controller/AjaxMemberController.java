package kr.or.ddit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Address;
import kr.or.ddit.vo.Card;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ajax")
public class AjaxMemberController {

	/*
	 * 9. Ajax 방식 요청 처리
	 */
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String ajaxRegisterForm() {
		log.info("ajaxRegisterForm()");

		return "member/ajaxRegisterForm";
	}

	// 1) URL 경로 상의 경로 변수값을 @PathVariable 어노테이션을 지정하여 문자열 매개변수로 처리한다.
	@RequestMapping(value = "/register/{userId}", method = RequestMethod.GET)
	public ResponseEntity<String> ajaxRegister01(@PathVariable("userId") String userId) {
		log.info("Ajax 방식 요청 처리");
		log.info("ajaxRegister01()");
		log.info("userId : " + userId);

		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		return entity;
	}

	// 2) URL 경로 상의 여러개의 경로 변수값을 @PathVariable 어노테이션을 지정하여 문자열 매개변수로 처리한다.
	@RequestMapping(value = "/register/{userId}/{password}", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister02(@PathVariable("userId") String userId,
			@PathVariable("password") String password) {

		log.info("Ajax 방식 요청 처리");
		log.info("ajaxRegister02()");
		log.info("userId : " + userId);
		log.info("password : " + password);

		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 3) 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/register03", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister03(@RequestBody Member member) {
		log.info("Ajax 방식 요청 처리");
		log.info("ajaxRegister03()");
		log.info("userId : " + member.getUserId());
		log.info("password : " + member.getPassword());

		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 4) 객체 타입의 JSON 요청 데이터는 문자열 매개변수로 처리할 수 없다.
	@RequestMapping(value = "/register04", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister04(String userId) {
		// 요청 본몬에서 데이터가 바인딩 되지 않아 userId가 null이 출력된다.
		// 요청 본문에서 데이터를 가져오려면 무조건 @RequestBody 어노테이션이 필요하다.
		log.info("Ajax 방식 요청 처리");
		log.info("ajaxRegister04()");
		log.info("userId : " + userId);

		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 5) 요청 URL에 쿼리파라미터를 붙여서 전달하면 문자열 매개변수로 처리한다.
	@RequestMapping(value = "/register05", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister05(String userId, String password) {
		log.info("Ajax 방식 요청 처리");
		log.info("ajaxRegister05()");
		log.info("userId : " + userId);
		log.info("password : " + password);

		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

//	 6) 객체 타입의 JSON 요청 데이터를 @PathVariable 어노테이션을 지정한 문자열 매개변수와 
//		@RequestBody 어노테이션을 지정한 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/register06/{userId}", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister06(@PathVariable("userId") String userId, @RequestBody Member member) {
		log.info("Ajax 방식 요청 처리");
		log.info("ajaxRegister06()");
		log.info("userId : " + userId);
		log.info("userId : " + member.getUserId());
		log.info("password : " + member.getPassword());

		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 7) 객체 배열 타입의 JSON 요청 데이터를 자바빈즈 요소를 가진 리스트 컬렉션 매개변수에 @RequestBody 어노테이션을 지정하여
	// 처리한다.
	@RequestMapping(value = "/register07", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister07(@RequestBody List<Member> memberList) {
		log.info("Ajax 방식 요청 처리");
		log.info("ajaxRegister07()");

		for (int i = 0; i < memberList.size(); i++) {
			log.info("userId : " + memberList.get(i).getUserId());
			log.info("password : " + memberList.get(i).getPassword());
		}

		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 8) 중첩된 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/register08", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister08(@RequestBody Member member) {
		log.info("Ajax 방식 요청 처리");
		log.info("ajaxRegister08()");

		log.info("userId : " + member.getUserId());
		log.info("password : " + member.getPassword());
		
		Address address = member.getAddress();
		
		if(address != null) {
			log.info("address.postCode : " + address.getPostCode());
			log.info("address.location : " + address.getLocation());
		}else {
			log.info("address : null ");
		}

		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	//9) 중첩된 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/register09", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister09(@RequestBody Member member) {
		log.info("Ajax 방식 요청 처리");
		log.info("ajaxRegister09()");
		
		log.info("userId : " + member.getUserId());
		log.info("password : " + member.getPassword());
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			log.info("cardList Size : " + cardList.size());
			
			for (int i = 0; i < cardList.size(); i++) {
				Card card = cardList.get(i);
				log.info("card.no : " + card.getNo());
				log.info("card.validMonth : " + card.getValidMonth());
			}
		}else {
			log.info("cardList : null");
		}
		
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
