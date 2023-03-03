package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.test.DDITBoardVO;

public interface IDDITBoardService {

	void register(DDITBoardVO board) throws Exception;

	DDITBoardVO view(int boNo) throws Exception;

	void update(DDITBoardVO board) throws Exception;

	List<DDITBoardVO> list() throws Exception;

	void remove(int boNo) throws Exception;

	List<DDITBoardVO> search(Map<String, String> searchMap);

	

}
