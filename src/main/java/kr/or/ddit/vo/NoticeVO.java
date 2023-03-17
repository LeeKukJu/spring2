package kr.or.ddit.vo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NoticeVO {
	private int boNo;
	private int rnum;
	private String boTitle;
	private String boContent;
	private String boWriter;
	private String boDate;
	private String boHit;
	
	private Integer[] delNoticeNo;	// 삭제된 파일번호를 서버로 보내기 위한 필드
	private MultipartFile[] boFile;	// 업로드한 파일이 담길 공간
	// notice : noticeFIel = 1 : N
	private List<NoticeFileVO> noticeFileList;
	
	// 업로드하면 촤라락 셋팅됌
	public void setBoFile(MultipartFile[] boFile) {
		this.boFile = boFile;
		if(boFile != null) {
			List<NoticeFileVO> noticeFileList = new ArrayList<>();
			for (MultipartFile item : boFile) {
				if(StringUtils.isBlank(item.getOriginalFilename())) {
					continue;
				}
				NoticeFileVO noticeFileVO = new NoticeFileVO(item);
				noticeFileList.add(noticeFileVO);
			}
			this.noticeFileList = noticeFileList;
		}
	}
}
