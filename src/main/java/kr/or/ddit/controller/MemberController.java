package kr.or.ddit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.vo.Address;
import kr.or.ddit.vo.FileMember;
import kr.or.ddit.vo.Member;
import kr.or.ddit.vo.MultiFileMember;
import kr.or.ddit.vo.register.AddressVO;
import kr.or.ddit.vo.register.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	/*
	 * 5장 : 컨트롤러 메서드 매개변수
	 * 
	 * 1. 컨트롤러 메서드 매개변수
	 * 
	 * Model - 이동 대상에 전달할 데이터를 가지고 있는 인터페이스 RedirectAttributes - 리다이렉트 대상에 전달할 데이터를
	 * 가지고 있는 인터페이스 자바빈즈 클래스 - 요청 파라미터를 가지고 있는 자바빈즈 클래스 MultipartFile - 멀티파트 요청을 사용해
	 * 업로드된 파일 정보를 가지고 있는 인터페이스 BindingResult - 도메인 클래스의 입력값 검증을 가지고 있는 인터페이스
	 * java.security.Principal - 클라이언트 인증을 위한 사용자 정보를 가지고 있는 인터페이스
	 * 
	 * 2. 요청 처리
	 */

	// 컨트롤러 요청 처리를 위한 페이지(5장 시작점)
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		log.info("요청 처리");
		log.info("registerForm()");
		return "registerForm";
	}

	// 1) URL 경로 상의 쿼리 파라미터 정보로 부터 요청 데이터를 취득할 수 있다.
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerByParameter(String userId, String password) {
		log.info("요청 처리");
		log.info("registerByParameter()");
		log.info("userId : " + userId);
		log.info("password : " + password);
		return "success";
	}

	// 2) URL 경로 상의 경로 변수로 부터 요청 데이터를 취득할 수 있다.
	@RequestMapping(value = "/register/{userId}", method = RequestMethod.GET)
	public String registerByPath(@PathVariable String userId) {
		// userId가 null로 표시된다.
		// 넘겨받은 id를 @PathVariable 사용하지 않고 값을 받는 경우 null이다.
		// 값을 받는 경우엔 @PathVariable을 사용한다.
		log.info("요청 처리");
		log.info("registerByPath()");
		log.info("userId : " + userId);
		return "success";
	}

	// 3) HTML 폼 필드명과 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.
	@RequestMapping(value = "/register01", method = RequestMethod.POST)
	public String register01(String userId) {
		log.info("요청 처리");
		log.info("register01()");
		log.info("userId: " + userId);

		return "success";

	}

	// 4) HTML 폼 필드가 여러 개일 경우에도 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.
	@RequestMapping(value = "/register02", method = RequestMethod.POST)
	public String register02(String userId, String password) {
		log.info("요청 처리");
		log.info("register02()");
		log.info("userId: " + userId);
		log.info("password: " + password);

		return "success";
	}

	// 5) HTML 폼 필드가 여러 개일 경우에 컨트롤러 매개변수의 위치는 상관없다.
	@RequestMapping(value = "/register03", method = RequestMethod.POST)
	public String register03(String password, String userId) {
		log.info("요청 처리");
		log.info("register03()");
		log.info("userId: " + userId);
		log.info("password: " + password);

		return "success";
	}

	// 6) HTML 폼 필드값이 숫자일 경우에는 컨트롤러 매개변수 타입이 문자열이면 그대로 문자열 형태로 요청 데이터를 취득한다.
	@RequestMapping(value = "/register04", method = RequestMethod.POST)
	public String register04(String userId, String password, String coin) {
		log.info("요청 처리");
		log.info("register04()");
		log.info("userId: " + userId);
		log.info("password: " + password);
		log.info("coin: " + coin);

		return "success";
	}

	// 7) HTML 폼 필드값이 숫자일 경우에는 컨트롤러 매개변수 타입이 숫자형이면 숫자로 타입변환하여 요청 데이터를 취득한다
	@RequestMapping(value = "/register05", method = RequestMethod.POST)
	public String register04(String userId, String password, int coin) {
		log.info("요청 처리");
		log.info("register05()");
		log.info("userId: " + userId);
		log.info("password: " + password);
		log.info("coin: " + coin);

		return "success";
	}

	/*
	 * 3. 요청 데이터 처리 어노테이션
	 * 
	 * @PathVariable - URL 경로에서 경로 변수 값을 가져오기 위한 어노테이션
	 * 
	 * @RequestParam - 요청 파라미터 값을 가져오기 위한 어노테이션
	 * 
	 * @RequestHeader - 요청 헤더 값을 가져오기 위한 어노테이션
	 * 
	 * @RequestBody - 요청 본문 내용을 가져오기 위한 어노테이션
	 * 
	 * @CookieValue - 쿠키 값을 가져오기 위한 어노테이션
	 */

	// 1) URL 경로 상의 경로 변수가 여러 개일 때 @PathVariable 어노테이션을 사용하여 특정한 경로 변수명을 지정해준다.
	@RequestMapping(value = "/register/{userId}/{coin}", method = RequestMethod.GET)
	public String registerByPath(@PathVariable("userId") String userId, @PathVariable("coin") int coin) {
		log.info("요청 데이터 처리 어노테이션");
		log.info("registerByPath() - @PathVariable");
		log.info("userId : " + userId);
		log.info("coin : " + coin);

		return "success";
	}

	// 2) HTML 폼 필드명과 컨트롤러 매개변수명이 일치(대소문자 구분)하지 않으면 요청을 처리할 수 없다.
	@RequestMapping(value = "/register0201", method = RequestMethod.POST)
	public String register0201(String username) {
		log.info("요청 데이터 처리 어노테이션");
		log.info("register0201()");
		log.info("username : " + username);

		return "success";
	}

	@RequestMapping(value = "/register0202", method = RequestMethod.POST)
	public String register0202(@RequestParam("userId") String username) {
		log.info("요청 데이터 처리 어노테이션");
		log.info("register0202()");
		log.info("username : " + username);

		return "success";
	}

	/*
	 * 4. 요청 처리 자바빈즈
	 */

	// 1) 폼 텍스프 필드 요소값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/beans/register01", method = RequestMethod.POST)
	public String registerJavaBeans01(Member member) {
		log.info("요청 처리 자바빈즈");
		log.info("registerJavaBeans01()");
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getPassword() : " + member.getPassword());
		log.info("member.getCoin() : " + member.getCoin());

		return "success";
	}

	// 2) 폼 텍스트 필드 요소값을 자바빈즈 매개변수와 기본 데이터 타입인 정수 타입 매개변수로 처리한다. 변수명 같으면 알아서 다 바인딩됌
	@RequestMapping(value = "/beans/register02", method = RequestMethod.POST)
	public String registerJavaBeans02(Member member, int coin) {
		log.info("요청 처리 자바빈즈");
		log.info("registerJavaBeans02()");
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getPassword() : " + member.getPassword());
		log.info("member.getCoin() : " + member.getCoin());
		log.info("coin : " + coin);

		return "success";
	}

	// 3) 여러개의 폼 텍스트 필드 요소값을 매개변수 순서와 상관없이 매개변수명을 기준으로 처리한다.
	@RequestMapping(value = "/beans/register03", method = RequestMethod.POST)
	public String registerJavaBeans03(int uid, Member member) {
		log.info("요청 처리 자바빈즈");
		log.info("registerJavaBeans03()");
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getPassword() : " + member.getPassword());
		log.info("member.getCoin() : " + member.getCoin());
		log.info("uid : " + uid);

		return "success";
	}

	/*
	 * 5. Date 타입 처리 - 스프링MVC는 Date 타입의 데이터를 처리하는 여러 방법을 제공한다.
	 */

	// 1) 쿼리 파라미터(dateOfBirth=1234)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환에 실패한다.
	@RequestMapping(value = "/registerByGet01", method = RequestMethod.GET)
	public String registerByGet01(String userId, Date dateOfBirth) {
		log.info("Date 타입 처리");
		log.info("registerByGet01()");
		log.info("userId : " + userId);
		log.info("dateOfBirth : " + dateOfBirth);

		return "success";
	}

	// 2) Member 매개변수와 쿼리 파라미터(dateOfBirth=20230221)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date
	// 타입으로 변환에 실패한다.
	@RequestMapping(value = "/registerByGet02", method = RequestMethod.GET)
	public String registerByGet02(Member member) {
		log.info("Date 타입 처리");
		log.info("registerByGet02()");
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getDateOfBirth() : " + member.getDateOfBirth());

		return "success";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member) {
		log.info("Date 타입 처리");
		log.info("register");
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getPassword() : " + member.getPassword());
		log.info("member.getDateOfBirth() : " + member.getDateOfBirth());

		return "success";

	}

	/*
	 * 7. 폼 방식 요청 처리
	 */

	// 1) 폼 텍스트 필드 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerUserId", method = RequestMethod.POST)
	public String registerUserId(String userId) {
		log.info("registerUserId()");
		log.info("userId : " + userId);
		return "success";
	}

	// 2) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/registerMemberUserId", method = RequestMethod.POST)
	public String registerMemberUserId(Member member) {
		log.info("registerMemberUserId()");
		log.info("member.getUserId() : " + member.getUserId());
		return "success";
	}

	// 3) 폼 비밀번호 필드 요소값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/registerPassword", method = RequestMethod.POST)
	public String registerPassword(Member member) {
		log.info("registerPassword");
		log.info("member.getPassword() : " + member.getPassword());
		return "success";
	}

	// 4) 폼 라디오버튼 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerRadio", method = RequestMethod.POST)
	public String registerRadio(String gender) {
		log.info("registerRadio");
		log.info("gender : " + gender);
		return "success";
	}

	// 5) 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerSelect", method = RequestMethod.POST)
	public String registerSelect(String nationality) {
		log.info("registerSelect()");
		log.info("nationality : " + nationality);
		return "success";
	}

	// 6) 복수 선택이 가능한 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerMultipleSelect01", method = RequestMethod.POST)
	public String registerMultipleSelect01(String cars) {
		log.info("registerMultipleSelect01()");
		log.info("cars : " + cars);
		return "success";
	}

	// 7) 복수 선택이 가능한 폼 셀렉트 박스 요소값을 문자열 배열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerMultipleSelect02", method = RequestMethod.POST)
	public String registerMultipleSelect02(String[] carArray) {
		log.info("registerMultipleSelect02()");

		if (carArray != null) {
			log.info("carArray.length : " + carArray.length);
			for (int i = 0; i < carArray.length; i++) {
				log.info("carArray[" + i + "] : " + carArray[i]);
			}
		} else {
			log.info("carArray : null");
		}

		return "success";
	}

	// 8) 복수 선택이 가능한 폼 셀렉트 박스 요소값을 문자열 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerMultipleSelect03", method = RequestMethod.POST)
	public String registerMultipleSelect03(ArrayList<String> carList) {
		log.info("registerMultipleSelect03()");

		// 리스트로는 셀렉트 박스 값을 가져올 수 없다.
		// 배열 형태를 이용하여 받아오거나 String 타입으로 값을 받아온다.
		if (carList != null && carList.size() > 0) {
			log.info("carList.length : " + carList.size());
			for (int i = 0; i < carList.size(); i++) {
				log.info("carList[" + i + "] : " + carList.get(i));
			}
		} else {
			log.info("carList : null");
		}

		return "success";
	}

	// 9)
	@RequestMapping(value = "/registerCheckbox01", method = RequestMethod.POST)
	public String registerCheckbox01(String hobby) {
		log.info("registerCheckbox01()");
		log.info("hobby : " + hobby);
		return "success";
	}

	// 10)
	@RequestMapping(value = "/registerCheckbox02", method = RequestMethod.POST)
	public String registerCheckbox02(String[] hobbyArray) {
		log.info("registerCheckbox02()");

		if (hobbyArray != null) {
			log.info("hobbyArray.length : " + hobbyArray.length);
			for (int i = 0; i < hobbyArray.length; i++) {
				log.info("hobbyArray[" + i + "] : " + hobbyArray[i]);
			}
		} else {
			log.info("hobbyArray : null");
		}

		return "success";
	}

	// 11)
	@RequestMapping(value = "/registerCheckbox03", method = RequestMethod.POST)
	public String registerCheckbox03(ArrayList<String> hobbyList) {
		log.info("registerCheckbox03()");

		// List로 가져오게 되면, 이때 List는 인터페이스 List인 경우
		// No primary or default constructor found for interface java.util.List 에러가
		// 발생한다.
		// Spring에서는 List로는 데이터를 받는게 되지 않는다.
		// 리스트와 같은 형태의 값을 받으려면 String[]로 여러 데이터를 받아서 List에 담는 방법이 있다.
		if (hobbyList != null && hobbyList.size() > 0) {
			log.info("hobbyArray.length : " + hobbyList.size());
			for (int i = 0; i < hobbyList.size(); i++) {
				log.info("hobbyList[" + i + "] : " + hobbyList.get(i));
			}
		} else {
			log.info("hobbyList : null");
		}

		return "success";
	}

	// 12) 폼 체크박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerCheckbox04", method = RequestMethod.POST)
	public String registerCheckbox04(String developer) {
		log.info("registerCheckbox04()");
		log.info("developer : " + developer);
		return "success";
	}

	// 13) 폼 체크박스 요소값을 기본 데이터 타입인 불리언 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerCheckbox05", method = RequestMethod.POST)
	public String registerCheckbox05(boolean foreigner) {
		log.info("registerCheckbox05()");
		log.info("foreigner : " + foreigner);
		return "success";
	}

	// 14) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/registerAddress", method = RequestMethod.POST)
	public String registerAddress(Address address) {
		log.info("registerAddress()");

		if (address != null) {
			log.info("address.getPostCode : " + address.getPostCode());
			log.info("address.getLocation : " + address.getLocation());
		} else {
			log.info("address : null");
		}
		return "success";
	}

	// 15) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/registerUserAddress", method = RequestMethod.POST)
	public String registerUserAddress(Member member) {
		log.info("registerUserAddress()");

		Address address = member.getAddress();

		if (member != null) {
			log.info("address.getPostCode : " + address.getPostCode());
			log.info("address.getLocation : " + address.getLocation());
		} else {
			log.info("address : null");
		}
		return "success";
	}

	// 총 정리
	@RequestMapping(value = "/registerAllForm", method = RequestMethod.GET)
	public String registerAllForm() {
		log.info("registerAllForm()");
		return "registerAllForm";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(MemberVO memberVO) {
		// log.info(); 이용해서 memberVO 안에 들어있는 모든 내용을 출력하시오

//		 유저 ID:
		log.info("유저ID : " + memberVO.getUserId());
//		 패스워드:
		log.info("패스워드 : " + memberVO.getPassword());
//		 이름:
		log.info("이름 : " + memberVO.getUserName());
//		 E-Mail:
		log.info("E-Mail : " + memberVO.getEmail());
//		 생년월일 : 2034-02-21 형식으로
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String dateOfBirth = simpleDateFormat.format(memberVO.getDateOfBirth());
		log.info("생년월일 : " + dateOfBirth);
//		 성별:
		log.info("성별 : " + memberVO.getGender());
//		 개발자 여부 : 개발자인 경우 '개발자', 아닌경우 '비개발자'
		if (memberVO.getDeveloper() != null && memberVO.getDeveloper().equals("Y")) {
			log.info("개발자 여부 : 개발자");
		} else {
			log.info("개발자 여부 : 비개발자");
		}
//		 외국인 여부 : 외국인인 경우 '외국인', 아닌 경우 '내국인'
		if (memberVO.isForeigner()) {
			log.info("외국인 여부 : 외국인");
		} else {
			log.info("외국인 여부 : 내국인");
		}
//		 국적 : 
		log.info("국적 : " + memberVO.getNationality());
//		 소유차량 : 1개 이상 선택 가능
		String car = "";
		if(memberVO.getCars() != null) {
			for (int i = 0; i < memberVO.getCars().length; i++) {
				car += memberVO.getCars()[i] + " ";
			}
			log.info("소유차량 : " + car);
		}else {
			log.info("소유차량 : null");
		}
//		 취미 : 1개이상 선택가능
		String hobby = "";
		if(memberVO.getHobby() != null) {
			for (int i = 0; i < memberVO.getHobby().length; i++) {
				hobby += memberVO.getHobby()[i] + " ";
			}
			log.info("취미 : " + hobby);
		}else {
			log.info("취미 : null");
		}
//		 우편번호 :
		AddressVO address = memberVO.getAddress();
		log.info("우편번호 : " + address.getPostCode());
//		 주소 :
		log.info("주소 : " + address.getLocation());
//		 소개 :
		log.info("소개 : " + memberVO.getIntroduction());
		
		return "success";
	}
	
	
	
	
	/*
	 * 	8. 파일업로드 폼 방식 요청 처리
	 * 	- 파일 업로드 폼 방식 요청 처리를 작성하기 전, 준비사항
	 * 
	 * 	[환경설정] 의존 관계 정의
	 * 	- commons-io, commons-fileupload 라이브러리 의존 관계 등록
	 * 	- web.xml에 모든 경로에 대한 MultipartFilter를 등록합니다.
	 * 
	 * 	### 위 설정을 진행하였는데도 에러가 나는 경우 조치방법!!!!!!
	 * 	- servers > context.xml에서 context 태그 내 해당 옵션 추가한다.
	 * 	::: alloewCasualMultipartParsing="true" path="/"
	 * 
	 * 	### 파일 업로드가 에러 나는 경우 조치 방법
	 * 	1. 클린! 클린!!!! 클린!!!!!!!!!!
	 * 	2. 파일 업로드에 필요한 라이브러리가 추가되었는지 pom.xml에서 확인
	 * 	3. web.xml에 multipartFilter가 등록되었는지 확인
	 * 	4. servers > Context 태그 내, 옵션이 부여되었는지 확인
	 * 
	 */
	
	// 1) 파일 업로드 폼 파일 요소값을 스프링 MVC가 지원하는 MultipartFile 매개변수로 처리한다.
	@RequestMapping(value = "/registerFile01", method = RequestMethod.POST)
	public String registerFile01(MultipartFile picture) throws Exception {
		log.info("파일업로드 폼 방식 요청 처리");
		log.info("registerFile01()");
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("file Size : " + picture.getSize());
		log.info("ContentType : " + picture.getContentType());
		return "success";
	}
	
	// 2) 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 매개변수와 문자열 매개변수로 처리한다.
	@RequestMapping(value = "/registerFile02", method = RequestMethod.POST)
	public String registerFile02(String userId, String password, MultipartFile picture) throws Exception {
		log.info("파일업로드 폼 방식 요청 처리");
		log.info("registerFile02()");
		log.info("userId : " + userId);
		log.info("password : " + password);
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("file Size : " + picture.getSize());
		log.info("ContentType : " + picture.getContentType());
		return "success";
	}
	
	// 3) 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 매개변수와 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/registerFile03", method = RequestMethod.POST)
	public String registerFile03(Member member, MultipartFile picture ) throws Exception {
		log.info("파일업로드 폼 방식 요청 처리");
		log.info("registerFile03()");
		log.info("userId : " + member.getUserId());
		log.info("password : " + member.getPassword());
		
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("file Size : " + picture.getSize());
		log.info("ContentType : " + picture.getContentType());
		return "success";
	}
	
	// 4) 파일 업로드 폼 파일 요소값과 텍스트 요소값을 FileMember 타입의 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/registerFile04", method = RequestMethod.POST)
	public String registerFile04(FileMember fileMember) throws Exception {
		log.info("파일업로드 폼 방식 요청 처리");
		log.info("registerFile04()");
		log.info("userId : " + fileMember.getUserId());
		log.info("password : " + fileMember.getPassword());
		
		MultipartFile picture = fileMember.getPicture();
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("file Size : " + picture.getSize());
		log.info("ContentType : " + picture.getContentType());
		return "success";
	}
	
	// 5) 여러 개의 파일업로드를 폼 파일 요소값을 여러 개의 MultipartFile 매개변수로 처리한다.
	@RequestMapping(value = "/registerFile05", method = RequestMethod.POST)
	public String registerFile05(String userId, String password, MultipartFile picture, MultipartFile picture2) throws Exception {
		log.info("파일업로드 폼 방식 요청 처리");
		log.info("registerFile05()");
		log.info("userId : " + userId);
		log.info("password : " + password);
		
		log.info("originalName1 : " + picture.getOriginalFilename());
		log.info("file Size1 : " + picture.getSize());
		log.info("ContentType1 : " + picture.getContentType());
		
		log.info("originalName2 : " + picture2.getOriginalFilename());
		log.info("file Size2 : " + picture2.getSize());
		log.info("ContentType2 : " + picture2.getContentType());
		
		return "success";
	}
	
	
	// 6) 여러 개의 파일업로드를 폼 파일 요소값을 MultipartFile 타입의 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.
	// List로는 데이터를 받을 수 없다.
	@RequestMapping(value = "/registerFile06", method = RequestMethod.POST)
	public String registerFile06(List<MultipartFile> pictureList, String userId, String password) throws Exception {
		log.info("파일업로드 폼 방식 요청 처리");
		log.info("registerFile06()");
		log.info("userId : " + userId);
		log.info("password : " + password);
		
		for (int i = 0; i < pictureList.size(); i++) {
			log.info("originalName1 : " + pictureList.get(i).getOriginalFilename());
			log.info("file Size1 : " + pictureList.get(i).getSize());
			log.info("ContentType1 : " + pictureList.get(i).getContentType());
		}
		
		return "success";
	}
	
	// 7) 여러 개의 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultiFileMember 타입의 자바빈즈 클래스 매개변수로 처리한다.
	// ★이 방식으로는 List 들어옴!!!
	// 7-2) 방식으로 multiple로 받아서도 사용 가능!!!
	@RequestMapping(value = "/registerFile07", method = RequestMethod.POST)
	public String registerFile07(MultiFileMember multiFileMember) throws Exception {
		log.info("파일업로드 폼 방식 요청 처리");
		log.info("registerFile07()");
		
		List<MultipartFile> pictureList = multiFileMember.getPictureList();
		log.info("pictureList size : " + pictureList.size());
		
		for (int i = 0; i < pictureList.size(); i++) {
			log.info("originalName : " + pictureList.get(i).getOriginalFilename());
			log.info("file Size : " + pictureList.get(i).getSize());
			log.info("ContentType : " + pictureList.get(i).getContentType());
		}
		
		
		return "success";
	}
	
	// 8) 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 타입의 배열 매개변수로 처리한다.
	@RequestMapping(value = "/registerFile08", method = RequestMethod.POST)
	public String registerFile08(MultipartFile[] pictureList) throws Exception {
		log.info("파일업로드 폼 방식 요청 처리");
		log.info("registerFile08()");
		
		for (MultipartFile picture : pictureList) {
			log.info("picture originalName : " + picture.getOriginalFilename());
			log.info("picture Size : " + picture.getSize());
			log.info("picture ContentType : " + picture.getContentType());
		}
		
		return "success";
	}
	

}
