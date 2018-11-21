package com.food.service;

import java.util.List;

import com.food.models.Item;
import com.food.models.Order;
import com.food.models.User;

public interface CacheService {
	public List<Item> getAllItems();
	void saveUser(User user);
	public void order(Order order);
	boolean login(User user);
	public List<Order> getAllorders();
	public int changeStatus(Order order);
	public int changeTruck(Order order);
	
}
