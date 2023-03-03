package kr.or.ddit.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jdk.nashorn.internal.ir.ReturnNode;
import kr.or.ddit.vo.Board;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

	/*
	 *	3장: 컨트롤러 요청 매핑
	 *
	 *	1. 요청 경로 매핑
	 *	- @RequestMapping()의 value 속성에 요청 경로를 설정한다.
	 *
	 *		> 요청 경로는 반드시 설정해야 하는 필수 정보이다.
	 *		> 속성이 하나일 때는 속석명을 생략할 수 있다.
	 *		> 컨트롤러의 클래스 레벨과 메소드 레벨로 지정할 수 있다.
	 *		> 클래스 레벨로 요청 경로를 지정하면 메소드 레벨에서 지정한 경로의 기본 경로로 취급된다.
	 *		> 클래스 레벨의 요청 경로에 메소드 레벨의 요청 경로를 덧붙인 형태가 최종 경로가 된다.
	 *		> return이 없어도 해당 url명과 매핑 되는 jsp 페이지가 있으면 거기로 이동
	 */
	@RequestMapping(value="/register")
	public void registerForm() {
		log.info("요청 경로 매핑");
		log.info("registerForm()");
	}
	
	@RequestMapping(value="/modify")
	public void modifyForm() {
		log.info("요청 경로 매핑");
		log.info("modifyForm()");
	}
	
	@RequestMapping(value="/list")
	public void list() {
		log.info("요청 경로 매핑");
		log.info("list()");
	}
	
	/*
	 *	2. 경로 패턴 매핑
	 *	- 요청 경로를 동적으로 표현이 가능한 경로 패턴을 지정할 수 있다.
	 *
	 * 		> URL 경로 상의 변하는 값을 경로 변수로 취급한다.
	 * 		> 경로 변수에 해당하는 값을 파라미터 변수에 설정할 수 있다.
	 * 	- 변수 다르게 하고 싶으면  @PathVariable("url에 있는 {변수명}")
	 */
	
	// @PathVariable 어노테이션은 경로상에 포함되어 있는 파라미터를 받을 때 사용한다.
	@RequestMapping("/read/{boardNo}")
	public String read(@PathVariable int boardNo) {
		log.info("경로 패턴 매핑");
		log.info("read()");
		log.info("boardNo : " + boardNo);
		return "board/read";
	}
	
	/*
	 *	3. HTTP 메서드 매핑
	 *	- method 속성을 사용하여 HTTP 메서드를 매핑 조건으로 지정할 수 있다.
	 *		화면으로 응답하는 경우에는 HTTP 메서드로 GET 방식과  POST 방식 두가지를 사용할 수 있다.
	 *
	 *		> method = RequestMapping.GET, method = RequestMapping.POST
	 *
	 *	[참고 사항]
	 *	- 관련 컨트롤러 메소드는 HomeController에서 formHome 메서드로 작동한다.
	 *	- 클래스 : HomeController
	 */
	
	// register 경로에 GET방식으로 요청
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerFormGet() {
		log.info("HTTP 메서드 매핑");
		log.info("registerFormGet()");
		return "success";
	}
	
	// register 경로에 POST방식으로 요청
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register() {
		log.info("HTTP 메서드 매핑");
		log.info("register()");
		return "success";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public String modifyFormGet() {
		log.info("HTTP 메서드 매핑");
		log.info("modifyFormGet()");
		return "success";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modify() {
		log.info("HTTP 메서드 매핑");
		log.info("modify()");
		return "success";
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String remove() {
		log.info("HTTP 메서드 매핑");
		log.info("remove()");
		return "success";
	}
	
//	@RequestMapping(value="/list", method = RequestMethod.GET)
//	public String listGet() {
//		log.info("HTTP 메서드 매핑");
//		log.info("listGet()");
//		return "success";
//	}
	
	/*
	 *	4. Params 매핑 
	 *	- 요청 파라미터를 매핑 조건으로 지정하는 경우에는 params 속성을 사용한다.
	 *		버튼이나 링크에 따라 호출할 메서드를 바꿔야 할 때 사용한다.
	 *
	 *		> params = "register", params = "modify"
	 *
	 *	[참고 사항]
	 *	- 3번 listGet() 주석 후 테스트 진행
	 */
	
	@RequestMapping(value="/get", method = RequestMethod.GET, params = "register")
	public String registerFormParams() {
		log.info("Param 매핑");
		log.info("registerFormParams()");
		return "board/register";
	}
	
	@RequestMapping(value="/post", method = RequestMethod.POST, params = "register")
	public String registerParams() {
		log.info("Param 매핑");
		log.info("registerParams()");
		return "board/register";
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET, params = "modify")
	public String modifyFormParams() {
		log.info("Param 매핑");
		log.info("modifyFormParams()");
		return "board/modify";
	}
	
	@RequestMapping(value="/post", method = RequestMethod.POST, params = "modify")
	public String modifyParams() {
		log.info("Param 매핑");
		log.info("modifyParams()");
		return "board/modify";
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET, params = "remove")
	public String removeFormParams() {
		log.info("Param 매핑");
		log.info("removeFormParams()");
		return "board/remove";
	}
	
	@RequestMapping(value="/post", method = RequestMethod.POST, params = "remove")
	public String removeParams() {
		log.info("Param 매핑");
		log.info("removeParams()");
		return "board/remove";
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET, params = "list")
	public String listParams() {
		log.info("Param 매핑");
		log.info("listParams()");
		return "board/list";
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET, params = "read")
	public String readParams() {
		log.info("Param 매핑");
		log.info("readParams()");
		return "board/read";
	}
	
	/*
	 *	5. Headers 매핑
	 *	- 요청 헤더를 매핑 조건으로 지정하는 경우에는 headers 속성을 사용한다.
	 *
	 *	[환경설정] 의존 관계 정의
	 *	- JSON 데이터를 처리하기 위해서 의존 라이브러리를 추가한다.
	 *	- pom.xml에서 jackson-databind dependency를 추가한다.
	 *
	 *	HTTP Method 종류
	 *	- GET		: 조회
	 *	- POST		: 등록
	 *	- PUT		: 수정
	 *	- DELETE	: 삭제
	 */
	
	
	/*
	 * @RequestBody
	 * - 비동기방식이면서 POST로 json형식의 데이터를 보낼때는 body에서 데이터를 꺼내오기 위해서는 @RequestBody 어노테이션을
	 * 	사용해야만 한다.
	 */
	@RequestMapping(value="/{boardNo}", method = RequestMethod.PUT)
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board){
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		log.info("Headers 매핑");
		log.info("modify()");
		log.info("boardNo : " + boardNo);
		log.info("board : " + board.toString());
		return entity;
	}
	
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT, headers = "X-HTTP-Method-Override=PUT")
	public ResponseEntity<String> modifyByHeader(@PathVariable("boardNo") int boardNo, @RequestBody Board board){
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		log.info("Headers 매핑");
		log.info("modifyHeader()");
		log.info("boardNo : " + boardNo);
		log.info("board : " + board.toString());
		return entity;
	}
	
	/*
	 * 6. Content Type 매핑
	 * - 요청의 Content-Type 헤더 값을 매핑 조건으로 지정하는 경우에는 consumes 속성을 사용한다.
	 * 
	 * [환경설정] 의존 관계 정의
	 * - XML 데이터를 처리하기 위해서 의존 라이브러리를 추가한다.
	 * - pom.xml에서 jackson-dataformat-xml dependency를 추가한다.
	 */
	
	// 요청 본문의 미디어 타입을 지정하지 않으면 기본값인 "application/json" 미디어 타입으로 지정된다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.POST)
	public ResponseEntity<String> modifyContentTypePost(@PathVariable("boardNo") int boardNo, @RequestBody Board board){
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		log.info("Content Type 매핑");
		log.info("modifyContentTypePost()");
		log.info("boardNo : " + boardNo);
		log.info("board : " + board.toString());
		
		return entity;
	}
	
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT, consumes = "appliction/json")
	public ResponseEntity<String> modifyContentTypebyJson(@PathVariable("boardNo") int boardNo, @RequestBody Board board){
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		log.info("Content Type 매핑");
		log.info("modifyContentTypeByJson()");
		log.info("boardNo : " + boardNo);
		log.info("board : " + board.toString());
		
		return entity;
	}
	
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT, consumes = "appliction/xml")
	public ResponseEntity<String> modifyContentTypeByXml(@PathVariable("boardNo") int boardNo, @RequestBody Board board){
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		log.info("Content Type 매핑");
		log.info("modifyContentTypeByXml()");
		log.info("boardNo : " + boardNo);
		log.info("board : " + board.toString());
		
		return entity;	
	}
	
	/*
	 * 	7. Accept 매핑 ★중요
	 *  - 요청 Accept 헤더 값을 매핑 조건으로 지정하는 경우에는 produces 속성을 사용한다.
	 *  - produces 속성은 응답으로 나가는 타입을 설정할 때 사용한다. 
	 */
	// produces 속성값을 지정하지 않으면 기본값인 "application/json" 미디어 타입으로 지정된다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET)
	public ResponseEntity<Board> readGet(@PathVariable("boardNo") int boardNo){
		log.info("Accept 매핑");
		log.info("readGet()");
		log.info("boardNo : " + boardNo);
		
		Board boardVO = new Board();
		boardVO.setTitle("제목1");
		boardVO.setContent("내용1");;
		boardVO.setWriter("홍길동");
		boardVO.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(boardVO, HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Board> readToJson(@PathVariable("boardNo") int boardNo, Board board){
		log.info("Accept 매핑");
		log.info("readToJson()");
		log.info("boardNo : " + boardNo);
		log.info("board : " + board.toString());
		
		String addStr = "_json";
		Board boardVO = new Board();
		boardVO.setTitle("제목1");
		boardVO.setContent("내용1");;
		boardVO.setWriter("홍길동");
		boardVO.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(boardVO, HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET, produces = "application/xml")
	public ResponseEntity<Board> readToXml(@PathVariable("boardNo") int boardNo, Board board){
		log.info("Accept 매핑");
		log.info("readToXml()");
		log.info("boardNo : " + boardNo);
		log.info("board : " + board.toString());
		
		String addStr = "_xml";
		Board boardVO = new Board();
		boardVO.setTitle("제목1");
		boardVO.setContent("내용1");;
		boardVO.setWriter("홍길동");
		boardVO.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(boardVO, HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String boardSearch(String keyword, Model model) {
		model.addAttribute("keyword", keyword);
		return "board/search";
	}
	
}






















