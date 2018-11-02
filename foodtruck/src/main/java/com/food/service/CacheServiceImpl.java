package com.food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.food.dao.ItemDataService;
import com.food.dao.UserDataService;
import com.food.models.Item;
import com.food.models.User;

@Service
public class CacheServiceImpl implements CacheService {
	@Autowired
	private ItemDataService itemDataService;

	@Autowired
	private UserDataService userDataService;

	@Override
	@Cacheable("menuItems")
	public List<Item> getAllItems() {
		System.out.println("Iniside getAllItems");
		List<Item> itemList = new ArrayList<>();
		itemDataService.findAll().forEach(itemList::add);
		return itemList;
	}

	@Override
	@Cacheable("userDetails")
	public void saveUser(User user) {
		System.out.println("Iniside save uSer");
		userDataService.save(user);
	}

	@Override
	public boolean login(String user) {
		System.out.println(user);
		boolean isValidUser = false;
		return isValidUser;

	}

}
