package kr.or.ddit.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.controller.noticeboard.web.TelegramSendController;
import kr.or.ddit.mapper.LoginMapper;
import kr.or.ddit.mapper.NoticeMapper;
import kr.or.ddit.mapper.ProfileMapper;
import kr.or.ddit.service.INoticeService;
import kr.or.ddit.vo.NoticeFileVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;
import kr.or.ddit.vo.test.DDITMemberVO;

@Service
public class NoticeServiceImpl implements INoticeService {

	@Inject
	private NoticeMapper noticeMapper;
	@Inject
	private LoginMapper loginMapper;
	@Inject
	private ProfileMapper profileMapper;

	TelegramSendController tst = new TelegramSendController();

	@Override
	public ServiceResult insertNotice(HttpServletRequest req, NoticeVO noticeVO) throws Exception {
		ServiceResult result = null;
		int status = noticeMapper.insertNotice(noticeVO);

		if (status > 0) { // 성공
			// 넘겨받은 데이터 중, 파일 데이터들을 등록 처리
			List<NoticeFileVO> noticeFileList = noticeVO.getNoticeFileList();
			processNoticeFile(noticeFileList, noticeVO.getBoNo(), req);

			try {
				tst.sendGet("이국주", noticeVO.getBoTitle());
			} catch (Exception e) {
				e.printStackTrace();
			}
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public NoticeVO selectNotice(int boNo) {
		noticeMapper.incrementHit(boNo); // 조회수 증가

		return noticeMapper.selectNotice(boNo); // 증가된 조회수를 포함한 공지사항 게시글 정보
	}

	@Override
	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO) {
		return noticeMapper.selectNoticeCount(pagingVO);
	}

	@Override
	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO) {
		return noticeMapper.selectNoticeList(pagingVO);
	}

	@Override
	public ServiceResult updateNotice(HttpServletRequest req, NoticeVO notice) {
		ServiceResult result = null;
		int cnt = noticeMapper.updateNotice(notice);
		if (cnt > 0) {
			List<NoticeFileVO> noticeFileList = notice.getNoticeFileList();
			try {
				processNoticeFile(noticeFileList, notice.getBoNo(), req);
				Integer[] delNoticeNo = notice.getDelNoticeNo();
				if (delNoticeNo != null) {
					for (int i = 0; i < delNoticeNo.length; i++) {
						NoticeFileVO noticeFileVO = noticeMapper.selectNoticeFile(delNoticeNo[i]);
						noticeMapper.deleteNoticeFile(delNoticeNo[i]);
						File file = new File(noticeFileVO.getFileSavepath());
						file.delete();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public ServiceResult deleteNotice(int boNo, HttpServletRequest req) {
		ServiceResult result = null;
		NoticeVO noticeVO = noticeMapper.selectNotice(boNo);
		noticeMapper.deleteNoticeFileByBoNo(boNo);
		int cnt = noticeMapper.deleteNotice(boNo);
		if (cnt > 0) {
			List<NoticeFileVO> noticeFileList = noticeVO.getNoticeFileList();
			try {
				if (noticeFileList != null) {
					String[] filePath = noticeFileList.get(0).getFileSavepath().split("/");
					int cutNum = noticeFileList.get(0).getFileSavepath().lastIndexOf(filePath[filePath.length - 1]);
					String path = noticeFileList.get(0).getFileSavepath().substring(0, cutNum);
					deleteFolder(req, path);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	private void deleteFolder(HttpServletRequest req, String path) {
		File folder = new File(path);
		try {
			if (folder.exists()) {
				File[] folderList = folder.listFiles();

				for (int i = 0; i < folderList.length; i++) {
					if (folderList[i].isFile()) { // 폴더안의 있는 파일이 파일일 때
						folderList[i].delete();
					} else { // 폴더안의 있는 파일이 폴더일 때 재귀함수 호출(폴더안으로 들어가기 위한 호출)
						deleteFolder(req, folderList[i].getPath());
					}
				}
				folder.delete(); // 폴더 삭제
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ServiceResult idCheck(String memId) {
		ServiceResult result = null;
		DDITMemberVO member = loginMapper.idCheck(memId);

		if (member != null) {
			result = ServiceResult.EXIST;
		} else {
			result = ServiceResult.NOTEXIST;
		}

		return result;

	}

	@Override
	public ServiceResult signup(DDITMemberVO memberVO, HttpServletRequest req) {
		ServiceResult result = null;

		String uploadPath = req.getServletContext().getRealPath("/resources/profile");
		File file = new File(uploadPath);
		if (!file.exists()) {
			file.mkdirs();
		}

		String profileImg = "";
		try {
			MultipartFile profileImgFile = memberVO.getImgFile();
			if (profileImgFile.getOriginalFilename() != null && !profileImgFile.getOriginalFilename().equals("")) {
				String fileName = UUID.randomUUID().toString();
				fileName += "_" + profileImgFile.getOriginalFilename();
				uploadPath += "/" + fileName;
				profileImgFile.transferTo(new File(uploadPath));
				profileImg = "/resources/profile/" + fileName;
			}
			memberVO.setMemProfileImg(profileImg);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int status = loginMapper.signup(memberVO);

		if (status > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public DDITMemberVO loginCheck(DDITMemberVO member) {
		return loginMapper.loginCheck(member);
	}

	@Override
	public String findId(DDITMemberVO member) {

		return loginMapper.findId(member);
	}

	@Override
	public String findPw(DDITMemberVO member) {

		return loginMapper.findPw(member);
	}

	private void processNoticeFile(List<NoticeFileVO> noticeFileList, int boNo, HttpServletRequest req)
			throws Exception {
		if (noticeFileList != null && noticeFileList.size() > 0) { // 파일 데이터가 무조건 있음
			for (NoticeFileVO noticeFileVO : noticeFileList) {
				String savedName = UUID.randomUUID().toString(); // UUID를 활용한 파일 명 생성
				// UUID를 활용해 만든 파일명_원본파일명(원본파일명에서 공백이 있는 경우 공백을 전부 _로 대체
				savedName = savedName + "_" + noticeFileVO.getFileName().replaceAll(" ", "_");
				String endFilename = noticeFileVO.getFileName().split("\\.")[1]; // 확장자 추출(디버깅시 사용)
				String saveLocate = req.getServletContext().getRealPath("/resources/notice/" + boNo);

				File file = new File(saveLocate);
				if (!file.exists()) {
					file.mkdirs();
				}

				saveLocate += "/" + savedName;
				File saveFile = new File(saveLocate);
				noticeFileVO.setBoNo(boNo);
				noticeFileVO.setFileSavepath(saveLocate);
				noticeMapper.insertNoticeFile(noticeFileVO);

				// 방법1
				noticeFileVO.getItem().transferTo(saveFile); // 파일 복사

				// 방법2
//				InputStream is = noticeFileVO.getItem().getInputStream();
//				FileUtils.copyInputStreamToFile(is, saveFile);
//				is.close();
			}

		}
	}

	@Override
	public List<NoticeVO> selectListNotice() {
		return noticeMapper.selectListNotice();
	}

	@Override
	public NoticeFileVO noticeDownload(int fileNo) {
		NoticeFileVO noticeFileVO = noticeMapper.noticeDownload(fileNo);
		if (noticeFileVO == null) {
			throw new RuntimeException();
		}
		noticeMapper.incrementNoticeDowncount(fileNo); // 다운로드 횟수 증가

		return noticeFileVO;
	}

	@Override
	public DDITMemberVO selectMember(DDITMemberVO sessionMember) {
		return profileMapper.selectMember(sessionMember);
	}

	@Override
	public ServiceResult profileUpdate(HttpServletRequest req, DDITMemberVO memberVO) {
		ServiceResult result = null;

		String uploadPath = req.getServletContext().getRealPath("/resources/profile");
		File file = new File(uploadPath);
		if (!file.exists()) {
			file.mkdirs();
		}

		String profileImg = "";
		try {
			MultipartFile profileImgFile = memberVO.getImgFile();
			if (profileImgFile.getOriginalFilename() != null && !profileImgFile.getOriginalFilename().equals("")) {
				String fileName = UUID.randomUUID().toString();
				fileName += "_" + profileImgFile.getOriginalFilename();
				uploadPath += "/" + fileName;
				profileImgFile.transferTo(new File(uploadPath));
				profileImg = "/resources/profile/" + fileName;
			}
			memberVO.setMemProfileImg(profileImg);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int status = profileMapper.profileUpdate(memberVO);

		if (status > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

}
