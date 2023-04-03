package kr.or.ddit.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.Item2Mapper;
import kr.or.ddit.service.IItem2Service;
import kr.or.ddit.vo.Item2;

@Service
public class Item2ServiceImpl implements IItem2Service {
	
	@Inject
	private Item2Mapper mapper;	
	
	@Override
	public void register(Item2 item) throws Exception {
		mapper.register(item);
	}

	@Override
	public List<Item2> list() throws Exception {
		return mapper.list();
	}

	@Override
	public Item2 read(int itemId) throws Exception {
		return mapper.read(itemId);
	}

	@Override
	public void modify(Item2 item) throws Exception {
		mapper.modify(item);
	}

	@Override
	public String getPicture(int itemId) throws Exception {
		return mapper.getPicture(itemId);
	}

	@Override
	public String getPicture2(int itemId) throws Exception {
		return mapper.getPicture2(itemId);
	}

	@Override
	public void remove(int itemId) throws Exception {
		mapper.remove(itemId);
	}

}
