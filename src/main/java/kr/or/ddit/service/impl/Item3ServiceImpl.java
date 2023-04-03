package kr.or.ddit.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.Item3Mapper;
import kr.or.ddit.service.IItem3Service;
import kr.or.ddit.vo.Item3;

@Service
public class Item3ServiceImpl implements IItem3Service {
	
	@Inject
	private Item3Mapper mapper;
	
	@Override
	public void register(Item3 item) throws Exception {
		mapper.register(item);
		
		String[] files = item.getFiles();
		
		if(files == null) {
			return;
		}
		
		for (String fileName : files) {
			mapper.addAttach(fileName);
		}
	}

	@Override
	public List<Item3> list() throws Exception {
		return mapper.list();
	}

	@Override
	public Item3 read(int itemId) throws Exception {
		return mapper.read(itemId);
	}

	@Override
	public List<String> getAttach(int itemId) throws Exception {
		return mapper.getAttach(itemId);
	}

	@Override
	public void modify(Item3 item) throws Exception {
		mapper.modify(item);
		
		int itemId = item.getItemId();
		mapper.deleteAttach(itemId);
		String[] files = item.getFiles();
		
		if(files == null) {
			return;
		}
		
		for (String fileName : files) {
			mapper.replaceAttach(fileName, itemId);
			
		}
		
	}

	@Override
	public void remove(int itemId) throws Exception {
		mapper.deleteAttach(itemId);
		mapper.remove(itemId);
	}
}
