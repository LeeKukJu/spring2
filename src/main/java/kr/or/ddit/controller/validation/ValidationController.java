package kr.or.ddit.controller.validation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Address;
import kr.or.ddit.vo.Card;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/validation")
public class ValidationController {
	/*
	 * 	9장 입력 유효성 검증
	 * 	
	 * 	1. 입력값 검중
	 * 	- 스프링 MVC는 Bean Validation 기능을 이용해 요청 파라미터 값이 바인딩 된 도메인 클래스(또는 커멘드 클래스)의 입력값 검증을 한다.
	 * 
	 * 		[환경설정]
	 * 		# 의존 관계 정의
	 * 		- 입력값 검증을 위한 의존 라이브러리를 추가한다.
	 * 		- pom.xml에서 hiberate-validator 추가
	 * 
	 * 		# 입력값 검증 활성화
	 * 		- Member 클래스의 userId, userName 필드에 규칙을 활성화한다.
	 * 		- 입력값 검증을 하기 위해서는 메소드 매개변수에 도메인 클래스를 정의하고 @Validated를 지정한다.
	 * 			입력값 검증 대상의 도메인 클래스 직후 BindingResult를 정의한다.
	 * 			BindingResult에는 요청 데이터의 바인딩 오류와 입력값 검증 오류 정보가 저장된다.
	 *	 	
	 */
	
	// Validation 테스트를 위한 폼 페이지
	@RequestMapping(value = "/registerValidationForm01", method = RequestMethod.GET)
	public String registerValidationForm01(Model model) {
		log.info("registerValidationForm01()");
		model.addAttribute("member", new Member());
		
		return "validation/registerValidationForm01";
	}
	
	// 1) 테스트 하기 위한 폼 페이지에서 등록 요청을 했을때 정상적인 데이터 전송 시, 해당 컨트롤러 메소드에서 처리
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String registerValidatedForm01Process(@Validated Member member, BindingResult result) {
		log.info("registerValidatedForm01Process()");
		
		if(result.hasErrors()) {
			return "validation/registerValidationForm01";
		}
		
		log.info("userId : " + member.getUserId());
		log.info("password : " + member.getPassword());
		log.info("userName : " + member.getUserName());
		log.info("gender : " + member.getGender());
		log.info("email : " + member.getEmail());
		
		return "validation/success";
	}
	
	/*
	 * 	2. 입력값 검증 결과
	 * 	- 입력값 검증 대상의 도메인 클래스 직후에 BindingResult를 정의한다.
	 * 
	 * 		# BindingResult에는 데이터의 바인딩 에러와 입력값 검증 에러 정보가 저장된다.
	 * 		
	 * 		1) 에러 정보 확인을 위한 BindingResult 메서드
	 * 
	 * 		hasError()
	 * 			- 에러가 발생한 경우 true를 반환한다.
	 * 		hasGlobalErrors()
	 * 			- 객체 레벨의 에러가 발생한 경우 true를 반환한다.
	 * 		hasFieldErrors()
	 * 			- 필드 레벨의 에러가 발생한 경우 true를 반환한다.
	 * 		hasFieldError(String)
	 * 			- 인수에 지정한 필드에서 에러가 발생한 경우 true를 반환한다.
	 */
	
	// 1) 입력값 검증 대상의 도메인 클래스 직후에 BindingResult를 정의한다.
	@RequestMapping(value = "/registerValidationForm02", method = RequestMethod.GET)
	public String registerValidationForm02(Model model) {
		log.info("registerValidationForm02()");
		model.addAttribute("member", new Member());
		
		return "validation/registerValidationForm02";
	}
	
	// 결과2
	@RequestMapping(value = "/result2", method = RequestMethod.POST)
	public String registerValidationForm02Process(@Validated Member member, BindingResult result) {
		log.info("registerValidationForm02Process()");
		// 입력값 검증 에러가 발생한 경우 true를 반환한다.
		log.info("result.hasError() : " + result.hasErrors());
		
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();
			
			log.info("allErrors Size : " + allErrors.size());
			log.info("globalErrors Size : " + globalErrors.size());
			log.info("fieldErrors Size : " + fieldErrors.size());
			
			for (int i = 0; i < allErrors.size(); i++) {
				ObjectError objectError = allErrors.get(i);
				log.info("allError : " + objectError);
			}
			for (int i = 0; i < globalErrors.size(); i++) {
				ObjectError objectError = globalErrors.get(i);
				log.info("globalErrors : " + objectError);
			}
			for (int i = 0; i < fieldErrors.size(); i++) {
				FieldError fieldError = fieldErrors.get(i);
				log.info("fieldErrors : " + fieldError);
				log.info("fieldError.getDefaultMessage() : " + fieldError.getDefaultMessage());
			}
			return "validation/registerValidationForm02";
		}
		log.info("userId : " + member.getUserId());
		log.info("userName : " + member.getUserName());
		log.info("email : " + member.getEmail());
		log.info("dateOfBirth : " + member.getDateOfBirth());
		log.info("gender : " + member.getGender());
		
		return "validation/success";
	}
	
	/*
	 * 	3. 입력값 검증 규칭
	 * 	- 입력값 검증 규칙은 Bean Validation이 제공하는 제약 어노테이션으로 설정한다.
	 * 
	 * 		검사 규칙은 크게 다음 세가지로 분류할 수 있다.
	 * 		- Bean Validation 표준 제약 어노테이션
	 * 		- 서드파티에서 구현한 제약 어노테이션
	 * 		- 직접 구현한 제약 어노테이션
	 * 
	 * 		1) Member 클래스에서 테스트위한 어노테이션으로 설정
	 * 		@NotNull				: 빈 값이 아닌지를 검사한다.
	 * 		@Null					: null인지를 검사한다.
	 * 		@NotBlank				: 문자열이 null이 아니고 trim한 길이가 0보다 크다는 것을 검사한다.
	 * 		@NotEmpty				: 문자열이 null이거나 비어있는지 검사한다.
	 * 		@Size					: 글자 수나 컬렉션의 요소 개수를 검사한다.
	 * 			> @Size(max=, min=)
	 * 		@Max(value=)			: value보다 작거나 같은걸 검사한다.
	 * 		@Min(value=) 			: value보다 크거나 같은걸 검사한다.
	 * 		@Email					: 이메일 주소 형식인지를 검사한다.
	 * 		@past					: 과거 날짜인지를 검사한다.
	 * 		@Future					: 미래 날짜인지를 검사한다.
	 * 		@Pattern(regexp=)		: CharSequence는 지정된 정규식과 일치해야 하고, 정규식은 Java 정규식 규칙을 따른다.
	 * 		@Positive				: 양수이어야합니다. (0은 에러)
	 * 		@PositiveOrZero			: 양수 또는 0이어야합니다.
	 * 		@Length(min=,max=)		: 문자열의 길이가 min과 max사이인지를 확인한다.
	 * 
	 * 		[테스트]
	 * 		- Member 클래스의 검증 활성화를 추가한다.
	 * 			> userId, password, userName, email, dateOfbirth
	 * 		- /validation/registerValidationForm02 URL로 요청해서 시나리오 테스트 진행! 
	 */
	
	
	/*
	 * 	4. 중첩된 자바빈즈 입력값 검증
	 * 	- 중첩된 자바빈즈와 자바빈즈의 컬렉션에서 정의한 프로퍼티에 대해 입력값 검증을 할 때는 @Valid를 지정한다.
	 * 
	 * 		1) 중첩된 자바빈즈 클래스를 정의하고 @Valid를 지정한다.
	 * 		- Member 클래스 내 Address 필드에 @Valid를 지정
	 * 		- Member 클래스 내 List<Card> 필드에 @Valid를 지정
	 * 
	 * 		2) @Valid가 설정된 필드 내 클래스에도 validation 규칙을 설정한다.
	 */
	
	@RequestMapping(value = "/registerValidationForm03", method = RequestMethod.GET)
	public String registerValidationForm03(Model model) {
		log.info("registerValidationForm03()");
		model.addAttribute("member", new Member());
		
		return "validation/registerValidationForm03";
	}
	
	
	// 결과3
	@RequestMapping(value = "/result3", method = RequestMethod.POST)
	public String registerValidationResult3(@Validated Member member, BindingResult result) {
		log.info("registerValidationResult3()");
		
		if(result.hasErrors()) {
			return "validation/registerValidationForm03";
		}
		
		log.info("userId : " + member.getUserId());
		log.info("dateOfBirth : " + member.getDateOfBirth());
		
		Address address = member.getAddress();
		if(address != null) {
			log.info("address != null address.postCode : " + address.getPostCode());
			log.info("address != null address.location : " + address.getLocation());
		}else {
			log.info("address == null");
		}
		
		List<Card> cardList = member.getCardList();
		if(cardList != null) {
			log.info("cardList != null : " + cardList.size());
			
			for (int i = 0; i < cardList.size(); i++) {
				Card card = cardList.get(i);
				log.info("card.no : " + card.getNo());
				log.info("card.validMonth : " + card.getValidMonth());
			}
		}else {
			log.info("cardList == null");
		}
		
		// 이미 만들어져 있는 등록 완료 페이지로 이동
		return "validation/success";
	}
	
	
	
	
	
	
	
	
}
