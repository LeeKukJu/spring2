package kr.or.ddit.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Address;
import kr.or.ddit.vo.Card;
import kr.or.ddit.vo.Member;
import kr.or.ddit.vo.register.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ModelMemberController {

	/*
	 * 6장: 데이터 전달자 모델
	 * 
	 * 1. 모델 객체 - Model 객체는 뷰(View)에 컨트롤러에서 생성된 데이터를 담아서 전달하는 역할을 한다.
	 */

	// 매개변수에 선언된 Model 객체의 addAttribute() 메서드를 호출하여 데이터를 뷰(View)에 전달한다.
	@RequestMapping(value = "/read01", method = RequestMethod.GET)
	public String read01(Model model) {
		log.info("read01()");

		model.addAttribute("userId", "a001");
		model.addAttribute("password", "1234");
		model.addAttribute("email", "aaa@ccc.com");
		model.addAttribute("birthDay", "1888-8-8");

		return "member/read01";

	}

	// Model 객체에 자바빈즈 클래스 객체를 값으로만 전달할 때는 뷰에서 참조할 이름을 getter에서 get을 없애고 클래스명의 앞글자를
	// 소문자로 변환하여 처리한다.
	@RequestMapping(value = "/read02", method = RequestMethod.GET)
	public String read02(Model model) {
		log.info("read02()");

		Member member = new Member();
		member.setUserId("a001");
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("hongkd");
		member.setBirthDay("1999-9-9");

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DAY_OF_MONTH, 8);

		member.setDateOfBirth(cal.getTime());

		model.addAttribute(member);
		return "member/read02";
	}

	// Model 객체에 자바빈즈 클래스 객체를 특정한 이름을 지정하여 전달할 수 있다.
	@RequestMapping(value = "/read03", method = RequestMethod.GET)
	public String read03(Model model) {
		log.info("read03()");

		Member member = new Member();
		member.setUserId("a001");
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("hongkd");
		member.setBirthDay("1999-9-9");

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DAY_OF_MONTH, 8);

		member.setDateOfBirth(cal.getTime());

		model.addAttribute("user", member);
		return "member/read03";
	}
	
	// Model 객체를 통해 배열과 컬렉션 객체를 전달할 수 있다.
	@RequestMapping(value = "/read04", method = RequestMethod.GET)
	public String read04(Model model) {
		log.info("read04");
		
		String[] carArray = {"bmw", "jeep"};
		
		List<String> carList = new ArrayList<>();
		carList.add("bmw");
		carList.add("jeep");
		
		String[] hobbyArray = {"Music", "Movie"};
		
		List<String> hobbyList = new ArrayList<>();
		hobbyList.add("Music");
		hobbyList.add("Movie");
		
		model.addAttribute("carArray", carArray);
		model.addAttribute("carList", carList);
		model.addAttribute("hobbyArray", hobbyArray);
		model.addAttribute("hobbyList", hobbyList);
		
		return "member/read04";
	}
	
	// Model 객체를 통해 중첩된 자바빈즈 클래스 객체를 전달할 수 있다.
	@RequestMapping(value = "/read05", method = RequestMethod.GET)
	public String read05(Model model) {
		log.info("read05");
		
		Member member = new Member();
		
		Address address = new Address();
		address.setPostCode("080988");
		address.setLocation("Seoul");
		
		member. setAddress(address);
		
		List<Card> cardList = new ArrayList<>();
		Card card1 = new Card();
		card1.setNo("123456");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DAY_OF_MONTH, 8);
		card1.setValidMonth(cal.getTime());
		cardList.add(card1);
		
		Card card2 = new Card();
		card2.setNo("67890");
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DAY_OF_MONTH, 8);
		card2.setValidMonth(cal.getTime());
		cardList.add(card2);
		
		member.setCardList(cardList);
		
		model.addAttribute("user", member);
		
		return "member/read05";
	}
	
	@RequestMapping(value = "/read06", method = RequestMethod.GET)
	public String read06(Model model) {
		log.info("read06");
		
		Member member = new Member();
		member.setUserId("a001");
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("hongkd");
		member.setBirthDay("2023-02-22");
		member.setGender("male");
		member.setDeveloper("Y");
		member.setForeigner(false);
		member.setNationality("korea");
		member.setCars("jeep");
		
		String[] carArray = {"jeep", "bmw"};
		member.setCarArray(carArray);
		
		List<String> carList = new ArrayList<>();
		carList.add("jeep");
		carList.add("bmw");
		member.setCarList(carList);
		
		member.setHobby("Music");
		
		String[] hobbyArray = {"Music", "Moive"};
		member.setHobbyArray(hobbyArray);
		
		List<String> hobbyList = new ArrayList<>();
		hobbyList.add("Music");
		hobbyList.add("Moive");
		member.setHobbyList(hobbyList);
		
		Address address = new Address();
		address.setPostCode("080988");
		address.setLocation("Daejeon");
		member.setAddress(address);
		
		List<Card> cardList = new ArrayList<>();
		Card card1 = new Card();
		card1.setNo("1234");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DAY_OF_MONTH, 22);
		card1.setValidMonth(cal.getTime());
		cardList.add(card1);
		
		Card card2 = new Card();
		card2.setNo("5678");
		
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DAY_OF_MONTH, 12);
		card1.setValidMonth(cal.getTime());
		cardList.add(card2);
		
		member.setCardList(cardList);
		
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DAY_OF_MONTH, 22);
		
		member.setDateOfBirth(cal.getTime());
		String introduction = "안녕하세요! \n 반갑습니다.!";
		member.setIntroduction(introduction);
		model.addAttribute("user", member);
		return "member/read06";
				
		
		
		
	}
	
	
}
