package kr.or.ddit.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.ItemMapper;
import kr.or.ddit.service.IItemService;
import kr.or.ddit.vo.Item;

@Service
public class ItemServiceImpl implements IItemService {
	
	@Inject
	ItemMapper mapper;
	
	@Override
	public void register(Item item) throws Exception {
		mapper.register(item);
	}

	@Override
	public List<Item> list() throws Exception {
		return mapper.list();
	}

	@Override
	public Item read(int itemId) throws Exception {
		return mapper.read(itemId);
	}

	@Override
	public void modify(Item item) throws Exception {
		mapper.modify(item);
	}

	@Override
	public String getPicture(int itemId) throws Exception {
		return mapper.getPicture(itemId);
	}

	@Override
	public void remove(int itemId) throws Exception {
		mapper.remove(itemId);
	}

}
