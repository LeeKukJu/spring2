package kr.or.ddit.vo;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class Board {
	private int boardNo;
	@NotEmpty
	private String title;
	private String content;
	private String writer;
	private Date regDate;
}
