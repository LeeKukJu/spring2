package kr.or.ddit.mapper;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.test.DDITBoardVO;
import kr.or.ddit.vo.test.DDITTagVO;

public interface DDITBoardMapper {

	void create(DDITBoardVO board) throws Exception;

	void createTag(DDITTagVO tag) throws Exception;

	DDITBoardVO view(int boNo) throws Exception;

	void update(DDITBoardVO board) throws Exception;

	void deleteTag(int boNo) throws Exception;

	List<DDITBoardVO> list() throws Exception;

	public void remove(int boNo) throws Exception;

	void increaseHit(int boNo) throws Exception;

	List<DDITBoardVO> search(Map<String, String> searchMap);




}
