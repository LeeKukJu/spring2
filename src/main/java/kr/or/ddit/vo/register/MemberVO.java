package kr.or.ddit.vo.register;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberVO {
	private String userId;
	private String password;
	private String userName;
	private String email;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date dateOfBirth;
	private String gender;
	private String developer;
	private boolean foreigner;
	private String nationality;
	private String[] cars;
	private String[] hobby;
	private AddressVO address;
	private String introduction;
}
