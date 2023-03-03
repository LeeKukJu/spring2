package kr.or.ddit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestHomeController {
	
	/*
	 * 	3. 자바빈즈 클래스 타입
	 * 	- JSON객체 타입의 데이터를 만들어서 반환하는 용도로 사용한다.
	 * 	- 클래스 전체에 @ResponseBody 효과 적용
	 */
	
	@RequestMapping(value = "/goRestHome0301", method = RequestMethod.GET)
	public Member restHome0301() {
		log.info("restHome0301()");
		Member member = new Member();
		return member;
	}
	
	@RequestMapping(value = "/goRestHome0401", method = RequestMethod.GET)
	public List<Member> restHome0401(){
		log.info("restHome0401()");
		List<Member> list = new ArrayList<>();
		Member member1 = new Member();
		Member member2 = new Member();
		
		list.add(member1);
		list.add(member2);
		
		return list;
	}
	
	@RequestMapping(value = "/goRestHome0501", method = RequestMethod.GET)
	public Map<String, Member> restHome0501(){
		log.info("restHome0501()");
		Map<String, Member> map = new HashMap<>();
		Member member1 = new Member();
		Member member2 = new Member();
		map.put("key1", member1);
		map.put("key2", member2);
		return map;
	}
	
	@RequestMapping(value = "/goRestHome0601", method = RequestMethod.GET)
	public ResponseEntity<Void> restHome0601(){
		log.info("restHome0601()");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/goRestHome0701", method = RequestMethod.GET)
	public ResponseEntity<String> restHome0701(){
		log.info("restHome0701()");
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/goRestHome0801", method = RequestMethod.GET)
	public ResponseEntity<Member> restHome0801(){
		log.info("restHome0801()");
		Member member = new Member();
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/goRestHome0901", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> restHome0901(){
		log.info("restHome0901()");
		List<Member> list = new ArrayList<>();
		Member member1 = new Member();
		Member member2 = new Member();
		list.add(member1);
		list.add(member2);
		
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/goRestHome1001", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Member>> restHome1001(){
		log.info("restHome1001()");
		Map<String, Member> map = new HashMap<>();
		Member member1 = new Member();
		Member member2 = new Member();
		map.put("key1", member1);
		map.put("key2", member2);
		
		return new ResponseEntity<Map<String, Member>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/goRestHome1101", method = RequestMethod.GET)
	public ResponseEntity<byte[]> restHome1101() throws IOException{
		log.info("restHome1101()");
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream("D:\\A_TeachingMaterial\\08_Framework\\03.SPRING2\\image\\cat.jpg");
			headers.setContentType(MediaType.IMAGE_JPEG);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		return entity;
	}
	
	@RequestMapping(value = "/goRestHome1102", method = RequestMethod.GET)
	public ResponseEntity<byte[]> restHome1102() throws IOException{
		log.info("restHome1102()");
		
		String fileName = "image.zip";
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream("D:\\A_TeachingMaterial\\08_Framework\\03.SPRING2" + fileName);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=\""
					+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		return entity;
	}
	
	
	
	
}
