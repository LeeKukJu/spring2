package kr.or.ddit;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.vo.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// http 매핑을 요청할 formHome 페이지
	@RequestMapping(value = "/formHome", method = RequestMethod.GET)
	public String forHome() {
		logger.info("formHome()");
		return "formHome";
	}

	// headers 매핑을 요청할 ajaxHome 페이지
	@RequestMapping(value = "/ajaxHome", method = RequestMethod.GET)
	public String ajaxHome() {
		logger.info("ajaxHome()");
		return "ajaxHome";
	}
	
	/*
	 * 4장. 컨트롤러 응답
	 * 
	 * 1. void 타입
	 * - 호출 하는 URL과 동일한 뷰 이름을 나타내기 위해 사용한다.
	 */
	
	// 요청 경로 (/goHome0101)와 동일한 뷰(/goHome0101.jsp)를 가리킨다.
	@RequestMapping(value = "/goHome0101", method = RequestMethod.GET)
	public void home0101() {
		logger.info("void 타입");
		logger.info("home0101()");
	}
	
	// 요청 경로 (/sub/goHome0102)와 동일한 뷰(/sub/goHome0102.jsp)를 가리킨다.
	@RequestMapping(value = "/sub/goHome0102", method = RequestMethod.GET)
	public void home0102() {
		logger.info("void 타입");
		logger.info("home0102()");
		
		// return 이 없는 경우 요청된 url을 기반으로 jsp페이지를 찾아간다.
		// 하지만, sub/goHome0102 페이지가 존재하지 않는 경우 404에러가 발생한다.
	}
	
	/*
	 * 	2. String 타입
	 * 	- 뷰 파일의 경로와 파일 이름을 나타내기 위해 사용한다.
	 */
	
	// 반환값이 "home0201" 이므로 뷰(/home0201.jsp)를 가리킨다
	@RequestMapping(value = "/goHome0201", method = RequestMethod.GET)
	public String home0201() {
		logger.info("String 타입");
		logger.info("home0202()");
		return "home0201";
	}
	
	// 반환값이 "home0202" 이므로 뷰(/home0202.jsp)를 가리킨다
	@RequestMapping(value = "/sub/goHome0202", method = RequestMethod.GET)
	public String home0202() {
		logger.info("String 타입");
		logger.info("home0202()");
		return "home0202";
	}
	
	// 반환값이 "sub/home0203" 이므로 뷰(/sub/home0203.jsp)를 가리킨다
	@RequestMapping(value = "/sub/goHome0203", method = RequestMethod.GET)
	public String home0203() {
		logger.info("String 타입");
		logger.info("home0203()");
		return "sub/home0203";
	}
	
	@RequestMapping(value = "/goHome0204", method = RequestMethod.GET)
	public String home0204() {
		logger.info("String 타입");
		logger.info("home0204");
		return "redirect:/sub/home0205";
	}
	
	// '/'로 시작하면 웹 애플리케이션의 컨텍스트 경로에 영향을 받지 않는 절대경로를 의미한다.
	// 해당경로 : D:\99.Class\02.Spring2\workspace_spring2\.metadata\.plugins\
	// org.eclipse.wst.server.core\temp0\....\DevProject\WEB-INF\views\sub\home0205.jsp
	@RequestMapping(value = "/sub/goHome0205", method = RequestMethod.GET)
	public String home0205() {
		logger.info("String 타입");
		logger.info("home0205");
		return "/sub/home0205";
	}
	
	/*
	 * 	3. 자바빈즈 클래스 타입
	 * 	- JSON 객체 타입의 데이터를 만들어서 반환하는 용도로 사용한다.
	 */
	
	// 반환값이 객체 타입인 경우, JSON 타입으로 자동으로 변환된다.
	// 자바빈즈 객체를 리턴할 때, @ResponseBody 어노테이션을 지정하지 않는 경우 HTTP 404 에러가 발생한다.
	@ResponseBody
	@RequestMapping(value = "/goHome0301", method = RequestMethod.GET)
	public Member home0301() {
		logger.info("자바빈즈 클래스 타입");
		logger.info("home0301");
		
		Member member = new Member();
		
		return member;
	}
	
	/*
	 * 	4. 컬렉션 List 타입
	 * 	- JSON 객체 배열 타입의 데이터를 만들어서 반환하는 용도로 사용한다.
	 */
	
	@ResponseBody
	@RequestMapping(value = "/goHome0401", method = RequestMethod.GET)
	public List<Member> home0401(){
		logger.info("컬렉션 List 타입");
		logger.info("home0401");
		
		List<Member> list = new ArrayList<>();
		Member member1 = new Member();
		Member member2 = new Member();
		
		list.add(member1);
		list.add(member2);
		
		return list;
	}
	
	/*
	 * 	5. 컬렉션 Map 타입
	 * 	- Map 형태의 컬렉션 자료를 JSON 객체 타입의 데이터로 만들어서 반환하는 용도로 사용한다.
	 */
	@ResponseBody
	@RequestMapping(value = "/goHome0501", method = RequestMethod.GET)
	public Map<String, Member> home0501() {
		logger.info("컬렉션 Map 타입");
		logger.info("home0401");
		
		Map<String, Member> map = new HashMap<String, Member>();
		Member member1 = new Member();
		Member member2 = new Member();
		map.put("key1", member1);
		map.put("key2", member2);
		
		return map;
	}
	
	/*
	 * 	6. ResponseEntity<Void> 타입
	 * 	- response 할 때 HTTP 헤더 정보와 내용을 가공하는 용도로 사용한다.
	 */
	
	// Void 타입은 아무런 형태가 아닌데 제네릭타입의 뭔가는 채워야겠어서 채우는 Placeholder 같은 느낌
	@ResponseBody
	@RequestMapping(value = "/goHome0601", method = RequestMethod.GET)
	public ResponseEntity<Void> home0601(){
		logger.info("ResponseEntity<Void> 타입");
		logger.info("home0601");
		
		// 내가 요청한 url로 응답이 나가면서 응답데이터로 아무런 값이 전달되지 않는다.
		// 해당 URL 요청 후, 브라우저에서 개발자 도구를 이용해서 네트워크 탭을 확힌해보면 응답으로 해당 URL이 응답으로
		// 나간걸 확인할 수 있다.(상태코드 : 200(OK))
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	/*
	 * 	7. ResponseEntity<String> 타입
	 * 	- response 할 때 HTTP 헤더 정보와 문자열 데이터를 전달하는 용도로 사용한다.
	 */
	
	@ResponseBody
	@RequestMapping(value = "/goHome0701", method = RequestMethod.GET)
	public ResponseEntity<String> home0701(){
		logger.info("ResponseEntity<String> 타입");
		logger.info("home0701");
		
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	/*
	 * 	8. ResponseEntity<자바빈즈 클래스> 타입
	 * 	- response 할 때 HTTP 헤더 정보와 객체 데이터를 전달하는 용도로 사용한다.
	 */
	
	@ResponseBody
	@RequestMapping(value = "/goHome0801", method = RequestMethod.GET)
	public ResponseEntity<Member> home0801(){
		logger.info("ResponseEntity<자바빈즈 클래스> 타입");
		logger.info("home0801");
		Member member = new Member();
		return new ResponseEntity<Member>(member , HttpStatus.OK);
	}
	
	/*
	 * 	9. ResponseEntity<List> 타입
	 * 	- response 할 때 HTTP 헤더 정보와 객체 배열 데이터를 전달하는 용도로 사용한다.
	 */
	
	@ResponseBody
	@RequestMapping(value = "/goHome0901", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> home0901(){
		logger.info("ResponseEntity<List> 타입");
		logger.info("home0901");
		
		List<Member> list = new ArrayList<Member>();
		Member member1 = new Member();
		Member member2 = new Member();
		
		list.add(member1);
		list.add(member2);
		
		return new ResponseEntity<List<Member>>(list , HttpStatus.OK);
	}
	
	/*
	 * 	10. ResponseEntity<Map> 타입
	 * 	- response 할 때 HTTP 헤더 정보와 객체 배열 데이터를 map형태로 전달하는 용도로 사용한다.
	 */
	
	@ResponseBody
	@RequestMapping(value = "/goHome1001", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Member>> home1001(){
		logger.info("ResponseEntity<Map> 타입");
		logger.info("home1001");
		
		Map<String, Member> map = new HashMap<>();
		Member member1 = new Member();
		Member member2 = new Member();
		
		map.put("key1", member1);
		map.put("key2", member2);
		
		return new ResponseEntity<Map<String, Member>>(map , HttpStatus.OK);
	}
	
	/*
	 * 	11. ResponseEntity<byte[]> 타입
	 * 	- response 할 때 HTTP 헤더 정보와 객체 배열 데이터를 전달하는 용도로 사용한다.
	 * 
	 * 	[환경설정] 의존 관계 정의
	 * 	- 파일 데이터를 처리하기 위해서 의존 라이브러리를 추가한다.
	 * 	- pom.xml에서 commons-io dependency를 추가한다.
	 */
	
	@ResponseBody
	@RequestMapping(value = "/goHome1101", method = RequestMethod.GET)
	public ResponseEntity<byte[]> home1101(){
		logger.info("ResponseEntity<byte[]> 타입");
		logger.info("home1101");
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream("D:\\A_TeachingMaterial\\08_Framework\\03.SPRING2\\image\\cat.jpg");
			headers.setContentType(MediaType.IMAGE_JPEG);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// 파일 다운로드 처리
	
	@ResponseBody
	@RequestMapping(value = "/goHome1102", method = RequestMethod.GET)
	public ResponseEntity<byte[]> home1201() throws Exception{
		logger.info("ResponseEntity<byte[]> 타입");
		logger.info("home1102");
		
		String fileNameString = "image.zip";
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream("D:\\A_TeachingMaterial\\08_Framework\\03.SPRING2\\image.zip");
			// MediaType.APPLICATION_OCTET_STREAM은 이진 파일을 위한 기본값입니다.
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=\""
					+ new String(fileNameString.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		return entity;
	}
	
	
}
