package kr.or.ddit.vo.test;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class DDITBoardVO {
	private int boNo;
	private String boTitle;
	private String boContent;
	private String boWriter;
	private Date boDate;
	private int boHit;
	private List<DDITTagVO> tagList;
}
