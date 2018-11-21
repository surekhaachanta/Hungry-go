package com.food.service;

import java.util.List;

import com.food.models.Cart;
import com.food.models.Item;
import com.food.models.Order;
import com.food.models.User;

public interface CacheService {
	public List<Item> getAllItems();
	void saveUser(User user);
	public void order(Order order);
	void saveCart(List<Cart> cart);
	public List<Cart> getAllCartItems();
	boolean login(User user);
	
}
