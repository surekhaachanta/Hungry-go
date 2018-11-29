package com.food.service;

import java.util.List;

import com.food.models.Item;
import com.food.models.Order;
import com.food.models.User;

public
interface CacheService {
	List<Item> getAllItems();

	void evictMenuItems();

	void saveUser(User user);

	void order(Order order);

	boolean login(User user);

	List<Order> getAllorders();

	int changeStatus(Order order);

	int changeTruck(Order order);

}
