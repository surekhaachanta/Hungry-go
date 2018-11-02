package com.food.service;

import java.util.List;

import com.food.models.Item;
import com.food.models.User;

public interface CacheService {
	public List<Item> getAllItems();
	void saveUser(User user);
	public boolean login(String payload);
}
