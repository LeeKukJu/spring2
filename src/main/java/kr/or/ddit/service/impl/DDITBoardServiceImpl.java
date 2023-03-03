package kr.or.ddit.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.DDITBoardMapper;
import kr.or.ddit.service.IDDITBoardService;
import kr.or.ddit.vo.test.DDITBoardVO;
import kr.or.ddit.vo.test.DDITTagVO;

@Service
public class DDITBoardServiceImpl implements IDDITBoardService {
	
	@Inject
	private DDITBoardMapper mapper;

	@Override
	public void register(DDITBoardVO board) throws Exception {
		mapper.create(board);
		
		List<DDITTagVO> tagList = board.getTagList();
		
		for (int i = 0; i < tagList.size(); i++) {
			
			if(tagList.get(i).getTagName() == null) {
				continue;
			}
			
			if(tagList.get(i).getTagName().trim().length() == 0) {
				continue;
			}
			
			DDITTagVO tag = new DDITTagVO();
			tag.setBoNo(board.getBoNo());
			tag.setTagName(tagList.get(i).getTagName());
			
			mapper.createTag(tag);
		}
		
	}

	@Override
	public DDITBoardVO view(int boNo) throws Exception {
		
		mapper.increaseHit(boNo);
		
		return mapper.view(boNo);
	}

	@Override
	public void update(DDITBoardVO board) throws Exception {
		mapper.update(board);
		
		int boNo = board.getBoNo();
		mapper.deleteTag(boNo);
		
		List<DDITTagVO> tagList = board.getTagList();
		
		for (int i = 0; i < tagList.size(); i++) {
			
			if(tagList.get(i).getTagName() == null) {
				continue;
			}
			
			if(tagList.get(i).getTagName().trim().length() == 0) {
				continue;
			}
			
			DDITTagVO tag = new DDITTagVO();
			tag.setBoNo(board.getBoNo());
			tag.setTagName(tagList.get(i).getTagName());
			
			mapper.createTag(tag);
		}
	}

	@Override
	public List<DDITBoardVO> list() throws Exception {
		return mapper.list();
	}

	@Override
	public void remove(int boNo) throws Exception {
		
		DDITBoardVO board = mapper.view(boNo);
		
		List<DDITTagVO> tagList = board.getTagList();
		
		if(tagList.size() > 0) {
			mapper.deleteTag(boNo);
		}
		
		mapper.remove(boNo);
	}

	@Override
	public List<DDITBoardVO> search(Map<String, String> searchMap) {
		return mapper.search(searchMap);
	}
	


}
