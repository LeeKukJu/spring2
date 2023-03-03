package kr.or.ddit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.BoardMapper;
import kr.or.ddit.vo.Board;

@Service
public class BoardServiceImpl implements IBoardService {
	
	@Inject
	private BoardMapper mapper;
	
	@Override
	public void register(Board board) throws Exception {
		mapper.create(board);
	}

	@Override
	public List<Board> list() throws Exception{
		return mapper.list();
	}

	@Override
	public Board read(int boardNo) throws Exception {
		Board board = mapper.read(boardNo);
		return board;
	}

	@Override
	public void update(Board board) throws Exception {
		mapper.update(board);
	}

	@Override
	public void remove(int boardNo) throws Exception {
		mapper.remove(boardNo);
	}

	@Override
	public List<Board> search(Board board) throws Exception {
		return mapper.search(board);
	}

}
