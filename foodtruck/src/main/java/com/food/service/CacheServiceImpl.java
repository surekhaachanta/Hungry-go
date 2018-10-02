package com.food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.food.models.Item;
import com.food.models.ItemDao;

@Service
public class CacheServiceImpl implements CacheService {
	@Autowired
	private ItemDao itermDao;
	
	@Override
	@Cacheable("menuItems")
	public List<Item> getAllItems() {
		System.out.println("Iniside getAllItems");
		List<Item> itemList = new ArrayList<>();
		itermDao.findAll().forEach(itemList::add);
		return itemList;
	}

}
